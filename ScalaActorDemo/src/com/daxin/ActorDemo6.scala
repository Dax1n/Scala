package com.daxin

/**
 * Created by 青春常驻Dax1n on 2016/9/26.
 *
 * 单机版多线程：wordcount
 *
 * Actor 消息：
 *
 * 必须看的小故事：（原理）
 *
 *
 *小明同学上网络课程，一天做题需要不会的题目了，于是给他的老师Actor发送了一个消息，
 *当老师接受到消息之后，让助理sender回复小明一个网址addr，并告诉小明你轮询访问这个网址，
 *如果这个网址使用了的话，证明老师的已经计算完毕小明的问题，并且把小明的问题的答案写到了网址上。
 *如果访问这个网址一直是不可用状态证明老师可能忙于其他工作还没有计算题目或者还没有计算完毕答案，
 *这时候小明需要一直轮训访问网站监测老师是否计算完毕。
 *
 *
 */
import java.io.File

import scala.actors.{Actor, Future}
import scala.collection.mutable
import scala.io.Source


//SubmitTask样例类
case class SubmitTask(fileName: String)

//StopTask样例类
case object StopTask

//ResultTask样例类
case class ResultTask(result: Map[String, Int])



class Task extends Actor {

  override def act(): Unit = {
    loop {
      react {
        case SubmitTask(fileName) => {
          val contents = Source.fromFile(new File(fileName)).mkString
          val arr = contents.split("\r\n")
          val result = arr.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.length)
          //val result = arr.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
          sender ! ResultTask(result)//异步无返回值的发送消息
        }
        case StopTask => {
          exit()
        }
      }
    }
  }
}

object WorkCount {
  def main(args: Array[String]) {
    //输入文件
    val files = Array("E://ScalaWorkSpace//words.txt", "E://ScalaWorkSpace//words.log")

    //replaySet 用来存储结果是否计算完毕
    val replaySet = new mutable.HashSet[Future[Any]]//存储的相当于小故事中网址是否可用的状态

    //真正的用来存储结果数据的集合
    val resultList = new mutable.ListBuffer[ResultTask]//相当于网站可以使用时候，存储老师的答案数据

    //对每一个文件创建一个任务
    for (f <- files) {
      val t = new Task
      val replay = t.start() !! SubmitTask(f)//启动actor并发送消息
      replaySet += replay//将结果状态存储起来
    }

    //判断结果是否计算完毕？
    while (replaySet.size > 0) {//处理计算完毕的数据
      //过滤结果计算完毕的结果
      val toCumpute = replaySet.filter(_.isSet)
      for (r <- toCumpute) {
        val result = r.apply()
        resultList += result.asInstanceOf[ResultTask]//结果累加
        replaySet.remove(r)//将计算完毕的结果在状态集合中删除
      }
      Thread.sleep(100)
    }

//    println("resultList : "+resultList)
    //合并两个任务的结果数据
    val finalResult = resultList.map(_.result).flatten.groupBy(_._1).mapValues(x => x.foldLeft(0)(_ + _._2))
    println(finalResult)
  }
}

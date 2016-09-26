package com.daxin

import scala.actors.Actor

import scala.actors.Actor

/**
 * Created by ZX on 2016/4/4.
 */
class MyActor extends Actor {

  override def act(): Unit = {
    while (true) {//死循环一直等待接收消息
      receive {  //receive是Actor的方法，重写了receive方法

        //对接收到的消息进行模式匹配分别处理
        case "start" => {
          println("starting ...")
          Thread.sleep(5000)
          println("started")
        }
        case "stop" => {
          println("stopping ...")
          Thread.sleep(5000)
          println("stopped ...")
        }
      }
    }
  }
}


//  发送消息：
//  !	    发送异步消息，没有返回值。
//  !?	  发送同步消息，等待返回值。
//  !!	  发送异步消息，返回值是 Future[Any]。
object MyActor {
  def main(args: Array[String]) {
    val actor = new MyActor//创建一个Actor
    actor.start()//启动Actor
    actor ! "start"//发送消息
    actor ! "stop"//发送消息
    println("消息发送完成！")
  }
}

/**
 * 说明：在act()方法中加入了while (true) 循环，就可以不停的接收消息
 *注意：发送start消息和stop的消息是异步的，但是Actor接收到消息执行的过程是同步的按顺序执行
 *
 */

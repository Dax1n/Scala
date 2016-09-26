package com.daxin

/**
 * Created by 青春常驻Dax1n on 2016/9/26.
 *
 * react方式会复用线程，比receive更高效
 *
 *
 */

import scala.actors.Actor

class ActorDemo4 extends Actor {

  //重要重要重要重要重要
  // react 如果要反复执行消息处理，react外层要用loop，不能用while
  // react 如果要反复执行消息处理，react外层要用loop，不能用while
  // react 如果要反复执行消息处理，react外层要用loop，不能用while
  override def act(): Unit = {
    loop {// loop的功能类似于while(true)，优点是底层共用线程池效率高
      react {//react方法相当于receive方法
        case "start" => {
          println("starting ...")
          Thread.sleep(5000)
          println("started")
        }
        case "stop" => {
          println("stopping ...")
          Thread.sleep(8000)
          println("stopped ...")
        }

        case "exit" =>{
          exit()
        }
      }
    }
  }
}


object ActorDemo4 {
  def main(args: Array[String]) {
    val actor = new ActorDemo4
    actor.start()
    actor ! "start"
    actor ! "stop"
    println("消息发送完成！")//主线程优先级高，所以你会看到这一行先输出
    actor ! "exit"
  }
}

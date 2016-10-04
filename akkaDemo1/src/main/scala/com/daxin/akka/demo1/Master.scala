package com.daxin.akka.demo1  

import akka.actor.Actor
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props

/**
 *
 * 模拟Spark的源码
 *
 *
 * eclipse有点小坑，每次创建完毕文件是gbk,手动修改utf-8
 *
 *
 */

class Master extends Actor {

  println("Master Constructot invoked .")

  //Actor 声明周期方法：preStart

  /**
   * 构造方法之后调用
   */
  override def preStart(): Unit = {
    println("preStart invoked ...")
  }

  //用于接收消息
  override def receive: Actor.Receive = {
    //   type Receive = PartialFunction[Any, Unit]  ，Receive是一个偏函数

    case "connected" => {
      println("a client connected ...")
      
      //回复worker消息
      sender ! "reply"
      
    }

    case "close" => {
      println("a client closed ...")
    }

  }

}

object Master {

  def main(args: Array[String]): Unit = {
    //ActorSystem是老大，辅助创建和监控其下面的Actor，它是单例

    val host="127.0.0.1";
    val port=9998
    

    
   //配置
    val configStr=s"""
      |akka.actor.provider= "akka.remote.RemoteActorRefProvider"
      |akka.remote.netty.tcp.hostname="$host"
      |akka.remote.netty.tcp.port="$port"
      """.stripMargin
     //    ConfigFactory是akka包下的
    val config = ConfigFactory.parseString(configStr)

    val actorSystem = ActorSystem("MasterSystem", config);
    
    //创建actor实例,  第二个参数是名字
    val actor= actorSystem.actorOf(Props(new Master),"Master")
   
     actor ! "close"
  
   //停止程序
  // actorSystem.awaitTermination()  
   
  }
}




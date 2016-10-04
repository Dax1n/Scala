package com.daxin.akka.demo1

import akka.actor.Actor
import akka.actor.ActorSelection
import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import akka.actor.Props

class Worker extends Actor {

  //为了以后能引用，作为成员变量
  var master: ActorSelection = _

  override def preStart(): Unit = {
    //构造方法执行完毕之后执行preStart方法，所以在preStart完成连接比较好

    //第一步建立连接
    //第二步拿到master代理对象
    /**
     * akka.tcp://MasterSystem@127.0.0.1:9998
     *
     * akka.tcp://MasterSystem@ 协议
     *
     * ip是Master的IP
     *
     * 端口是Master的Port
     *
     * /user是akka的规定
     *
     * /Master中的Master是创建Master名字，和Master中对应
     *
     */
    master = context.actorSelection("akka.tcp://MasterSystem@127.0.0.1:9998/user/Master")

    //第三步向master代理对象发送消息

    //master ! "connected"  就是相当于worker向master发送消息。（不要因为不是work调用方法发消息就以为不是work向master发消息）
    //可以理解为在worker中向master发消息
    master ! "connected"

    //第四步 master向worker反馈消息
    //在master中实现

  }

  override def receive: Actor.Receive = {
    case "reply" => { println("a reply from master") }
  }
}

object Worker {

  def main(args: Array[String]): Unit = {
    val host = "127.0.0.1";
    val port = 9999


    //配置,坑死爹了
    //之前下面三个配置写错了，结果一顿报错：[INFO] [10/04/2016 09:30:06.879] [WorkerSystem-akka.actor.default-dispatcher-4] [akka://WorkerSystem/deadLetters] Message [java.lang.String] from Actor[akka://WorkerSystem/user/Worker#991353858] to Actor[akka://WorkerSystem/deadLetters] was not delivered. [1] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.

    val configStr = s"""
      |akka.actor.provider= "akka.remote.RemoteActorRefProvider"
      |akka.remote.netty.tcp.hostname="$host"
      |akka.remote.netty.tcp.port="$port"
      """.stripMargin
    //    ConfigFactory是akka包下的
    val config = ConfigFactory.parseString(configStr)

    val actorSystem = ActorSystem("WorkerSystem", config);
    //创建actor实例,  第二个参数是名字
    val actor = actorSystem.actorOf(Props(new Worker), "Worker")

    /**
     * 发送消息的内容在preStart中了，程序启动会自动调用
     */

    //停止程序
    //actorSystem.awaitTermination()  

  }
}



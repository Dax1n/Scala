package com.daxin.akka.demo1

import akka.actor.Actor
import akka.actor.ActorSelection
import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import akka.actor.Props
import java.util.UUID
//下滑线导入duration所有的类
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class Worker extends Actor {

  //为了以后能引用，作为成员变量
  var master: ActorSelection = _

  val workerID = UUID.randomUUID().toString()
  
  override def preStart(): Unit = {
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

    //使用java的UUID生成Worker的ID
    

    master ! RegisterWorker(workerID, 1024, 2) //

    //第四步 master向worker反馈消息
    //在master中实现

  }

  override def receive: Actor.Receive = {
    case "reply" => { println("a reply from master") }
    
    case RegisteredWorker(masterUrl:String)=>{
      println(s"收到来至于Master的连接应答...,Master URL :$masterUrl")
    
      //定时发送心跳 
      //context的类型是ActorContext
      
      // final def schedule(initialDelay: FiniteDuration,interval: FiniteDuration,receiver: ActorRef,message: Any)
     //以后延迟和时间间隔都可以使用配置文件配置，此Demo略
      //此处是worker先自己给自己发送心跳，这样做的目的是为了以后不同情况可以在worker内部做判断处理在发送心跳
      //SendHeartBeat是一个case object
      context.system.scheduler.schedule(10 millis,10000 millis,self,SendHeartBeat)
    
    }
    
    //这个是处理worker给自己处理的消息，然后在发送心跳给master
    case SendHeartBeat =>{
      //向master发送心跳，携带自己的id给master
      master ! HeartBeat2Master(workerID)
      
      
    }
    
    
  }

}

object Worker {

  def main(args: Array[String]): Unit = {
    val host = "127.0.0.1";
    val port = 9999

    val configStr = s"""
      |akka.actor.provider= "akka.remote.RemoteActorRefProvider"
      |akka.remote.netty.tcp.hostname="$host"
      |akka.remote.netty.tcp.port="$port"
      """.stripMargin

    val config = ConfigFactory.parseString(configStr)

    val actorSystem = ActorSystem("WorkerSystem", config);

    val actor = actorSystem.actorOf(Props(new Worker), "Worker")

    //停止程序
    //actorSystem.awaitTermination()  

  }
}



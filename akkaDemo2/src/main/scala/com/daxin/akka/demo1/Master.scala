package com.daxin.akka.demo1

import akka.actor.Actor
import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import akka.actor.Props
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

/**
 *
 * 模拟Spark的源码
 *
 *
 * eclipse有点小坑，每次创建完毕文件是gbk,手动修改utf-8
 *
 *
 */

class Master(host: String, port: Int) extends Actor {

  val id2Worker = new HashMap[String, WorkerInfo]

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

    case RegisterWorker(id: String, memory: Int, cores: Int) => {

      println(s"ID为$id 的Worker 内存为 $memory cpu核心数 $cores 完成连接...（此消息来至master）")

      if (!id2Worker.contains(s"$id")) {

        val workInfo = new WorkerInfo(id, memory, cores)

        id2Worker(id) = workInfo
        //保存活着worker 宕机的worker删除
        val workers = new HashSet[WorkerInfo]
        workers += workInfo;

      }

      //回复worker当前master的url,host和port使用Master构造方法传入的，其实以后MasterSystem和Master都可以构造方法传入。这demo略过
      sender ! RegisteredWorker(s"akka.tcp://MasterSystem@$host:$port/user/Master") //回复worker告诉其连接完成
    }

    case HeartBeat2Master(workId:String) =>{
      
     
    	  println("master 接收到ID="+workId+"的心跳")
        if(id2Worker.contains(workId)){
          id2Worker.getOrElse(workId, null).lastTime=System.currentTimeMillis()
        }
      
      
      
    }

   

  }

}

object Master {

  def main(args: Array[String]): Unit = {
    //ActorSystem是老大，辅助创建和监控其下面的Actor，它是单例

    val host = "127.0.0.1";
    val port = 9998

    //配置
    val configStr = s"""
      |akka.actor.provider= "akka.remote.RemoteActorRefProvider"
      |akka.remote.netty.tcp.hostname="$host"
      |akka.remote.netty.tcp.port="$port"
      """.stripMargin
    //    ConfigFactory是akka包下的
    val config = ConfigFactory.parseString(configStr)

    val actorSystem = ActorSystem("MasterSystem", config);

    //创建actor实例,  第二个参数是名字
    val actor = actorSystem.actorOf(Props(new Master(host, port)), "Master")

    actor ! "close"

    //停止程序
    // actorSystem.awaitTermination()  

  }
}




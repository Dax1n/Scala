package com.daxin

import scala.actors.{Future, Actor}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * Created by 青春常驻Dax1n on 2016/9/26.
 */

//样例类
case class SyncMsg(id: Int, msg: String)

//样例类
case class AsyncMsg(id: Int, msg: String)

//样例类
case class ReplyMsg(id: Int, msg: String)


class ActorDemo5 extends Actor {
  override def act(): Unit = {

    loop {
      react {
        case SyncMsg(id: Int, msg: String)  => println(s"this is a SyncMsg : $id  $msg") ;  sender ! ReplyMsg(1,"SyncMsg")
        case AsyncMsg(id: Int, msg: String) => println(s"this is a AsyncMsg : $id  $msg");  sender ! ReplyMsg(2,"AsyncMsg")
        case ReplyMsg(id: Int, msg: String) => println(s"this is a ReplyMsg : $id  $msg");  sender ! ReplyMsg(3,"ReplyMsg")
      }
    }
  }
}

object  ActorDemo5 extends  App{

  val list=new ListBuffer[ReplyMsg]

  val ac1=new ActorDemo5
  ac1.start()
  val r1=ac1 !? SyncMsg(1, "SyncMsg")
  //千万别犯逗逼错误，val r1=ac1 ! SyncMsg(1, "SyncMsg") 这样发消息是没有返回值的
  //因为!是异步无返回值的发送。

  val r2=ac1 !? ReplyMsg(2, "ReplyMsg")//override def !?(msg : scala.Any) : scala.Any = { /* compiled code */ }

  val r3=ac1 !! new AsyncMsg(3, "AsyncMsg")//发送异步消息，返回值是 Future[Any]。







  Thread.sleep(2000)
  println("*******************返回值都是空************************")

  println("r3.isSet : "+r3.isSet)
//    list+=r1.asInstanceOf[ReplyMsg]
//    list+=r2.asInstanceOf[ReplyMsg]

  println(list)
  println("r1 : "+r1)
  println("r2 : "+r2)
  println("r3 : "+r3)


}

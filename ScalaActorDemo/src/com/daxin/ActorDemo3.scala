package com.daxin

import scala.actors.Actor

/**
 * Created by 青春常驻Dax1n on 2016/9/26.
 */
class ActorDemo3  extends  Actor{

  override def act(): Unit = {

    while(true){
      receive{
      case  "start"=> println("it is starting..."); Thread.sleep(2000);println("started over...")
      case  "end"=>println("it is ending..."); Thread.sleep(2000);println("end over...")
      case  _=>println("running...")
      }

    }


  }
}



//  发送消息：
//  !	    发送异步消息，没有返回值。
//  !?	  发送同步消息，等待返回值。
//  !!	  发送异步消息，返回值是 Future[Any]。

object ActorDemo3 extends  App{

  val ac=new ActorDemo3
  ac.start()//必须start，如果不start的话，发送消息是不会受到的
  ac ! "start"//异步无返回值
  ac !? "haha"//同步有返回值
  ac !! "end"//异步返回值



}


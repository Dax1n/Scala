package com.daxin

import scala.actors.Actor

/**
 * Created by 青春常驻Dax1n on 2016/9/26.
 *
 * 注：我们现在学的Scala Actor是scala 2.10.x版本及以前版本的Actor。
 * Scala在2.11.x版本中将Akka加入其中，作为其默认的Actor，老版本的Actor已经废弃
 *
 *
 *
 * Actor是一个trait
 *
 */
object MyActor1 extends Actor{

  /**
   * Scala中的Actor能够实现并行编程的强大功能，它是基于事件模型的并发机制，
   * Scala是运用消息（message）的发送、接收来实现多线程的。使用Scala能够更容易地实现多线程应用的开发。
   */
  //重新act方法，有点类似java多线程的run方法
  def act(){
    for(i <- 1 to 10){
      println("actor-1 " + i)
      Thread.sleep(2000)
    }
  }
}

/**
 * 1.首先调用start()方法启动Actor
 *2.调用start()方法后其act()方法会被执行
 *3.向Actor发送消息
 */
object MyActor2 extends Actor{
  //重新act方法
  def act(){
    for(i <- 1 to 10){
      println("actor-2 " + i)
      Thread.sleep(2000)
    }
  }
}

/**
 * 说明：上面分别调用了两个单例对象的start()方法，他们的act()方法会被执行，
 * 相同与在java中开启了两个线程，线程的run()方法会被执行
 *注意：这两个Actor是并行执行的，act()方法中的for循环执行完成后actor程序就退出了
 *
 */
object ActorTest extends App{
  //启动Actor
  MyActor1.start()
  println("主线程...")
  MyActor2.start()
  println("main 方法...")
}

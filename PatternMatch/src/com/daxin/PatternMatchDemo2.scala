package com.daxin

import scala.util.Random

/**
 * 模式匹配之类型匹配
 */
object PatternMatchDemo2 {

  def main(args: Array[String]): Unit = {
  
    //Array 可以存储不同类型的变量
    val contents=Array("qccz",1,2,3,PatternMatchDemo2)
    
   while(true){
     
      val elem=contents(Random.nextInt(contents.length))
    
    elem  match {
      
                // =>是一个偏函数，后面介绍，像是调用重载函数那种意思，自动知道调用哪个
      case x:Int => if(x>=2) println("匹配的类型是Int...,Value:x>=2") else println("匹配的类型是Int...,Value:x<2")
      case x:String => println("匹配的类型是String...")
      case _ =>  println("没有类型匹配...") 
    
    
    }
      
      Thread.sleep(1000)
   }
    

  }
}
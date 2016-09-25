package com.daxin

/**
 * 在Scala中样例类是一中特殊的类，可用于模式匹配.
 * case class是多例的，后面要跟构造参数.
 * case object是单例的.
 * 
 */

//case class是多例的，后面要跟构造参数.
case class SubmitTask(id:String,name:String)//参数主要用来封装数据，还可以模式匹配

case class HeartBeat(time:Long)

//case object是单例的. case object是单例，不封装数据
case object CheckTimeOutTask


object CaseClassDemo {
  
   def main(args:Array[String]):Unit={
     
     //case class 可以用new创建， 也可以省略new关键字，例如：SubmitTask("task_0001","wordCount"),new SubmitTask("task_0002","Top-K")
     val arr=Array(CheckTimeOutTask,SubmitTask("task_0001","wordCount"),new SubmitTask("task_0002","Top-K"),HeartBeat(100),new HeartBeat(100));
     
     for(i <- 0 until(arr.length)){
       
       // match 的case中的=>是偏函数
       arr(i) match {
         //正常直接使用参数名字访问
         case SubmitTask(id:String,name:String) =>  println("This is a task that the id is : "+id+" and the name is : "+name +".")
         //使用$访问参数值，前面记住需要加一个s字母
         case HeartBeat(time:Long)=> println(s"This is a HeartBeat that the time is : $time.")
         
         case CheckTimeOutTask => println("this is a CheckTimeOutTask."+this)//使用this获取当前的case object
         
         case _=> println("no matcher is to match .")
       }
    
     
     }
     
     
     
     
   }
  
}
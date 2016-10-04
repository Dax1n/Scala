package com.daxin

/**
 * SCALA高级特性
 * 
 * 3将方法转换成函数
 * 
 */
object Main3  extends App{
  
  def add(x:Int,y:Int):Int={
      x+y
  }
  
  println(add(2,3))
  
  
  val addFunc=add _//方法名字 +_ 组合可以将方法转换为函数

  println(addFunc)
  
  val arr1=Array(1,2,3,4,5)
  
  //在map中使用addFunc函数
  val arr2=arr1.map { x => addFunc(x,x) }
  
  println(arr2.toBuffer)
  
  
  
}
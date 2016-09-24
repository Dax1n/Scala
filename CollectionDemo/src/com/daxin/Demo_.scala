package com.daxin

/**
 * @author 青春常驻Dax1n
 * 	下划线的使用
 * 
 */
object Demo_  extends App{
  
  //使用下划线将方法转成函数（神奇）
  def add(x:Int ,y:Int):Int={
    x+y
  }
  
  
  
  val addFunc= add _
  
  println(addFunc)  //打印信息是：<function2>，证明addFunc是一个两个参数的函数了
  
  
}
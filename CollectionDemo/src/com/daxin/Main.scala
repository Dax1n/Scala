package com.daxin


/**
 * 
 *@author 青春常驻Dax1n
 *  
 */
object Main  extends App{

  println("Hello World !")
  
  /**
   * 函数的定义
   */
  val fun1=(x:Int ,y:Int )=>{
   (x,y)
    
  }
  
  /**
   * 函数的定义
   * 定义一个函数名字为fun2的函数
   * fun2后面的(Int,Int)表示函数的类型
   * =>的后面表示的是返回元组类型：(Int,Int)
   * =>(Int,Int)的后面是返回的值
   * 
   */
  val fun2:(Int,Int)=>(Int,Int)={
  // val  函数名字：函数参数类型=》函数的返回值类型={函数的返回值}  
    (a,b)=>(a+1,b+1)
    
  }
  
  
  /**
   * 接受一个字符串返回字符串元组的一个函数
   */
  val sayName:String=>(String,String)={
    name=>(name,name)
  }
  
  
  println(fun2(2,3))
  println(fun1(2,3))
  
  println(sayName("青春常驻Dax1n"))
  
  
  println("定义一个无返回值的方法：")
  def  SayHello(name:String):Unit={

    println("Hello "+name+"!")
  }
  
 println("也可以不写:Unit= 来定义一个无返回值的方法：")
  
 def sayChina(name:String){
   
   println("I am "+name+", Hello China !")
 }
  
  
  
  println(SayHello("Dax1n"))//SayHello无返回值，所以打印空
   
  sayChina("daxin")
  
}
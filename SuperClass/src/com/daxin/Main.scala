package com.daxin

object Main {
  def main(args: Array[String]): Unit = {

    //打印几次"ABC"?
    val t1, t2, (a, b, c) = {
      println("ABC")
      (1, 2, 3)
    }
    
    
    //打印三次，原因是这个其实是定义了三个变量t1,t2和   (a,b,c)
  //然后代码块中的代码执行三次赋给三个变量值
    
    println(t1)
    println(t2)
    println(a)
    println(b)
    println(c)
    println((a,b,c))
    
  }
}
package com.daxin

class Dog  extends Animal{
  
  
  
}



object Dog{
  
  def main(args: Array[String]): Unit = {
    
    val dog=new Dog
    
    
    //判断dog是够是Animal的子类
    println(dog.isInstanceOf[Animal])

    
    println("获取类的字节码方法1 ："+classOf[Dog])
    println("获取类的字节码方法2 ："+dog.getClass)
    
    
    val an:Animal=new Dog
    
    println("an.getClass : "+an.getClass)
    //将an强转换为Dog
    val d=an.asInstanceOf[Dog]
    
    println("d.getClass : "+d.getClass)
    
    
    
    
    
    
    
  }
  
  
}
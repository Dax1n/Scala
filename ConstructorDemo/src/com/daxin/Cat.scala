package com.daxin

/**
 *
 * @author 青春常驻Dax1n
 *
 * 默认主构造器为（）
 *
 * 从构造器：def this(name:String,age:Int) ，在从构造器中定义成员如果不使用构造器方法参数的话也不会提升为字段
 *
 *
 * 
 */
class Cat {
  //此Cat类对象没有成员属性
 

  def this( name: String, age: Int) {
    this()
//name: String, age: Int无法提升为属性，因为其在成员方法中不可见    
 

  }
  
  
  def getName():String={
   // name  //从构造器的参数在成员方法中无法获取该字段
    "getName Method "
  }

}

object Cat {
  def main(args: Array[String]): Unit = {

    val cat = new Cat("tomcat", 18)
    
    println()

  }

}
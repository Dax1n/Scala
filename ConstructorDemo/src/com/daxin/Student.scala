package com.daxin

/**
 * @author 青春常驻Dax1n
 * 
 */


/**
  *每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
  * 
  * 如果不在类名后面写主构造器的话，默认有一个无参的主构造器，例如：
  * 
  * class Cat(){}或者class Dog{}
  * 
  */
class Student (val name:String,val age:Int){
  
  //主构造器会执行类中定义的所有语句
  println("类中定义的语句1")  
  println("类中定义的语句2")  
  println("类中定义的语句3")
  
  
  
}
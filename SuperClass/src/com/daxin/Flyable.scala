package com.daxin

/**
 * Created by ZX on 2015/11/10.
 */
object ClazzDemo {
  def main(args: Array[String]) {
    val h = new Human
    println(h.fight)
    
    
    
    //验证Animal和Human中的age是一个
    val hh:Animal = new Human
    hh.age=20

    println("hh.age : "+hh.age)
    
    val hum:Human=hh.asInstanceOf[Human]
    println("hum.age : "+hum.age)
  
  }
}

trait Flyable {
  def fly(): Unit = {
    println("I can fly")
  }

  def fight(): String
}

abstract class Animal {
  def run(): Int
  val name: String
  var age:Int
  
}

class Human extends Animal with Flyable {
  
  
  //  由于父类的的name属性没有初始化，所以在子类继承父类时候必须初始化，否则也声明为抽象类
 //class Human needs to be abstract, since value name in class Animal of type String is not defined
 
  val name = "abc" //没有name的复制会报错
  
  //var age:Int= _ 和父类中的age是一个，不然就报错了。必须指定类型，否则无法完整下划线占位符的默认初始化
  var age:Int= _
  //打印几次"ABC"?
  val t1, t2, (a, b, c) = {
    println("ABC")
    (1, 2, 3)
  }

  println(a)
  println(t1._1)

  //在Scala中重写一个非抽象方法必须用override修饰
  override def fight(): String = {
    "fight with 棒子"
  }
  //在子类中重写超类的抽象方法时，不需要使用override关键字，写了也可以
  def run(): Int = {
    1
  }
}

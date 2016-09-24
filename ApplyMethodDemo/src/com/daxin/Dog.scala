package com.daxin

class Dog {

}

object Dog {

  def apply(): Dog = {
    //使用apply方法创建对象，如果不想暴露构造器的话可以将构造器私有化然后使用apply创建对象
    new Dog()
  }

  def main(args: Array[String]) {

    val d1 = Dog(); //如果没有apply()方法的话，val d1=Dog();是错误的
    val d2 = Dog();

    println("d1==d2 ? :" + (d1 == d2))
    println("d1: " + d1)
    println("d2: " + d2)

  }

}
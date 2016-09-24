package com.daxin


/**
 * class Dog(var name: String, var age: Int, address: String)  主构造器
 *
 *
 */
class Dog(var name: String, var age: Int, address: String) {

  /**
   * 重构造器，在重复构造器中必须调用主构造器初始化
   */
  def this(name: String) {
    this(name, 18, "Liaoning")
  }

  /**
   * 重构造器，在重复构造器中必须调用主构造器初始化
   */
  def this() {
    this("Maomao", 18, "Liaoning")
  }

}

object Dog {

  def main(args: Array[String]): Unit = {

    val dog = new Dog("Maomao")
    println(dog.name + " " + dog.age)

  }

}
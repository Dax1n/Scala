package com.daxin


/**
 * address 主构造器中参数不写var或者val的话默认是private[this] val 型   , val 和var 隐式的指定了权限
 * 所以address是private[this]
 * class Dog(var name: String, var age: Int, address: String)  主构造器
 *
 *
 */
class Dog(var name: String, var age: Int, address: String) {

  /**
   * 从构造器，在重构造器中必须调用主构造器初始化
   * 
   * 使用this关键字定义辅助构造器（也叫从构造器）。
   */
 
  
  def this(name: String) {
    this(name, 18, "China")
  }
  
    def getAddress():String={
      address
    }
//  def setAddress(addr:String){
//    this.address=addr
//  }

  /**
   * 
   * 从构造器，在重构造器中必须调用主构造器初始化
   */
  def this() {
    this("Maomao", 18, "Liaoning")
  }

}

object Dog {

  def main(args: Array[String]): Unit = {

    val dog = new Dog("Maomao")
    println(dog.name + " " + dog.age)
    println(dog.getAddress())

  }

}
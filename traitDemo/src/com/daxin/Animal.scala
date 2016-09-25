package com.daxin

/**
 *
 * 特质类似于java 8中的接口（java8中的接口是可以有实现的）
 * 
 */
trait Animal {
  /**
   * 无实现，抽象方法。抽象方法在子类重写时候override可写可不写
   */
  def run(name: String)
  
  /**
   * 无实现
   */
  def sayHello(name: String)
  
  /**
   * 特质中有实现，非抽象方法
   * 非抽象方法在子类重写时候override必须写
   */
  def eat(name:String):Unit={
    println("Animal is eating "+name)
  }

}
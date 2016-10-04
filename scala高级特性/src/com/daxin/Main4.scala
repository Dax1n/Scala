package com.daxin

/**
 *
 * SCALA高级特性
 *
 * 4：	柯里化
 *
 * 定义:柯里化指的是将原来接受两个参数的方法变成新的接受一个参数的方法的过程
 *
 */
object Main4 extends App {

  /**
   * 一个比较神奇的方法：看起来又像方法又像函数
   */
  def method(x: Int) = (y: Int) => x + y

  /**
   * 传入一个参数之后就变成函数了
   * 
   * 例如传进去参数为2：
   * 之后函数就为：(y:Int)=>2+y
   * 
   */
  val fun1 = method(3)

  println(fun1)

  //在传入一个参数就不是函数了，是数值了
  val fun2 = fun1(2)

  println(fun2)

}
package com.daxin

/**
 * 被包在花括号内没有match的一组case语句是一个偏函数，
 * 它是PartialFunction[A, B]的一个实例，
 * A代表参数类型，B代表返回类型，常用作输入模式匹配
 */
object PartialFuncDemo {

  /**
   * PartialFunction[A, B]的一个实例，A代表参数类型，B代表返回类型，常用作输入模式匹配
   */
  def func1: PartialFunction[String, Int] = {
    case "one" => 1
    case "two" => 2
    case _     => -1
  }

  /**
   * 使用模式匹配实现的偏函数功能
   *
   * 通过对比偏函数可知，实际上match case中的match应该属于分发当前值给每一个case去做匹配
   *
   */
  def func2(num: String): Int = num match {
    case "one" => 1
    case "two" => 2
    case _     => -1
  }

  def func3(num: String): Int = num match {
    case "one" => 1
    case "two" => 2
    case _     => 0
  }

  def main(args: Array[String]) {
    println(func1("one"))
    println(func2("one"))
  }
}

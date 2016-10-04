package com.daxin

/**
 * SCALA高级特性
 *
 * 2 匿名函数
 *
 * 在Scala中，你不需要给每一个函数命名，没有将函数赋给变量的函数叫做匿名函数
 */
object Main2 extends App {

  val arr1 = Array(1, 2, 3, 4, 5)

  //map方法中传入的匿名函数时候必须使用{}，如果传递进去的是函数名字可以使用()或者{}
  val arr2 = arr1.map { x: Int => x * 2 }
  //  val arr3=arr1.map(x:Int => x*2)  //反例，就是说如果传进去的是匿名函数，必须使用{}

  //传递给map一个匿名函数为： x:Int => x*2
  val arr4 = arr1.map { x: Int => x * 2 }

  //由于Scala可以根据arr1（调用者）自动推断出参数的类型，所以可以省略参数类型Int
  val arr5 = arr1.map { x => x * 2 }

  //还记得神奇的下划线吗？这才是终极方式
//  (终极方式)如果参数在=>右侧只出现一次，可以使用_
  val arr6 = arr1.map { _ * 2 }//=>右侧只出现一次，可以使用_
  /**
   * 占位符：这个用法比较多，表示某一个参数。比如对collection或sequence调用方法map、filter、sortWith、foreach等等
   * 表示对每一个元素进行处理，甚至可以使用_.XXX方式；
   * 还有参数推导时f(250*_)，假设已知f的参数类型是Int=>Int的函数类型时，可以在匿名函数中250*_使用_表示Int 参数，还比如val f = 250 * (_: Int)
   *
   */

}
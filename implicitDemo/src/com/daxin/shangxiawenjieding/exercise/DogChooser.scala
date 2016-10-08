package com.daxin.shangxiawenjieding.exercise

/**
 * Dog的比较方法
 */
class DogChooser[T: Ordering] {

  //Dog的比较方法 
  def chooseBeautifulDog(first: T, second: T): T = {

    val ord = implicitly[Ordering[T]]
    //只定义比较的结果，谁大谁小。没有定义具体规则，具体规则在DogPredef中定义，没有侵略性
    if (ord.gt(first, second)) first else second

  }

}

/**
 * 测试的main方法
 */
object DogChooser {
  def main(args: Array[String]): Unit = {
    import DogPredef._
    val c1 = new DogChooser[Dog]()
    val g1 = new Dog("jingba", 90)
    val g2 = new Dog("muyangquan", 99)
    val r = c1.chooseBeautifulDog(g1, g2)
    println(r.name)

  }

}
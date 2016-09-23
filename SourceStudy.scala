package com.daxin.scalapackage

/**
  *
  * 方法和函数的区别:
  * 方法的定义使用def关键字 :  def add(x: Int, y: Int): Int = { x + y }
  *
  * 函数的定义:val add=(x:Int,y:Int)=>{x+y}
  *
  *
  * 函数与方法最大区别: 函数可以作为值传入到方法中
  *
  * Created by daxin on 16/3/25.
  */


object SourceStudy {


  def main(args: Array[String]) {

    val v = Vector(1, 2, 3, 4, 5);

    // 函数的定义,函数使用=>转换
    val fun = (x: Int) => {
      if (x % 2 == 0) x else x + 1
    }

    println(v.map(fun))
    v.map(_ * 2) //下划线是一个占位符
    println("===============")
    //下面map中传入的是一个匿名函数
    val r1 = v.map((x: Int) => {
      if (x % 2 == 0) x else x + 1
    })
    println("r1:" + r1)
    //类型推断,因为已经知道v中的类型,所以在定义匿名函数时候可以省略匿名函数参数类型
    val r2 = v.map((x) => {
      if (x % 2 == 0) x else x + 1
    })
    println("r2:" + r2)

    /**
      * 调用自己定义的接受函数的方法
      */
    val add = (x: Int, y: Int) => {
      x + y
    }
    val result = addByFunction(add, 3, 2)
    println(result)


  }

  /**
    * 方法定义
    * 方法的定义使用def关键字,参数类型,以及返回值(函数没有返回值,函数是转换)
    *
    * @param x
    * @param y
    * @return
    */
  def add(x: Int, y: Int): Int = {
    x + y
  }

  /**
    * 定义个接受一个函数的方法
    *
    * 函数的格式是接受两个int 返回int格式的函数
    *
    * @param f
    * @return
    */
  def addByFunction(f: (Int, Int) => Int, x: Int, y: Int): Int = {

    f(x, y)

  }


}

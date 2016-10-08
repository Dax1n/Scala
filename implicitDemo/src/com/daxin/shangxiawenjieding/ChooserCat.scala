package com.daxin.shangxiawenjieding


/**
 *
 * 上下文界定
 *
 * 上下文界定 必须传进去一个隐式转换的值
 */
class ChooserCat[T: Ordering] {
  def choose(first: T, second: T): T = {

    val ord = implicitly[Ordering[T]]
      //gt 是Ordering中的方法
    
    //gt时候需要隐式转换，在MyPredefImplicit 中将Cat隐式转换为Ordering[Cat]
//
//      implicit val cat2Ordering =new Ordering[Cat]{
//      def compare(x: Cat, y: Cat): Int={
//        x.faceValue-y.faceValue
//      }
//  }
//    在隐式转换函数中完成比较
    
    if (ord.gt(first, second)) first else second

  }

}

object ChooserCat {

  def main(args: Array[String]): Unit = {

    //直接 import  MyPredefImplicit._就行 不用写包名，因为在一个包中
     import MyPredefImplicit._
//    
    val c1 = new ChooserCat[Cat]() 
    val g1 = new Cat("malicat", 90)
    val g2 = new Cat("marycat", 99)
    val r = c1.choose(g1, g2)
    println(r.name)

  }

}
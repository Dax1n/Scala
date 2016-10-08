package com.daxin.shangxiawenjieding

class Cat(val name: String, var faceValue: Int) {}

/**
 * Cat隐式转换规则
 *
 * 这个是上下文界定，上下文界定使用Ordered 慢慢理解吧！
 *
 */
object MyPredefImplicit {

  //函数一： 上下文界定 可以作为上下文界定的隐式转换函数  
  //    implicit def cat2Ordered(g: Cat) = new Ordered[Cat] {
  //   
  //    override def compare(that: Cat): Int = {
  //      g.faceValue - that.faceValue
  //    }
  //  }
  //    

  //  //函数二也可以完成上下文界定的隐式转换
  //  implicit val cat2Ordering =new Ordering[Cat]{
  //      def compare(x: Cat, y: Cat): Int={
  //        x.faceValue-y.faceValue
  //      }
  //  }

  //方式3也可以完成上下文界定的隐式转换
  trait cat2Ordering extends Ordering[Cat] {
    def compare(x: Cat, y: Cat): Int = {
      x.faceValue - y.faceValue
    }
  }
  implicit object Cat extends cat2Ordering

}
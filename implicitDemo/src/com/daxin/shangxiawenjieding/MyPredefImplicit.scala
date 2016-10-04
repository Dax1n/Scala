package com.daxin.shangxiawenjieding


 class Cat(val name: String, var faceValue: Int) {}

/**
 * Cat隐式转换规则
 * 
 * 这个是上下文界定，上下文界定使用Ordered 慢慢理解吧！
 * 
 */
object MyPredefImplicit {
  
    implicit def cat2Ordered(g: Cat) = new Ordered[Cat] {
   
    override def compare(that: Cat): Int = {
      g.faceValue - that.faceValue
    }
  }
}
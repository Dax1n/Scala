package com.daxin.shitujieding

 

class Girl(val name:String,var faceValue:Int){}
/**
 *
 * <% 视图定界
 * 
 * 视图定界 必须传进去一个隐式转换函数
 * 
 * 一定要传入一个隐式转化函数  隐式转换函数在MyPredef.scala定义
 */
class Chooser[T <% Ordered[T]] {

  def choose(first: T, second: T): T = {
    
    if (first > second) first else second
  }

}

object Chooser {

  def main(args: Array[String]): Unit = {

    //需要定义隐式转换规则
    import com.daxin.shitujieding.MyPredef._
    
    val c1 = new Chooser[Girl]()

    val g1 = new Girl("mali", 90)
    val g2 = new Girl("mary", 99)
    val r = c1.choose(g1, g2)
    println(r.name)
  }

}
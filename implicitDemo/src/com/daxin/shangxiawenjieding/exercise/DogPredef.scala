package com.daxin.shangxiawenjieding.exercise


/**
 * 隐式转换函数
 */
object DogPredef {

  trait dogOrdering extends Ordering[Dog] {

    override def compare(first: Dog, second: Dog): Int = {

      //定义Dog的比较规则，具体规则在此处定义，没有侵略性
      first.faceValue - second.faceValue

    }

  }
  
  
  implicit object Dog extends dogOrdering
  
  
  

}
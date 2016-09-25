package com.daxin

/**
 *
 * @author 青春常驻Dax1n
 *
 * 默认主构造器为（）
 *
 * 从构造器：def this(name:String,age:Int) ，在从构造器中定义成员如果不使用构造器方法参数的话也不会提升为字段
 *
 *
 */
class Horse {
  
//	val _name:String= _  //常量是不可以使用占位符的

	var _name:String= _
  var _age:Int=_

  def this(name: String, age: Int) {
    this()
    //手动将从构造器的参数提升为字段
    _name=name
    _age=age

  }
  
  
  def getName():String={
   // name  //从构造器的参数在成员方法中无法获取该字段
    "name :"+_name+" age:"+_age
  }

}

object Horse {
  def main(args: Array[String]): Unit = {

    val c = new Horse("Citu", 18)
    
    println(c._name+" "+c._age)
    println(c.getName())
    

  }

}
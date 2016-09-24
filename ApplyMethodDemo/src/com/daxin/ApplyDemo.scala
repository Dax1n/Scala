package com.daxin

class ApplyDemo {

}

//通常我们会在类的伴生对象中定义apply方法，当遇到类名(参数1,...参数n)时apply方法会被调用
object ApplyDemo {

  //apply方法定义位置：      通常我们会在类的伴生对象中定义apply方法
  //apply方法调用时机：      当遇到类名(参数1,...参数n)时apply方法会被调用

  //apply方法定义位置：      通常我们会在类的伴生对象中定义apply方法
  def apply(): Unit = {
    println("this is def apply() ...")
  }

  //apply方法定义位置：      通常我们会在类的伴生对象中定义apply方法
  def apply(name: String): Unit = {
    println("this is def apply(name:String) ...")
  }

  //apply方法定义位置：      通常我们会在类的伴生对象中定义apply方法
  def apply(name: String, age: Int): Unit = {
    println("this is def apply(name:String,age:Int) ...")
  }

  def main(args: Array[String]): Unit = {

    //app1 是ApplyDemo的单例对象
    val app1 = ApplyDemo
    //apply方法调用时机：      当遇到类名(参数1,...参数n)时apply方法会被调用
    println("app1 : " + app1) //打印的是对象的hashcode

    //
    val app2 = ApplyDemo()
    //apply方法调用时机：      当遇到类名(参数1,...参数n)时apply方法会被调用
    println("app2 : " + app2) //调用了apply方法

    val app3 = ApplyDemo("Dax1n")
    //apply方法调用时机：      当遇到类名(参数1,...参数n)时apply方法会被调用
    println("app3 : " + app3)

    val app4 = ApplyDemo("Dax1n", 18)
    //apply方法调用时机：      当遇到类名(参数1,...参数n)时apply方法会被调用
    println("app4 : " + app4)

    
    
    
    println("***************************************************************")
    //调用了Array伴生对象的apply方法
    //def apply(x: Int, xs: Int*): Array[Int]
    //arr1中只有一个元素5
    val arr1 = Array(5)//在apply中new Array
    println(arr1.toBuffer)

    //new了一个长度为5的array，数组里面包含5个null
    var arr2 = new Array(5)
    
    
    
    

  }

}
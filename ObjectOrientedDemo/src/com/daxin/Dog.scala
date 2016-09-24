package com.daxin

//
//private[daxin] class Dog限制dog类只能在daxin包下或者daxin的子包下
//反编译之后的class文件是public权限的
private[daxin] class Dog {
  
  var name:String=_
  
  var age:Int=0
  
  //测试文件去看com.test下面的DogTest.scala文件
}


//反编译之后的文件class是public权限的
//Cat后面的private是私有的构造方法，只能在期伴生对象中new

private[daxin]  class  Cat private{
 
  var name:String= _
  
 //scala 中没有public关键字吧
    def getMiao():String={
    
    "Miao Miao ..."
  }
  
}

object  Cat{
  def main(args: Array[String]): Unit = {
    
    val c=new Cat
    
    c.name="Tomcat"
    
    println(c.name)
    
    
    
  }
  
}
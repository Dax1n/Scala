package com.daxin

// 在Scala中没有静态方法和静态字段，但是可以使用object这个语法结构来达到同样的目的
//1.存放工具方法和常量
//2.高效共享单个不可变的实例
//3.单例模式

object UserFactory {
  
  //函数也不写var 或者val
  val add=(x:Int,y:Int)=>{
    x+y
  }
  
  /**
   * object中的方法参数不写val或者var
   */
  def getUser( name:String ,age:Int):User={
    new User(name,age);
  }
  
 
  
}
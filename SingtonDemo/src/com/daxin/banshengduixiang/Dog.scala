package com.daxin.banshengduixiang

class Dog {

  private[this] val id: String = "2015001"
  private var name:String ="Maomao"
  
  //这个是对伴生对象中字段： private[this] val CONSTANT1:String = "阿里巴巴1"的验证
//  def getCONSTANT1():String={
//    Dog.CONSTANT1//not found: value CONSTANT1
//  }
  
    def getCONSTANT2():String={
    //通过伴生对象类名来访问伴生对象的私有属性
    Dog.CONSTANT2
  }
}

//在Scala的类中，与类名相同的对象叫做伴生对象，类和伴生对象之间可以相互访问私有的方法和属性
object Dog {
  //重点！！！！！！！！！！！！！！！
  //private[this] val CONSTANT1:String = "竟然private后面还可以加[this]" 不可以在class中使用，private[this]中的this限制就是当前定义的类型中使用
  private[this] val CONSTANT1:String = "竟然private后面还可以加[this]"
  
  private val CONSTANT2:String = "阿里巴巴"
  private[daxin] val CONSTANT3:String = "竟然private后面还可以加包名！！！"//这个一般用不到，了解即可

  def main(args: Array[String]): Unit = {
    
    val dog=new Dog
//    dog.id//value id is not a member of com.daxin.banshengduixiang.Dog
    //伴生对象访问类对象的私有成员
    println(dog.name)
    //类对象访问伴生对象的私有成员
    println(dog.getCONSTANT2())
    
    

  }

}
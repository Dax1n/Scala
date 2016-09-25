package com.daxin

/**
 * 如果继承类和特质的话，先继承类之后使用with实现特质 
 */
class Chinese extends Human with Animal with Monkey/*可以with后面加上多个特质*/{

  //特质中无实现
  //是否必须写override？ 特质中没有实现的话，在子类覆写方法时候的话可写，可不写override
  
  override def run(name: String): Unit = {
//  在Scala中重写一个非抽象的方法必须使用override修饰符
    println(name + " is running...")
  }

  //特质中无实现
  def sayHello(name: String): Unit = {
//  在Scala中重写一个非抽象的方法必须使用override修饰符
    println("Hello " + name)
  }

  //特质中有实现
  //是否必须写override？  特质中有实现的话，在子类覆写方法时候的话必须写override
  override def eat(name: String): Unit = {
//  在Scala中重写一个非抽象的方法必须使用override修饰符

    //没有override关键字报错：   overriding method eat in trait Animal of type (name: String)Unit; method eat needs `override' modifier
  println("Chinese is eating "+name)
  }

}

object Chinese {

  def main(args: Array[String]): Unit = {
    
    val ch=new Chinese
    ch.eat("Apple")

  }

}
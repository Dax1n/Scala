package com.daxin

object TestPerson {
  
  def main(args :Array[String]){
    
    val p1=new Person
    println("Person中的Gnder是private权限，所以在其他文件中不可以访问")
    println(p1.id +" "+p1.name)
    
    
//  println(p1.country)// private[this] var country:String=_
    println(p1.getCountry())
    
//    cat的定义：private[daxin]  class  Cat private
//    val cat=new Cat //constructor Cat in class Cat cannot be accessed in object TestPerson 意思是说：在TestPerson无法访问私有构造方法
    
  }
}
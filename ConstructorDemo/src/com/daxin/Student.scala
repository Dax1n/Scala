package com.daxin

/**
 * @author 青春常驻Dax1n
 * 
 */


/**
  *每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
  * 
  * 如果不在类名后面写主构造器的话，默认有一个无参的主构造器，例如：
  * 
  * class Cat(){}或者class Dog{}
  * 
  * 
  * class Student (val id:String,var name:String,var age:Int) 这种方式在定义class和构造器的同时把成员变量也定义了
  * 成员变量的权限和主构造器的参数权限一致
  * 
  * 主构造器中的参数可以有默认值，如果传参的话直接覆盖
  * 
  *构造器参数可以不带val或var，如果不带val或var的参数至少被一个方法所使用，
  *那么它将会被提升为字段
  */

class Student (val id:String,var name:String,var age:Int, address:String , var salary:Int=20000,val height:String="180"){
  
  //主构造器会执行类中定义的所有语句
  println("类中定义的语句1")  
  println("类中定义的语句2")  
  println("类中定义的语句3")
  
  var  gender:String=_
  
  
}

object Student{
  def main(args: Array[String]): Unit = {
    
    val stu=new Student("2105001","Dax1n",18,"China")
    
//    stu.address //是访问不到的，主构造器中参数不写权限修饰符的话默认是private[this]
    
    println("stu.address是访问不到的，主构造器中参数不写var或者val的话默认是private[this] , val 和var 隐式的指定了权限")
    
    println(stu.id+" "+stu.name+" "+stu.age)
    
//    stu.id="2016001"//不可以修改，因为主构造器是val型
    
    println("stu.id=\"2016001\" 不可以修改，因为主构造器是val型")
    stu.name="qccz"
    
    stu.age=19
    
    println(stu.id+" "+stu.name+" "+stu.age+" "+stu.salary)
    stu.salary=30000
    println(stu.id+" "+stu.name+" "+stu.age+" "+stu.salary)
    
    /**
     * 在主构造器中传参数覆盖工资salary的默认值
     */
    val stu1=new Student("2105002","FuckU",21,"USA",10000)
    
    println(stu1.id+" "+stu1.name+" "+stu1.age+" "+stu1.salary)
    
    //覆盖主构造器的val 类型的 height的默认值
    val stu2=new Student("2105003","Scala",22,"EN",11000,"190")
    
     println(stu2.id+" "+stu2.name+" "+stu2.age+" "+stu2.salary+" "+stu2.height)
     
     
  }
  
}






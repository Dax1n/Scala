package com.daxin

/**
 * Person 类
 * 可以反编译scalac之后的class文件可以看到：
 * 
 * val的属性只有生成一个方法名字为属性名字的类似get方法作用的方法：
 * public String id(){ return this.id; }
 * 
 * var的属性生成一个方法名字为属性名字的类似于get作用的方法之后，还生成一个类似于set方法作用的方法，其名字为：属性名_$eq(参数类型 变量名)
 * 反编译出来的是java代码，所以不要对方法： 属性名_$eq(参数类型 变量名)的方法的参数列表不是scala形式感到迷惑
 * 
 * 
 * public String name() { return this.name; } 
 * public void name_$eq(String x$1) { this.name = x$1; }
 * 
 * 
 */
class Person {
  
  //身份证号，不可变，反编译class代码之后发现id是 private final String id="210888199010051958";
  val id="210888199010051958" //val 只有get 
  
  var  name ="Daxin"//var 只有set get
  
}

/**
 * 
 * Person 伴生对象
 * 
 */
object Person{
  
  def main(args :Array[String]){
    
    val p1= new Person
    println(p1.id+" "+p1.name)
    
    p1.name="Qccz"
    println(p1.id+" "+p1.name)
    
  }
  
}
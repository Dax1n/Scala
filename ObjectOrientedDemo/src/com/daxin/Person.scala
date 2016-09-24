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
  
  
  
  //下环线的第二个作用可以作为class属性的不初始化的标志，当对象创建之后会给一个对应的默认值
   var age:Int=_ //默认值是0

   /**
   * private 私有的,只在伴生对象中访问
   * 分析：<br>
   * 反编译class文件的 private var gender="boy"知道：
   * class中文件定义形式如下：
   * private String com$daxin$Person$$gender = "boy";
   * 
   *   public String com$daxin$Person$$gender() { return this.com$daxin$Person$$gender; } 
   *   private void com$daxin$Person$$gender_$eq(String x$1) { this.com$daxin$Person$$gender = x$1; }
   *   
   * 伴生Person的编译后的文件名字是：Person$
   * 	所有gender的com$daxin$Person$$gender() 和com$daxin$Person$$gender_$eq名字知道局限于伴生对象访问(因为Person后面有两个$符号)
   * 
   */
   private var gender="boy"
   
   /**
    * 只能在类对象中访问
    * 
    *  private[this] var country:String=_   
    *  
    *  private[this]后面的[this]是访问限制，只在本class中调用
    *  
    */
   private[this] var country:String=_
    
    
    def getCountry():String={
      country
    }
   
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
    
    println(p1.gender)
    println("p1.age :"+p1.age)
     
//    println(p1.country)//找不到country属性
    
  }
  
}
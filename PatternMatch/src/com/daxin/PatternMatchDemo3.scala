package com.daxin

import scala.util.Random

/**
 * 模式匹配之匹配数组、元组、列表
 */
object PatternMatchDemo3 {

  def main(args: Array[String]): Unit = {

    println("下面是Array的匹配：")
    var arrCount: Int = 5;
    while (arrCount >= 0) {
      arrCount -= 1
      val arr = Array(1, 2, Random.nextInt(5))

      arr match {
        case Array(1, 2, 4)  => println("Array(1,2,4)")
        case Array(1, 2, 3)  => println("Array(1,2,3)")
        case Array(1, 2, 5)  => println("Array(1,2,5)")
        //只要保证前面的1,2匹配上即可,(1, 2, 5，5,4)也可以匹配，不限制个数
        case Array(1, 2, _*) => println("Array(1, 2, _*)")

      }
      Thread.sleep(100)
    }

    println("下面是Tuple的匹配1：")

    val tuple = (1, 2, 3, 4, Random.nextInt(5))

    tuple match {
      case (1, 2, 3, 4, 5) => println("(1,2,3,4,5)")
      case (1, 2, 3, 4, 4) => println("(1,2,3,4,4)")
      case (1, 2, 3, 4, 3) => println("(1,2,3,4,3)")
      //元组的个数是确定的不可以(1,2,3,4,_*匹配)
      case (1, 2, 3, 4, _) => println("(1,2,3,4,5)")
    }

    println("下面是Tuple的匹配2：")
    val tup = (2, 3, 7)
    tup match {
      //使用"$参数名字" 获取对应value
      case (1, x, y) => println(s"1, $x , $y")
      case (_, z, 5) => println(z)
      case _         => println("元组未匹配上...")
    }
    
    
    
     println("下面是List的匹配：")
    
//    val list=List(1,2,3,4,"qccz") //list也可以存放不同类型的变量
      for(i<- 1 to 25){
        val list=List(Random.nextInt(1),2,3,4,Random.nextInt(5)) 
    List(1,2,3,4,4)
    list match {
          //想要使用$x这种方式取值的话必须在字符串首部添加s字符
      case List(0,2,3,4,x) =>  println(s"List(0,2,3,4,$x)")
      case List(1,2,3,4,5) =>  println("List(1,2,3,4,5)")
      case 1::2::3::4::4::Nil => println("List(1,2,3,4,4)")
      case List(1,2,3,4,3) =>  println("List(1,2,3,4,3)")
      case List(1,2,3,4,1) =>  println("List(1,2,3,4,3)")
      case List(1,2,3,4,_*) =>  println("List(1,2,3,4,_*)")
      
    }
      }
    
    

  }
}
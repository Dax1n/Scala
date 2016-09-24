package com.daxin

/**
 * @author 青春常驻Dax1n
 * 关于容器的使用
 */
object ArrayDemo  extends App{
  
  //使用new创建Array方法
  val arr=new Array[Int](10)
  
  println(arr.length)
  println(arr.toBuffer)
  println(arr.toSeq)
  
  
  //使用类名()创建对象实际上是在其同名的Object中创建的
  val arr1 = Array(1,2,3,4,5)
  
  
//  Creates an array with given elements. 后面的数字是元素值，不是个数
  val arr2=Array[Int](10)
  
  println(arr2.length)
  
  
  //遍历数组元素
  println( 0 to 9)
  println( 0 until 9)
  
  println("****************")
  
  for(i <- 0 to 9){
    println(i)
    arr(i)=i+2;
  }
  println("****************")
  
  for(i<- 0 until 10){
    //scala中数组的角标使用的是小括号
    println("arr"+i+": "+arr(i))
  }
  
  
  
  for(i<- arr){
    println("使用增强的for循环遍历数组："+i)
  }
  
  /**
   * 返序数组
   */
 println(arr.reverse.toBuffer)


 //foreach的返回值是Unit
  val foreachResult= arr1.foreach { x => println((x,x+1)) }
  
 //map的函数返回值是里面函数体的返回值
  val mapResult= arr1.map { x => x+1 }
  
  println("foreachResult :"+foreachResult)
  println("mapResult"+mapResult.toBuffer)
}
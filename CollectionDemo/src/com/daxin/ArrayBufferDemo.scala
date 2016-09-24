package com.daxin

import scala.collection.mutable.ArrayBuffer

object ArrayBufferDemo  extends App{

  /**
   * 10是初始大小
   */
  val arr=new ArrayBuffer[Int](10);
  println(arr.length)
  
  
  val data =Array(1,2,3,4,5,6,7,8)
  
  for(i<-0 to 20){
    //ArrayBuffer 添加元素的操作是+=
    arr+=i+5
  }
  println(arr.length)
  println(arr)
  
  /**
   * ArrayBuffer添加一个数组需要使用++=
   */
  println(arr++=data)
  
  
  println(arr)
  //在脚表为1的位置后面插入3个8
  arr.insert(1, 8,8,8)
  println(arr)
  
  /**
   * 在脚表的位置删除3个元素
   */
  arr.remove(0, 3)
  
  println(arr)
  
  
  
  
}
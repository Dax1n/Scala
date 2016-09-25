package com.daxin
/**
 * 构造器参数可以不带val或var，如果不带val或var的参数至少被一个方法所使用，
 * 那么它将会被提升为字段
 * 反编译Pig.class分析address
 * 
 */
class Pig(var name: String, var age: Int, address: String,phoneNum: String) {
  
  def getPhoneNum():String={
    phoneNum
  }

}


object Main extends App{
  
  val pig=new Pig("pig",2,"benxi","15640123555")
  
}
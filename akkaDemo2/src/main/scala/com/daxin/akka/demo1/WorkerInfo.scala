package com.daxin.akka.demo1

/**
 * 
 * 用来记录Worker的上一次心跳
 * 
 */
class WorkerInfo(id:String ,memory:Int,cores:Int) {
  
  //TODO 记录上一次的worker心跳
  
  
  var lastTime:Long=_
  
  
}
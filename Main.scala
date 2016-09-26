package com.daxin

import scala.io.Source
import scala.collection.immutable.HashMap

object Main extends App {

 
  //关于mapValues的使用
  val map=HashMap("1"->1,"2"->2,"3"->3,"4"->4)
  
 
  
  println(map.mapValues { x => x+1 })
  
  val map1=HashMap("1"->Array(1,22),"2"->Array(2,33),"3"->Array(3,44),"4"->Array(4,55,55))
   
  //mapValues其实就是将map中的每一个value替换掉，此行全替换成1生成新的map
  println(map1.mapValues { x=> 1 })
  
  //mapValues其实就是将map中的每一个value替换掉，此行全替换成map中value的长度生成新的map
  println(map1.mapValues { _.length })
  
  //mapValues其实就是将map中的每一个value替换掉，此行全替换成map中value的和
  println("map1.mapValues { x=>x.sum } : "+map1.mapValues { x=>x.sum })
  
  
  
  
}
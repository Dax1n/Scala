package com.daxin

import scala.io.Source
import scala.collection.immutable.HashMap

object Main extends App {

 
  //����mapValues��ʹ��
  val map=HashMap("1"->1,"2"->2,"3"->3,"4"->4)
  
 
  
  println(map.mapValues { x => x+1 })
  
  val map1=HashMap("1"->Array(1,22),"2"->Array(2,33),"3"->Array(3,44),"4"->Array(4,55,55))
   
  //mapValues��ʵ���ǽ�map�е�ÿһ��value�滻��������ȫ�滻��1�����µ�map
  println(map1.mapValues { x=> 1 })
  
  //mapValues��ʵ���ǽ�map�е�ÿһ��value�滻��������ȫ�滻��map��value�ĳ��������µ�map
  println(map1.mapValues { _.length })
  
  //mapValues��ʵ���ǽ�map�е�ÿһ��value�滻��������ȫ�滻��map��value�ĺ�
  println("map1.mapValues { x=>x.sum } : "+map1.mapValues { x=>x.sum })
  
  
  
  
}
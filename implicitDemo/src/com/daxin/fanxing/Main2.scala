package com.daxin.fanxing

/**
 * 下界 抛砖引玉  看Main3
 * 
 * name名字
 * 
 * faceValue颜值
 * 
 * 
 * 
 * 
 */


//这个是java的思想做比较
class Boy(val name:String, var faceValue:Int)  extends Comparable[Boy] {
  
  def compareTo(boy: Boy): Int = {
    if( this.faceValue-boy.faceValue>0)  1  else -1 
  }
}

object Main2 {
  def main(args: Array[String]): Unit = {
   
    val b1=new Boy("Jack",98)
    val b2=new Boy("Tom",88)
    val b3=new Boy("Mala",99)
    
    val arr=Array[Boy](b1,b2,b3)
    val arr1=arr.sortBy[Boy]{ x => x}.reverse
     for(v<-arr1){
       println(v.name)
     }
    
  }
}
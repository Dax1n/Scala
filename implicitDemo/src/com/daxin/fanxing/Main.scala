package com.daxin.fanxing


//class Pair[T] {
//
//  def compare(first: T, second: T): T = {
//    
//    // > 可能不是泛型的具体某个类型的方法
//     if (first > second) first else second
//
//}

/**
 * 
 *  Pair[T<:Comparable[T]] 中的 <:上界的意思，就是说Pair中的T是Comparable的子类类型
 * 
 * class Pair[T<:Comparable[T]] 在java中写法 class Pair<T extends Comparable>
 * 
 */
class Pair[T<:Comparable[T]] {

  def compare(first: T, second: T): T = {
    
 
    if (first.compareTo(second)>0) first else second

  }

}


object Pair{
  def main(args: Array[String]): Unit = {
     
    val p=new Pair[String]
    println(p.compare("hadoop", "spark"))
     
   
//       val pp=new Pair[Int] //Int 不是Comparable子类
//		   println(pp.compare(2 , 3))
  
   //但是下面可以
   val pp=new Pair[Integer]
    pp.compare(5, 8)//java自动装箱
  
  
  
  
  }
}
package com.daxin

object ListDemo2 {
  
  def main(args:Array[String]){
    
    val list=List(1,2,3,4,5,6,7,8)
    
    println(list)
    //grouped的参数是分组的大小，size=2时候，每一组两个元素，分4组
    val its=list.grouped(2)
    val flattenList=its.toList;
    println("flattenList :"+flattenList)
    
    println("its.toList :"+its.toList)//为空的原因是its是迭代器，迭代一遍之后迭代器指针已经在最后了。
    
    println("flattenList.flatten: "+flattenList.flatten)
    
    
    val words=List("I am Chinese ","I am Daxin")

    
    //  空格分词之后压平成一个List,等效于：word.map { x => x.split(" ").toList }.flatten
    val w1=words.flatMap { x => x.split(" ")}
    println(" w1 :"+w1)
    
    //元组的角标从1开始，按照元组的key进行分组
    val w2=w1.map { x => (x,1) }.groupBy(x=>x._1)
    println(" w2 :"+w2)
    //w2： Map(am -> List((am,1), (am,1)), I -> List((I,1), (I,1)), Daxin -> List((Daxin,1)), Chinese -> List((Chinese,1)))
    println(w2.mapValues(_.foldLeft(0)(_+_._2)))
    
    
//  def  foldLeft[B](z: B)(op: (B, A) ⇒ B): B
    println(w2.mapValues(x=>x.foldLeft(0)(_+_._2)))//foldLeft(0)(_+_._2)中第一个0表示起始值，第一个下划线表示每次累计的数字和，第二个下划线是元组的第二数字
        
    
    //map转成List 是将map的key和value组成元组之后作为list的一个元素
    println("w2.mapValues(x=>x.foldLeft(0)(_+_._2)).toList : "+w2.mapValues(x=>x.foldLeft(0)(_+_._2)).toList)
    
    println("w2.mapValues(x=>x.foldLeft(0)(_+_._2)).toList.sortBy(x=>x._2).reverse  : "+w2.mapValues(x=>x.foldLeft(0)(_+_._2)).toList.sortBy(x=>x._2).reverse)
    println("w2.mapValues(x=>x.foldLeft(0)(_+_._2)).toList.sortBy(x=>x._2)  : "+w2.mapValues(x=>x.foldLeft(0)(_+_._2)).toList.sortBy(x=>x._2))
    
    println("**********************************************")
    //Applies a binary operator to a start value and all elements of this list, going left to right.
    println("list.foldLeft(0)(_+_) : "+list.foldLeft(0)(_+_))
    
    println("**********************************************")
    val word=List("I am Chinese ","I am Daxin")
    println(word.map { x => x.split(" ").toList})
    println(word.map { x => x.split(" ").toList }.flatten)
    
  }
}
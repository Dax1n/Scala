package com.daxin

object ListDemo {
  
  def main(args : Array[String]){
    
    val list=List(1,2,3,4,5,6,7,8);
    
    //  par是将函数转成并行集合
    val ls =list.par
    
    println(ls)
    
    //ls是并行集合，所以下面这个求和过程是并行计算求和
     println(" ls.reduce((x,y)=>x+y) :"+ ls.reduce((x,y)=>x+y))
     
     //foldLeft是非并行计算
     println("ls.sum :"+ls.foldLeft(10)(_+_))
     
     
     println("***********聚集操作***********")
     
      val ll=List(List(1,2,3),List(4,5,6),List(7,8))
      println(ll.flatten)
      //0： 初始值    _+_.sum中 第一个下环线是当前初始值 第二个下划线是里面每一个list求和        
      //(x,y)=>x+y ：an associative operator（组合操作符） used to combine results from different partitions
      println("ll.aggregate(0)(_+_.sum , (x,y)=>x+y) :"+ll.aggregate(0)(_+_.sum , (x,y)=>x+y))
      println("ll.aggregate(0)(_+_.sum , (x,y)=>x+y) :"+ll.aggregate(0)(_+_.sum , _+_))
      
       println("***********聚集复杂操作***********")
       println("ll.par.size :"+ll.par.size)
       println("解释：")
       println("ll.par是转换成并行集合，之后在每一个并行的集合上做聚集操作（言外之意：初始值会在每一个并行集合上进行聚集操作）")
       println("ll.par.aggregate(0)(_+_.sum , _+_) :"+ll.par.aggregate(0)(_+_.sum , _+_))
       println("并行集合的个数为： "+ll.par.size+" ,在每一并行集合上加上初始值10之后在聚集")
       println("ll.par.aggregate(10)(_+_.sum , _+_) :"+ll.par.aggregate(10)(_+_.sum , _+_))
      
      
      println("***********并集操作***********")
      
        val ll1=List(1,2,3,4,5,6,8,8,8)
        val ll2=List(6,7,8,9,10)
        //相同元素不会删除，都保留
        println(ll1.union(ll2))
        
        println("***********交集操作***********")
                
        println(ll1.intersect(ll2))

        
        println("***********差集操作***********")
        //a new collection of type That which contains all elements of this list except some of occurrences of elements that also appear in that.
        //If an element value x appears n times in that, then the first n occurrences of x will not form part of the result, but any following occurrences will.
        // 求差运算，如果this中的元素在that中出现删除this中该元素，但是如果this中的某一元素出现n次，而该元素在that中只出现一次的话那么结果中会有n-1次该元素的出现，见下面代码
        println(ll1.diff(ll2))//ll1中有3个8 ，that中有一个8，所以结果中有2个8出现
        
        
        
        
        
        
        
      
      
      
  }
  
}
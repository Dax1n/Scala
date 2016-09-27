package com.daxin

object ListDemo {
  
  def main(args : Array[String]){
    
    val list=List(1,2,3,4,5,6,7,8);
    
    //  par�ǽ�����ת�ɲ��м���
    val ls =list.par
    
    println(ls)
    
    //ls�ǲ��м��ϣ��������������͹����ǲ��м������
     println(" ls.reduce((x,y)=>x+y) :"+ ls.reduce((x,y)=>x+y))
     
     //foldLeft�Ƿǲ��м���
     println("ls.sum :"+ls.foldLeft(10)(_+_))
     
     
     println("***********�ۼ�����***********")
     
      val ll=List(List(1,2,3),List(4,5,6),List(7,8))
      println(ll.flatten)
      //0�� ��ʼֵ    _+_.sum�� ��һ���»����ǵ�ǰ��ʼֵ �ڶ����»���������ÿһ��list���        
      //(x,y)=>x+y ��an associative operator����ϲ������� used to combine results from different partitions
      println("ll.aggregate(0)(_+_.sum , (x,y)=>x+y) :"+ll.aggregate(0)(_+_.sum , (x,y)=>x+y))
      println("ll.aggregate(0)(_+_.sum , (x,y)=>x+y) :"+ll.aggregate(0)(_+_.sum , _+_))
      
       println("***********�ۼ����Ӳ���***********")
       println("ll.par.size :"+ll.par.size)
       println("���ͣ�")
       println("ll.par��ת���ɲ��м��ϣ�֮����ÿһ�����еļ��������ۼ�����������֮�⣺��ʼֵ����ÿһ�����м����Ͻ��оۼ�������")
       println("ll.par.aggregate(0)(_+_.sum , _+_) :"+ll.par.aggregate(0)(_+_.sum , _+_))
       println("���м��ϵĸ���Ϊ�� "+ll.par.size+" ,��ÿһ���м����ϼ��ϳ�ʼֵ10֮���ھۼ�")
       println("ll.par.aggregate(10)(_+_.sum , _+_) :"+ll.par.aggregate(10)(_+_.sum , _+_))
      
      
      println("***********��������***********")
      
        val ll1=List(1,2,3,4,5,6,8,8,8)
        val ll2=List(6,7,8,9,10)
        //��ͬԪ�ز���ɾ����������
        println(ll1.union(ll2))
        
        println("***********��������***********")
                
        println(ll1.intersect(ll2))

        
        println("***********�����***********")
        //a new collection of type That which contains all elements of this list except some of occurrences of elements that also appear in that.
        //If an element value x appears n times in that, then the first n occurrences of x will not form part of the result, but any following occurrences will.
        // ������㣬���this�е�Ԫ����that�г���ɾ��this�и�Ԫ�أ��������this�е�ĳһԪ�س���n�Σ�����Ԫ����that��ֻ����һ�εĻ���ô����л���n-1�θ�Ԫ�صĳ��֣����������
        println(ll1.diff(ll2))//ll1����3��8 ��that����һ��8�����Խ������2��8����
        
        
        
        
        
        
        
      
      
      
  }
  
}
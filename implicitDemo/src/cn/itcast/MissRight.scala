package cn.itcast

class MissRight[T] {
  
  
  //柯里化，柯里化方法传入第一个括号的参数之后就变成函数了
  //第二个括号参数是传入一个T隐式转换为Ordered[T]
  def choose(first:T,second:T)(implicit ord:T=>Ordered[T]):T={//相当于视图定界
    // >比较符号是Ordered的修饰符
    if(first > second) first else second
  }
  
  
  //第二个括号参数是一个Ordering[T]类型变量
  def select (first:T,second:T)(implicit ord:Ordering[T]):T={
    if(ord.gt(first, second)) first else second
  }
  
  
}

class Girl(val name:String,var faceValue:Int,val high:Int)

object MissRight{
  def main(args: Array[String]): Unit = {
    import  MyPredefGirl._
    val mr=new MissRight[Girl]
    val g1=new Girl("Mali",99,180)
    val g2=new Girl("Jerry",88,160)
    val r=mr.choose(g1,g2)//choose是柯里化方法，但是第二个括号参数列表没有传递是因为使用了隐式转换
    
    println(r.name)
    
    println(mr.select(g1, g2).name)
  }
  
}
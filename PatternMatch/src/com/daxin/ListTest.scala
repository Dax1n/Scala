package com.daxin

object Test extends App {

  // 列表可以使用两种基本的构建模块来定义，一个无尾Nil和::，这有明显的缺点。Nil也代表了空列表。所有上述列表可以定义如下
  // List of Strings
  val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))

  println(fruit)

  // List of Integers
  val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
  println(nums)

  // Empty List.
  val empty = Nil
  println(empty)
  // Two dimensional list
  val dim = (1 :: (0 :: (0 :: Nil))) ::
    (0 :: (1 :: (0 :: Nil))) ::
    (0 :: (0 :: (1 :: Nil))) :: Nil
  println(dim)

  // 所有的操作都可以体现在以下三个方法来讲：
  //方法	               描述
  //head	        此方法返回的列表中的第一个元素。
  //tail	        此方法返回一个由除了第一个元素外的所有元素的列表。
  //isEmpty	    如果列表为空，此方法返回true，否则为false。

  //  可以使用:::运算符或列表List.:::()方法或List.concat()方法来添加两个或多个列表。下面是一个例子：
 println()
  println("可以使用:::运算符或列表List.:::()方法或List.concat()方法来添加两个或多个列表。下面是一个例子：")
  val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
  val fruit2 = "mangoes" :: ("banana" :: Nil)

  // use two or more lists with ::: operator
  var fruit3 = fruit1 ::: fruit2
  println("fruit3 = fruit1 ::: fruit2 : " + fruit3)

  // use two lists with Set.:::() method
  fruit3 = fruit1.:::(fruit2)
  println("fruit3 = fruit1.:::(fruit2) : " + fruit3)

  // pass two or more lists as arguments
  fruit3 = List.concat(fruit1, fruit2)
  println("fruit3 = List.concat(fruit1, fruit2) : " + fruit3)

  println()
  //以使用List.fill()方法创建，包括相同的元素如下的零个或更多个拷贝的列表：
  println("以使用List.fill()方法创建，包括相同的元素如下的零个或更多个拷贝的列表：")

  val fruit4 = List.fill(3)("apples") // Repeats apples three times.
  println("fruit4 : " + fruit4)

  val num = List.fill(10)(2) // Repeats 2, 10 times.
  println("num : " + num)
  
  
  
  
  
   println()
    println("tabulate单词有制成表格的意思，使用tabulate的函数制成list")
  // Creates 5 elements using the given function.
      val squares = List.tabulate(6)(n => n * n)
      println( "squares : " + squares  )

      // 0*（0,1,2,3,4）
      // 1*（0,1,2,3,4）
      // 2*（0,1,2,3,4）
      // 3*（0,1,2,3,4）
      val mul = List.tabulate( 4,5 )( _ * _ )      
      println( "mul : " + mul  )
  
      
      println("可以使用List.reverse方法来扭转列表中的所有元素。以下为例子来说明的用法：")
  
     println( "Before reverse fruit : " + fruit )

      println( "After reverse fruit : " + fruit.reverse )
  
  
  
  
  
  
  
  
  

}
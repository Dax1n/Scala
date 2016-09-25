package com.daxin

//在Scala中Option类型用样例类来表示可能存在或也可能不存在的值(Option的子类有Some和None)。
//Some包装了某个值，None表示没有值

object OptionDemo {
  def main(args: Array[String]) {

    //Map是package scala中
    val map = Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4)

    //Scala  map get不到返回None
    map.get("a") //get的定义 def get(key: A): Option[B]
    //None 是case object类型的，所以也可以手动进行判断
    println("map.get(\"d\").equals(None) : " + map.get("f").eq(None))

    val vls = if (map.get("f").eq(None)) {

      "f"
    } else {
      map.get("f")
    }

    println("vls : " + vls)

    val value = map.get("a") match {
      //      Some包装了某个值，None表示没有值
      case Some(i) =>
        println("case Some(i) : " + i); i
      case None => println("None "); 0
    }

    println("value : " + value)

    //其实map可以不使用模式匹配，下面这种建议使用

    val value1 = map.getOrElse("a", 0);
    
    //阅读源码便知getOrElse的实现也是使用模式匹配，源码如下
//      def getOrElse[B1 >: B](key: A, default: => B1): B1 = get(key) match {
//       case Some(v) => v
//       case None => default
//     }
    println("value1 : " + value1)

  }
}

package com.daxin

import scala.io.Source

/**
 * （nymph是女神的意思）
 * @author 青春常驻Dax1n
 *
 */
class Nymph {

  var name: String = "abc"

  println(name)

  //读取文件,如果异常的话：Exception in thread "main" java.nio.charset.MalformedInputException: Input length = 1
  //因为windows字符编码问题导致，
  //更改scala ide for eclipse编码格式
  //配置java文件的编码格式：windows->Preferences->general->ContentTypes->Java Source File->GBK==Update
  //重新运行，错误解决
  //或者直接修改数据文件编码为utf-8
  try {
    val content = Source.fromFile("G://data.txt").mkString
    println(content)
  } catch {
    //异常处理
    case e: Exception => e.printStackTrace() // TODO: handle error
  } finally {
    println("finally...")
  }
  
  def sayHello():Unit={
    print("sayHello")
  }
  
  
  
  /**
   * 小提示：
   * 主构造器里面的代码还是要注意的，在Spark源码中经常有在主构造器中创建线程，配置线程，然后在主构造器的最后一行启动线程。
   * 为了以后读scala代码养成好习惯
   * 
   */
  
  name.toUpperCase()//模拟

}

object Nymph {
  def main(args: Array[String]): Unit = {
    val ny = new Nymph
  }
}
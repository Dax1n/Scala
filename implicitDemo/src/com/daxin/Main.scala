package com.daxin

import scala.io.Source
import java.io.File

/**
 * 3.1.	概念
 * 隐式转换和隐式参数是Scala中两个非常强大的功能，利用隐式转换和隐式参数
 * 你可以提供优雅的类库，对类库的使用者隐匿掉那些枯燥乏味的细节。
 * 3.2.	作用
 * 隐式的对类的方法进行增强，丰富现有类库的功能
 * 3.3.	隐式转换函数
 * 是指那种以implicit关键字声明的带有单个参数的函数
 */



object MainApp {
  def main(args: Array[String]): Unit = {
    //导入隐式转换
    import RichFile._
    
    val file=new File("G://data.txt")
    /**
     * 隐式转换执行过程：
     * 				当file调用read时候发现file类没有read方法，但是通过查找上下文（上下文中导入import RichFile._）发现：
     * 				implicit def file2RichFile(file: File) = new RichFile(file) 这句话，可以转成RichFile
     * 				在RichFile中恰好有read方法，所以执行。
     */
    
    val content=file.read
    println(content)

  }
}


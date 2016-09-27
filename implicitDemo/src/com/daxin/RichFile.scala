package com.daxin

import scala.io.Source
import java.io.File

/**
 * 3.1.	概念
 *
 * 隐式转换和隐式参数是Scala中两个非常强大的功能，利用隐式转换和隐式参数
 *
 * 你可以提供优雅的类库，对类库的使用者隐匿掉那些枯燥乏味的细节。
 *
 * 3.2.	作用
 *
 * 隐式的对类的方法进行增强，丰富现有类库的功能
 *
 *
 * 3.3.	隐式转换函数
 *
 * 是指那种以implicit关键字声明的带有单个参数的函数
 *
 *
 *
 */

class RichFile(fileName: File) {

  def read = Source.fromFile(fileName).mkString

}

object RichFile {
  
  //使用implicit关键字定义的方法叫: 隐式转换方法
  //隐式转换的发生应该就是根据这个关键字进行的
  implicit def file2RichFile(from: File) = new RichFile(from)

}

object MainApp {
  def main(args: Array[String]): Unit = {
    //导入隐式转换
    import RichFile._
    //import RichFile.file2RichFile
    println(new File("G://data.txt").read)

  }
}


package com.daxin

import scala.util.Random
/**
 * 模式匹配之内容匹配
 */
object PatternMatchDemo1 {

  def main(args: Array[String]): Unit = {

    val arr = Array("YoshizawaAkiho", "YuiHatano", "AoiSola")

    while (true) {

      val name = arr(Random.nextInt(arr.length))
      //模式匹配   match和case结合使用
      
      name match {
        //匹配内容
        // =>是一个偏函数，后面介绍
        case "YoshizawaAkiho" => println("吉泽老师...")
        case "YuiHatano"      => println("波多老师...")
        //下划线表示：通配符，例如导包时候也使用
        case _                => println("真不知道你们在说什么...")
      }

      Thread.sleep(1000)
    }

  }
}
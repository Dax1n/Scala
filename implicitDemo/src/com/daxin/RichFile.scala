package com.daxin

import java.io.File
import scala.io.Source

class RichFile(fileName: File) {

  def read = Source.fromFile(fileName).mkString

}
object RichFile {

  implicit def file2RichFile(file: File) = new RichFile(file)

}
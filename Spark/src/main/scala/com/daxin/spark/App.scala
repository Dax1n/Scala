package com.daxin.spark

import java.io.File

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author ${user.name}
  */
object App {

  def main(args: Array[String]) {

    val conf = new SparkConf()

    conf.setAppName("SPARKWORDCOUNT").setMaster("spark://node1:7077")
    val sc = new SparkContext(conf)

    val f:File=new File("/home/daxin/wordcount/")

    if(f.exists())
      {
        f.delete()
      }
//  def mapPartitionsWithIndex[U: ClassTag](f: (Int, Iterator[T]) => Iterator[U],preservesPartitioning: Boolean = false)

    val x = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10), 3)
    def myfunc(index: Int, iter: Iterator[Int]) : Iterator[String] = {
      iter.toList.map(x => index + "," + x).iterator
    }

    val rdd1=x.map(y=>(y,"a"))


   //res10: Array[String] = Array(0,1, 0,2, 0,3, 1,4, 1,5, 1,6, 2,7, 2,8, 2,9, 2,10)

    val line=sc.textFile("/home/daxin/wordfiles/word")
    val result = line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    result.saveAsTextFile("/home/daxin/wordcount/")
    sc.stop()


  }

}

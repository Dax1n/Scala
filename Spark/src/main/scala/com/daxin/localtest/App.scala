package com.daxin.localtest

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by 青春常驻Dax1n on 2016/10/8.
  */
object App {

  def main(args: Array[String]): Unit = {

    //一些关于RDD的隐式转换都在RDD的伴生兑现各种实现的
    //就是在object RDD中实现的，好处是在隐式转换的时候不用创建RDD的实例就可以使用隐式函数
    //如果隐式转换在class RDD中的话需要创建一个RDD实例然后在调用隐式转换

    //  implicit def rddToPairRDDFunctions[K, V]  //wordcount中的隐式转换，RDD转成PairRDDFunctions

    val conf = new SparkConf()

    conf.setAppName("SPARKWORDCOUNT").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val lines = sc.parallelize(Array("Hadoop", "HBase", "Spark"))

    // val lines=sc.textFile("G:\\data.txt")

    val result = lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    result.foreach(println)
    sc.stop()

  }


}

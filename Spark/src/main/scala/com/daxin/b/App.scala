package com.daxin.b

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by 青春常驻Dax1n on 2016/10/8.
  */
object App {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()

    conf.setAppName("SPARK_Broadcast").setMaster("spark://node1:7077")
    val sc = new SparkContext(conf)
    val b = sc.broadcast(10)
    val list = List(1, 2, 3, 4, 5)
    val rdd = sc.parallelize(list, 2)
    val newRDD = rdd.map(_ * b.value)

    val result = newRDD.collect()

    /**
      *
      * 错误代码：这个是executor打印，driber控制台不会有输出
      * newRDD.foreach{
      * x=>println(x)
      * }
      *
      */


    /**
      *newRDD.data= 10
      *newRDD.data= 20
      *newRDD.data= 30
      *newRDD.data= 40
      *newRDD.data= 50
      *
      */
    for (a <- result) {
      println("newRDD.data= " + a)
    }
    sc.stop()

  }

}

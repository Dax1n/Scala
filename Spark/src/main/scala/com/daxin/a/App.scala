package com.daxin.a

import java.io.File

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author ${user.name}
  *
  *         累加器
  *         mvn -U -DskipTests clean package
  *
  *
  *
  * 可以定义自己的类型累加器
  *
  *
  * 继承AccumulatorV2抽象类即可
  * object VectorAccumulatorV2 extends AccumulatorV2[MyVector, MyVector]
  *
  *object是定义一个单例的累加器
  *
  * class 也可以
  *
  *
  *
  *
  */
object App {

  def main(args: Array[String]) {

    val conf = new SparkConf()

    conf.setAppName("SPARK_Accumulator").setMaster("spark://node1:7077")
    val sc = new SparkContext(conf)

    val la = new LongAccumulator()
    la.add(5)
    // api 2.0
    sc.register(la,"LongAccumulator")

    val lists = List(1, 2, 3, 4, 5)
    //转换list为RDD
    val rdd = sc.parallelize(lists)


    val newRDD = rdd.foreach {

      //task 闭包
      x => la.add(x)





//      x => la.add(la.value)//注释上面那句话，打开这句话。输出结果如下：
//        la.count= 6//运算次数6次正确
//        la.value= 5//获取不到值为0
//        la.sum= 5//获取不到值为0




      //这里面无法取Accumulator值，这个是task 闭包 在executor上运行的

//        asks running on a cluster can then add to it using the add method. However, they cannot read its value.
//        Only the driver program can read the accumulator’s value, using its value method.
      //  println("la.value= " + la.value)//不报错，获取不到数值而已
    }

    /**
      * la.count= 6
      * la.value= 20
      * la.sum= 20
      *
      */
    println("la.count= " + la.count)
    println("la.value= " + la.value)
    println("la.sum= " + la.sum)

    sc.stop()


  }

}

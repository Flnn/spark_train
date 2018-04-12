package com.flnn.sparkSQL

import org.apache.spark._
import org.apache.spark.sql.SQLContext

/**
  * spark 1.x版本的入口
  */
object SQLContextApp {

  def main(args: Array[String]){
    var sparkConf = new SparkConf()
    sparkConf.setAppName("SQLContextApp").setMaster("local[2]")
    var sc = new SparkContext(sparkConf)
    var sqlContext = new SQLContext(sc)
    var content = sqlContext.read.format("json").load("F:\\大数据技术资料和软件\\spark-examples-data\\people.json")
    content.printSchema()
    content.show(false)
    sc.stop()
  }
}

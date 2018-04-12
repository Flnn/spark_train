package com.flnn.sparkSQL

import org.apache.spark.sql.SparkSession

object SparkSessionApp {

  def main(args: Array[String]): Unit = {
    var sparkSession = SparkSession.builder().appName("SparkSessionApp").master("local[2]").getOrCreate()
    var people = sparkSession.read.json("F:\\大数据技术资料和软件\\spark-examples-data\\people.json")
    people.show()
    sparkSession.stop()
  }
}

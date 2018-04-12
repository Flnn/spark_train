package com.flnn.spark.clm

import org.apache.spark.sql.SparkSession

/**
  * 统计报表
  */
object ReportApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("ReportApp").master("local[2]").getOrCreate()
    import spark.implicits._
    val detailDF = spark.read.csv("F:\\大数据技术资料和软件\\0321_be_point_detail.csv")
    detailDF.printSchema()
    detailDF.take(10).foreach(println)
    spark.stop()
  }

}

package com.flnn.spark.imooc

import org.apache.spark.sql.SparkSession

object SparkStatFormatJob {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("SparkStatFormatJob").master("local[2]").getOrCreate()
    val access = spark.sparkContext.textFile("F:\\大数据技术资料和软件\\access_100.log")
    //access.take(10).foreach(println)
    access.map(line =>{
      val splits = line.split("\t")
      val time = splits(0)
      val url = splits(1)
      val ip = splits(3)
      (ip,time,url)
    }).take(10).foreach(println)
    spark.stop()
  }
}

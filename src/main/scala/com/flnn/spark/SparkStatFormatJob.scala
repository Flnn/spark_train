package com.flnn.spark

import org.apache.spark.sql.SparkSession

object SparkStatFormatJob {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SparkStatFormatJob").getOrCreate()

    spark.read.json()

    import spark.implicits._
  }
}

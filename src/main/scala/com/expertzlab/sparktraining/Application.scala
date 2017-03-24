package com.expertzlab.sparktraining

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Application {

  def main(args: Array[String]):Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(conf)
    println("Starting the Job..")
    // Load our input data.
    val input = sc.textFile("/Users/gireeshbabu/workspace/README.md")
    // Split it up into words.
    val words = input.flatMap(line => line.split(" "))
    // Transform into pairs and count.
    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y }
    // Save the word count back out to a text file, causing evaluation.
    counts.saveAsTextFile("/Users/gireeshbabu/workspace/outfile.txt")
    println("Done")
  }

}
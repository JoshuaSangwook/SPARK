package com.lee.rdf

import org.apache.spark.ml.{PipelineModel, Pipeline}
import org.apache.spark.ml.classification.{DecisionTreeClassifier,
  RandomForestClassifier, RandomForestClassificationModel}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{VectorAssembler, VectorIndexer}
import org.apache.spark.ml.linalg.Vector
import org.apache.spark.ml.tuning.{ParamGridBuilder, TrainValidationSplit}
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import scala.util.Random

object RunRDF {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic")
      .master("local[*]")
      .config("spark.driver.host", "127.0.0.1")
      .getOrCreate()
    import spark.implicits._

    val dataWithoutHeader = spark.read.
      option("inferSchema", true).
      option("header", false).
      csv("./src/test/resources/covtype.data")

    dataWithoutHeader.show()
  }
}

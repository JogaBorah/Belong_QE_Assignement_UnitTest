package common

import io.github.qa.belong.assignment.functions.GETPredictions
import org.apache.spark.sql.SparkSession


class GetTopMonthlyPredSpec extends GetTopPredSpec{

  val config = Map("a"->"sensorCountURL","b"->"https://data.melbourne.vic.gov.au/resource/b2ak-trbp.json")

  behavior of "GetTopMonthlyPredictions"
  it should "get the monthly top 10 predictions" in {
    val sparkSession: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .getOrCreate()

    val df = GETPredictions("monthly",config)
    assert(df.count()==10)
  }
}


package common

import io.github.qa.belong.assignment.functions.GETPredictions
import org.apache.spark.sql.SparkSession


class GetTopDailyPredSpec extends GetTopPredSpec{

  val config = Map("a"->"sensorCountURL","b"->"https://data.melbourne.vic.gov.au/resource/b2ak-trbp.json")

  behavior of "GetTopDailyPredictions"
  it should "get the daily top 10 predictions" in {
    val sparkSession: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .getOrCreate()

    val df = GETPredictions("daily",config)
    assert(df.count()==10)
  }
}

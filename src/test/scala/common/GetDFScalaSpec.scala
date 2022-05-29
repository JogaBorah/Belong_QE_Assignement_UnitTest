package common

import io.github.qa.belong.assignment.functions.GetDF
import org.apache.spark.sql.SparkSession


class GetDFScalaSpec extends GetTopPredSpec {

  behavior of "GetDF"
  it should "get the json data from url successfully" in {

    val url = "https://data.melbourne.vic.gov.au/resource/b2ak-trbp.json"
    val sparkSession: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .getOrCreate()
    val df = GetDF(url)
    assert(df.count() > 0)
  }
}

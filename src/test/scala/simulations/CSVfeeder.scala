package simulations
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CSVfeeder extends Simulation{

  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  val csvfeeder = csv("data/GameCSVfile.csv").circular

  def GetSpecificGame() = {
    repeat(10){
      feed(csvfeeder)
        .exec(http("Get Specific Game")
        .get("videogames/${gameId}")
        .check(jsonPath("$.name").is("${gameName}"))
        .check(status.is(200)))
        .pause(1)
    }
  }

  val scn = scenario("CSV feeder test")
    .exec(GetSpecificGame())
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}

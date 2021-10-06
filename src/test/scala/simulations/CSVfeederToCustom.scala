package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CSVfeederToCustom extends Simulation{

  var idNumbers = (1 to 10).iterator

  var customFeeder = Iterator.continually(Map("gameId" -> idNumbers.next()))

    val httpConf = http.baseUrl("http://localhost:8080/app/")
      .header("Accept", "application/json")
      .proxy(Proxy("localhost", 8888))

    val csvfeeder = csv("data/GameCSVfile.csv").circular

    def GetSpecificGame() = {
      repeat(10){
        feed(customFeeder)
          .exec(http("Get Specific Game")
            .get("videogames/${gameId}")
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

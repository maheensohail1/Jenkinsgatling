package simulations
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseBodyandExtract extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  val scn = scenario("Check JSON path")
    .exec(http("Get Specific Game")
      .get("videogames/1")
      .check(jsonPath("$.name").is("Resident Evil 4")))

    .exec(http("Get All Games")
    .get("videogames")
    .check(jsonPath("$[1].id").saveAs("gameID")))
    .exec{session => println(session); session}

    .exec(http("Get Specific Game")
      .get("videogames/${gameID}")
      .check(jsonPath("$.name").is("Gran Turismo 3"))
    .check(bodyString.saveAs("responsebody")))
    .exec{session => println(session("responsebody").as[String]); session}

      setUp(
      scn.inject(atOnceUsers(1))
      ).protocols(httpConf)


}

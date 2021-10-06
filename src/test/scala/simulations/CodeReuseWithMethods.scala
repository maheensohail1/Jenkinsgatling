package simulations
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class CodeReuseWithMethods extends Simulation{


  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  def getAllGames()= {
    repeat(3) {
      exec(http("Get All Games- 1st call")
        .get("videogames")
        .check(status.is(200)))
    }
  }
  def getSpecificGame() = {
    repeat(5) {
      exec(http("Get Specific Game")
        .get("videogames/1")
        .check(status.in(200 to 210)))
    }
  }

  val scn = scenario("Code Reuse")
    .exec(getAllGames())
    .pause(5)
    .exec(getSpecificGame())
    .pause(5)
    .exec(getAllGames())
  //Load scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}

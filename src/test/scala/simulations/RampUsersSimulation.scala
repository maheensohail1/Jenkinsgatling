package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RampUsersSimulation extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")


  def GetAllVideoGames() ={
    exec(http("Get all games")
      .get("videogames")
      .check(status.is(200)))
  }

  def getSpecificGame() ={
    exec(http("get specific game")
      .get("videogames/2")
      .check(status.is(200)))
  }

  val scn = scenario("Basic Load Simulation")
    .exec(GetAllVideoGames())
    .pause(5)
    .exec(getSpecificGame())
    .pause(5)
    .exec(GetAllVideoGames())

  setUp(
    scn.inject(
      nothingFor(5),
      //constantUsersPerSec(10)during(10)
    rampUsersPerSec(5) to (5) during (20)
    ).protocols(httpConf.inferHtmlResources()))
}

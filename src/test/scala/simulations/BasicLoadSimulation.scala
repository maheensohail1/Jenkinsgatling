package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration

class BasicLoadSimulation extends Simulation {

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
      atOnceUsers(5),
      rampUsers(10) during(10)
      ).protocols(httpConf.inferHtmlResources()))
}

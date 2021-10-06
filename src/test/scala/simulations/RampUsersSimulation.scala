package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.concurrent.duration._
import scala.util.Random

class RampUsersSimulation extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  def userCount: Int = getProperty("USERS", "3").toInt
  def rampDuration: Int = getProperty("RAMP_DURATION", "10").toInt
  def testDuration: Int = getProperty("DURATION", "60").toInt

  private def getProperty(propertyName: String, defaultValue: String) = {
    Option(System.getenv(propertyName))
      .orElse(Option(System.getProperty(propertyName)))
      .getOrElse(defaultValue)
  }

  before {
    println(s"Running test with ${userCount} users")
    println(s"Ramping users over ${rampDuration} seconds")
    println(s"Total Test duration: ${testDuration} seconds")
  }


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

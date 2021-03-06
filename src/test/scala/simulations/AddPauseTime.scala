package simulations
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class AddPauseTime extends Simulation{

  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  val scn = scenario("Video Game DB- 3 calls")
    .exec(http("Get All Games- 1st call")
      .get("videogames"))
    .pause(5)

    .exec(http("Get Specific Game")
      .get("videogames/1"))
    .pause(1,20)

    .exec(http("Get All Games- 2nd call")
      .get("videogames"))
    .pause(3000.milliseconds)

  //Load scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}

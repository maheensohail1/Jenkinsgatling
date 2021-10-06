

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class MyTest extends Simulation{
  // http conf
  val httpconf = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")
    .proxy(Proxy("localhost", 8888))
  // Scenario

  val scn = scenario("My First Test")
    .exec(http("Get All Games")
      .get("videogames"))

  //Load scenario
  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpconf)
}
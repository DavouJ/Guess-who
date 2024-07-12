package tests
import org.scalatest._
import main._

import scala.util.Random

class GameTest extends FlatSpec {
  val gameTest = Game.apply()

  println(gameTest)
  "people" should "be a sequence of random people" in {

    //println(gameTest.apply())
    assert(true )
  }
}

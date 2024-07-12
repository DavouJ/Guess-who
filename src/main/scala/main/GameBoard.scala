package main

import scala.collection.View.Filter
import scala.util.Random

// A map of persons with a key to represent board location
class GameBoard {

  // Randomly shuffle the sequence of Persons into the sequence people
  private val people: Tuple2[Seq[Person], Seq[Person]] =
    (
      Random.shuffle(Seq(
        Person("Davou", 24, "male", "Black", true),
        Person("Jen", 24, "female", "Brown", true),
        Person("Tim", 25, "male", "Blonde", true),
        Person("Amy", 25, "female", "Black", true),
        Person("Mike", 28, "male", "Blonde", true),
        Person("Chanel", 26, "female", "Blonde", true),
        Person("Tony", 25, "male", "Black", true),
        Person("Chris", 22, "male", "Brown", true),
        Person("Heather", 24, "female", "Blonde", true),
        Person("Tina", 22, "female", "Brown", true),
        Person("Mario", 21, "male", "black", true),
        Person("Sharon", 24, "female", "Brown", true)
    )),
      Random.shuffle(Seq(
        Person("Davou", 24, "male", "Black", true),
        Person("Jen", 24, "female", "Brown", true),
        Person("Tim", 25, "male", "Blonde", true),
        Person("Amy", 25, "female", "Black", true),
        Person("Mike", 28, "male", "Blonde", true),
        Person("Chanel", 26, "female", "Blonde", true),
        Person("Tony", 25, "male", "Black", true),
        Person("Chris", 22, "male", "Brown", true),
        Person("Heather", 24, "female", "Blonde", true),
        Person("Tina", 22, "female", "Brown", true),
        Person("Mario", 21, "male", "black", true),
        Person("Sharon", 24, "female", "Brown", true)
    ))
  )


  def fillBoard(): Map[String, Person] = Map(
    "P1" -> people._1(1),
    "A2" -> people._1(2),
    "A3" -> people._1(3),
    "A1" -> people._1(4),
    "A4" -> people._1(5),
    "A5" -> people._1(6),
    "B1" -> people._1(7),
    "B2" -> people._1(8),
    "B3" -> people._1(9),
    "B4" -> people._1(10),
    "B5" -> people._1(11),
    "P2" -> people._2(1),
    "C1" -> people._2(2),
    "C2" -> people._2(3),
    "C3" -> people._2(4),
    "C4" -> people._2(5),
    "C5" -> people._2(6),
    "D1" -> people._2(7),
    "D2" -> people._2(8),
    "D3" -> people._2(9),
    "D4" -> people._2(10),
    "D5" -> people._2(9),
  )

  def updateBoard(people: Map[String, Person]): Map[String, Person] = Map(

  )

  private def isCorrect(person: Person, name: String = "", age: Int = 0, gender: String = "", hairCol: String = ""): Boolean = {
    if (name.nonEmpty) {
      person.name == name
    } else if (age != 0) {
      person.age == age
    } else if (gender.nonEmpty) {
      person.gender == gender
    } else if(hairCol.nonEmpty){
      person.hairCol == hairCol
    }else{
      false
    }
  }

  def guess(populatedBoard: Map[String, Person], name: String = "", age: Int = 0, gender: String = "", hairCol: String = "") = {

    //if the guess is incorrect
    // turn person(s) who have that characteristic to false

    if (isCorrect(populatedBoard("P1"), name, age, gender, hairCol)) {
      println("correct guess")
      populatedBoard map {
        case (k, person: Person) if (hairCol.nonEmpty) =>
          if (populatedBoard("P1").hairCol != hairCol) {
            
            (k, person.copy(isActive = false))
          } else {
            (k, person)
          }
        case (k, person: Person) if (name.nonEmpty) =>
          if (populatedBoard("P1").name != name ) {
            
            (k, person.copy(isActive = false))
          } else {
            (k,person)
          }
        case (k, person: Person) if (gender.nonEmpty) =>
          if (populatedBoard("P1").gender != gender && person.gender == gender) {
            
            (k, person.copy(isActive = false))
          } else {
            (k, person)
          }
        case (k, person: Person) if (age != 0) =>
          if ((populatedBoard("P1").age == age) && (person.age == age)) {
            
            (k, person.copy(isActive = false))
          } else {
            (k, person)
          }

      }
    }else{
      println("incorrect guess!")
      populatedBoard
    }

  }


  def printBoard(populatedBoard: Map[String, Person]) = {


    println("     ----------PLAYER1----------")
    println(s"      ----------" + populatedBoard("P1").name + "----------")
    println(s"[ ${populatedBoard("A1").isActive} ] [ ${populatedBoard("A2").isActive} ] [ ${populatedBoard("A3").isActive} ] [ ${populatedBoard("A4").isActive} ] [ ${populatedBoard("A5").isActive} ] ")
    println(" ")
    println(s"[ ${populatedBoard("B1").isActive} ] [ ${populatedBoard("B2").isActive} ] [ ${populatedBoard("B3").isActive} ] [ ${populatedBoard("B4").isActive} ] [ ${populatedBoard("B5").isActive} ] ")
    println(" ")
    println(" ")
    println(s"[ ${populatedBoard("C1").isActive} ] [ ${populatedBoard("C2").isActive} ] [ ${populatedBoard("C3").isActive} ] [ ${populatedBoard("C4").isActive} ] [ ${populatedBoard("C5").isActive} ] ")
    println(" ")
    println(s"[ ${populatedBoard("D1").isActive} ] [ ${populatedBoard("D2").isActive} ] [ ${populatedBoard("D3").isActive} ] [ ${populatedBoard("D4").isActive} ] [ ${populatedBoard("D5").isActive} ] ")
    println(s"      ----------" + populatedBoard("P2").name + "----------")
    println("     ----------PLAYER2----------")

  }
}








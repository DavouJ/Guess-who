package main



case class Game() {

  val board: GameBoard = new GameBoard
  val populatedBoard= board.fillBoard()

  board.printBoard(populatedBoard)

  def guess(characteristic: String, guess: String) = {

      val updatedBoard = characteristic match{
        case "hairCol" => board.guess(populatedBoard, hairCol = guess )
        case "name" => board.guess(populatedBoard, name = guess )
        case "age" => board.guess(populatedBoard, age = guess.toInt )
        case "gender" => board.guess(populatedBoard, gender = guess )
      }

    board.printBoard(updatedBoard )
  }









}

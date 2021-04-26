package scala2021.stalalayeu.task04

import scala.annotation.tailrec

object task04 {

  val listCoins = List(2,3,5).sorted
  val amountToChange = 18

  def main(args: Array[String]) = {
    println(listCoins.sorted + " => " + amountToChange)
    println("---------------")
    val list_ = listCoins.sorted
      .map(e => List.fill(amountToChange / e)(e))

    val list__ = list_
      .appended(List.fill(list_.head.length - 1)(0))
      .flatten
      .combinations(list_.head.length)
      .filter(_.sum == amountToChange)
      .map(_.filter(_ > 0))

    println(list__.mkString("\r\n"))

  }

}

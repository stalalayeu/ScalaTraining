package scala2021.stalalayeu.task03

import scala.annotation.tailrec

object task03_1 {

  val list2Code = "aaabbccaadeeee".toList

  def main(args: Array[String]) = {
    println(list2Code)
    println("---------------")

    println(loop(list2Code, 1))
  }

//  @tailrec
  def loop(e: List[Char], c:Int): List[(Int, Char)] = {
    if (e.tail.isEmpty)
      return (c, e.head) :: Nil

    val newHead =
      if (e.head.compare(e.tail.apply(0)) == 0)
        (List.empty[(Int, Char)] , c + 1)
      else
        ((List.empty[(Int, Char)] :+ (c, e.head)), 1)

    newHead._1 ::: loop(e.tail, newHead._2)
  }
}

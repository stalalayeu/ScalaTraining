package scala2021.stalalayeu.task03

import scala.annotation.tailrec

object task03_2 {

  val list2Code = "aaabbccaadeeee".toList

  def main(args: Array[String]) = {
    println(list2Code)
    println("---------------")

    println(loop(list2Code.map((0, _))))
  }

  @tailrec
  def loop(e: List[(Int, Char)]): List[(Int, Char)] = {
    if (e.tail.isEmpty)
      return (e.head._1 + 1, e.head._2) :: Nil
    if (e.tail.apply(0)._1 > 0)
      return e.tail :+ (e.head._1 + 1, e.head._2)
    if (e.head._2.compare(e.tail.apply(0)._2) == 0) {
      loop((e.head._1 + 1, e.head._2) :: e.tail.tail)
    } else {
      loop(e.tail :+ (e.head._1 + 1, e.head._2))
    }
  }
}

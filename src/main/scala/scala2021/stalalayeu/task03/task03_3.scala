package scala2021.stalalayeu.task03

import scala.annotation.tailrec

object task03_3 {

  val list2Code = "aaabbccaadeeee".toList

  def main(args: Array[String]) = {
    println(list2Code)
    println("---------------")

    println(list2Code.span(_ == list2Code.head))

    println(loop(list2Code, List.empty[(Int, Char)]))
  }

  @tailrec
  def loop(l: List[Char], e: List[(Int, Char)]): List[(Int, Char)] = {
    if (l.isEmpty) return e
    val split = l.span(_ == l.head)
    loop(split._2, e:::List((split._1.length, split._1.head)))
  }
}

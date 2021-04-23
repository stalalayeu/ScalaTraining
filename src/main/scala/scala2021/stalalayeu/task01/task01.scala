package scala2021.stalalayeu.task01

import scala.::

object task01 {

  val counts = Array(
    "900,google.com",
    "60,mail.yahoo.com",
    "10,mobile.sports.yahoo.com",
    "40,sports.yahoo.com",
    "10,stackoverflow.com",
    "2,en.wikipedia.org",
    "1,es.wikipedia.org",
    "1,mobile.sports"
  )

  def main(args: Array[String]) = {
    println(counts.mkString("\r\n"))
    println("---------------")

    val res = counts.toList
      .map(_.split(",").toList)
      .flatMap(loop(_))
      .groupBy(_.apply(1))
      .collect{case e => (e._1, e._2.map(_.apply(0).toInt).sum)}
      .toSeq.sortWith(sort)
      .foreach(println)

  }

  def sort(s1: (String, Int), s2: (String, Int)): Boolean = {
    val s1_ = s1._1.split("\\.").reverse.mkString
    val s2_ = s2._1.split("\\.").reverse.mkString
    return s1_ < s2_
  }

  def loop(e: List[String]): List[List[String]] = {
    if (e.apply(1).indexOf(".") >= 0)
      e :: loop(e.apply(0) :: e.apply(1).substring(e.apply(1).indexOf(".") + 1) :: Nil)
    else
      e :: Nil
  }

}

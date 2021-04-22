package scala2021.stalalayeu.task01

object task01 {

  val counts = Array(
    "900,google.com",
    "100,google.com",
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
      .map(_.split(","))
      .map { case Array(s1,s2) => (s1,s2)}
      .flatMap(e => loop(e))
      .groupBy(e => e._2)
      .collect({
        case e => (e._2, e._2.map(_._1.toInt).sum)
      })
      .toSeq.sortWith((e1, e2) => sort(e1._1.apply(0)._2, e2._1.apply(0)._2))

    println(res.mkString("\r\n"))
    println("---------------")

    res.map {case e: (List[(String, String)], Int) => (e._2, e._1.apply(0)._2)}
      .foreach(println)
  }

  def sort(s1: String, s2: String): Boolean = {
    val s1_ = s1.split("\\.").reverse.mkString
    val s2_ = s2.split("\\.").reverse.mkString
    return s1_ < s2_
  }

  def loop(s: (String, String)): List[(String, String)] = {
    if (s._2.indexOf(".") >= 0)
      s :: loop((s._1, s._2.substring(s._2.indexOf(".")+1)))
    else
      (s._1, s._2) :: Nil
  }

}

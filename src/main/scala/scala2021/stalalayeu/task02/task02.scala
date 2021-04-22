package scala2021.stalalayeu.task02

import scala.annotation.tailrec

object task02 {
  val pattern = "[\\(\\)].*".r

  val brackets = Array(
    "if((2+x)*(3-y)==3)",
    "Я сказал ему (это еще (не) сделано). (Но он не послушал)",
    ":-)",
    "())("
  )

  def main(args: Array[String]) = {
    println(brackets.mkString("\r\n"))
    println("---------------")

    val res = brackets.toList
      .map(e => loop(e,0) + " -> " + e)
      .foreach(println)

  }

  @tailrec
  def loop(s: String, level: Int): Boolean = {
    if (s.isEmpty || level < 0)
      level == 0
    else
      {
        val matcher = pattern.findFirstIn(s)
        if (matcher.isEmpty)
          loop("", level)
        else {
          val tail = matcher.get
          if (tail.startsWith("("))
            loop(tail.substring(1) ,level + 1)
          else
            loop(tail.substring(1) ,level - 1)
        }
      }
  }

}

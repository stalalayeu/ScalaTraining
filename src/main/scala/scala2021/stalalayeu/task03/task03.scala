package scala2021.stalalayeu.task03

object task03 {

  val list2Code = "aaabbccaadeeee".toList

  def main(args: Array[String]) = {
    println(list2Code)
    println("---------------")

    println(loop(list2Code.map((1, _))))
  }

  def loop(e: List[(Int, Char)]): List[(Int, Char)] = {
    if (e.tail.isEmpty)
      return e.head :: Nil
    if (e.head._2.compare(e.tail.apply(0)._2) == 0) {
      loop((e.head._1 + 1, e.head._2) :: e.tail.tail)
    } else {
      e.head :: loop(e.tail)
    }
  }
}

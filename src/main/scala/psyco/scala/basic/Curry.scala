package psyco.scala.basic

/**
 * Created by lipeng on 15/8/6.
 */
object Curry extends App {
  /**
   * high level function
   */
  def sum(f: Int => Int)(a: Int)(b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1)(b)

  println(sum(x => x * x * x)(1)(10))
  println(sum(x => x)(1)(10))
}

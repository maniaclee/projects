package psyco.scala.basic

import scala.annotation.tailrec

/**
 * Created by lipeng on 15/8/6.
 * http://www.ibm.com/developerworks/cn/java/j-lo-funinscala1/
 */
object Recursive extends App {
  def quickSort(list: List[Int]): List[Int] = {
    if (list.isEmpty)
      list
    else
      quickSort(list.filter(_ < list.head)) ::: list.head :: quickSort(list.filter(_ > list.head))
  }

  def factorial(n: Int): Int = {
    @tailrec
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc else loop(n * acc, n - 1)

    loop(1, n)
  }

  /**
   * 我们可以把找零的方法分为两类：
   * 使用不包含第一枚硬币（零钱）所有的零钱进行找零，
   * 使用包含第一枚硬币（零钱）的所有零钱进行找零，
   * 两者之和即为所有的找零方式
   * @param money
   * @param coins
   * @return
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (coins.size == 0 || money < 0)
      0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }

  def sum(list: List[Int]): Int = {
    if (list.isEmpty) 0 else list.head + sum(list.tail)
  }

  val list = List(3, 4, 2, 56, 23, 299, -3);
  println(quickSort(list))
  println(factorial(4))
  println(sum(list))
}
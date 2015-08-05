package psyco.scala.basic

/**
 * Created by lipeng on 15/8/5.
 */
object AppleUtils {

  implicit class get(s: String) {
    def getApple = new Apple(s)
  }

}

case class Apple(name: String)


object Implicit extends App {

  import AppleUtils._

  println("hello".getApple)

}

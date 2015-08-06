package psyco.scala.specs

/**
 * Created by lipeng on 15/8/6.
 */
import org.specs._

object ArithmeticSpec extends Specification {
  "Arithmetic" should {
    "add" in {
      "two numbers" in {
        1 + 1 mustEqual 2
      }
      "three numbers" in {
        1 + 1 + 1 mustEqual 3
      }
    }
  }
}
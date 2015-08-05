/**
 * Created by lipeng on 15/8/5.
 */

package psyco.test {
package implicits {


object ImplicitMethod extends App {

  class A(name: String) {
    override def toString: String = s"A-----($name)"
  }

  class RichA(a: A) {
    def rich = print(a)
  }

  implicit def int2string(a: A) = new RichA(a)

  val a = new A("Atest")
  a.rich
}

object ImplicitParameter extends App {
  /**
   * implicit parameter按类型只能指定一个
   * 在没有传参时自动补齐，类似default parameter value
   * 同类型定义两个implicit parameter==> ambiguous implicit values
   */
  implicit val namexxxx: String = "implicit name"
  //  implicit val name2: String = "implicit name2"

  def echo(implicit name: String) = println(s"echo--->$name")

  echo("fuck")
  echo
}

object ImplicitClass extends App {

  implicit class get(s: String) {
    def getApple = new Apple(s)
  }

  case class Apple(name: String)

  println(this.getClass.getPackage.getName)
  println("hello".getApple)

}

}


}

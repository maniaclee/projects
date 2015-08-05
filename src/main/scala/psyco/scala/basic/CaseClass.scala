package psyco.scala.basic

/**
 * Created by lipeng on 15/8/5.
 */
abstract class CaseClassBase

case class A(name: String) extends CaseClassBase

case class B(name: String, a: A) extends CaseClassBase

case class C(name: String, b: B) extends CaseClassBase


object TestCase {
  def run(caseClassBase: CaseClassBase): Unit = {
    caseClassBase match {
      case A(name) => println(name)
      case B(name, a) => println(name, a)
      case C(name, b) => println(name, b)
      case _ => println("nothing")
    }
  }

}

object run___ extends App {
  val a = A("Afucker")
  val b = B("Bfucker", a)
  val c = C("fucker", b)
  TestCase.run(a)
  TestCase.run(b)
  TestCase.run(c)
  println("sdf",3,List(2,3,4))

}
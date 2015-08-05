package psyco.scala.akka

import akka.Main
import akka.actor.{Actor, Props}

/**
 * Created by lipeng on 15/7/24.
 */


class DataStream
{
  var data: Int = 0

  val isDone: Boolean = false
}

case class DataTrue() extends DataStream {
  override val isDone: Boolean = true
}

case class DataFalse() extends DataStream {
}

class Calucator extends Actor {
  var result: Int = 0

  override def receive: Receive = {
    case data: DataTrue => {
      println("result:\t" + result)
      sender().tell("Done", self)
    }
    case data: DataFalse => {
      println("recieve:====" + data.data)
      result += data.data
    }
  }
}

class Starter extends Actor {

  override def preStart(): Unit = {
    val cal = context.actorOf(Props[Calucator], "calculator")
    (1 to 10).foreach(e => {
      val data = new DataFalse
      data.data = e
      cal.tell(data, self)
    })
    cal.tell(new DataTrue, self)
  }


  def receive = {
    case "Done" => {
      println("---------------------------------------done")
      context.stop(self)
    }
  }
}


object shit extends App {
  Main.main(Array(classOf[Starter].getName))
}
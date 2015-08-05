package psyco.scala.akka.fsm

import akka.Main
import akka.actor.{ActorRef, FSM}

/**
 * Created by lipeng on 15/7/24.
 */

final case class SetTarget(ref: ActorRef)

final case class Queue(obj: Any)

case object Flush

// sent events
final case class Batch(obj: Seq[Any])

sealed trait State

case object Idle extends State

case object Active extends State

sealed trait Data

case object Uninitialized extends Data

final case class Todo(target: ActorRef, queue: Seq[Any]) extends Data

class Buncher extends FSM[State, Data] {

  startWith(Idle, Uninitialized)

  when(Idle) {
    case Event(SetTarget(ref), Uninitialized) =>
      stay using Todo(ref, Vector.empty)
  }

  // transition elided ...

  when(Active) {
    case Event(Flush | StateTimeout, t: Todo) =>
      goto(Idle) using t.copy(queue = Vector.empty)
  }

  // unhandled elided ...
  whenUnhandled {
    // common code for both states
    case Event(Queue(obj), t@Todo(_, v)) =>
      goto(Active) using t.copy(queue = v :+ obj)

    case Event(e, s) =>
      log.warning("received unhandled request {} in state {}/{}", e, stateName, s)
      stay
  }
  onTransition {
    case Active -> Idle =>
      stateData match {
        case Todo(ref, queue) => ref ! Batch(queue)
        case _ => // nothing to do
      }
  }
  initialize()
}

object Runner extends App {
  Main.main(Array(classOf[Buncher].getName))
}
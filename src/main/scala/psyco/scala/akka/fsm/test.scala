package psyco.scala.akka.fsm

/**
 * Created by lipeng on 15/7/24.
 */

import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestActorRef, TestFSMRef}
import akka.testkit.{TestActors, TestKit, ImplicitSender}

object FSMDocSpec extends App {

  //
  //  val fsm = TestFSMRef(new Buncher)
  //
  //  val mustBeTypedProperly: TestActorRef[Buncher] = fsm
  //
  //  assert(fsm.stateName == 1)
  //  assert(fsm.stateData == "")
//
//  val system = ActorSystem()
//  val buncher = system.actorOf(Props(classOf[Buncher], this))
//  buncher ! SetTarget(buncher)
//  buncher ! Queue(42)
//  buncher ! Queue(43)
//  expectMsg(Batch(Seq(42, 43)))
//  buncher ! Queue(44)
//  buncher ! Flush
//  buncher ! Queue(45)
//  expectMsg(Batch(Seq(44)))
//  expectMsg(Batch(Seq(45)))
}
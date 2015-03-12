package models

import play.api.libs.json.JsObject

sealed trait RequestMessage

case class MalformedRequest(reason: String, content: String) extends RequestMessage
case class Ping(timestamp: Long) extends RequestMessage
case object GetVersion extends RequestMessage
case class DebugInfo(data: JsObject) extends RequestMessage

case class StartGame(variant: String) extends RequestMessage
case class JoinGame(id: String) extends RequestMessage
case class ObserveGame(id: String, as: Option[String]) extends RequestMessage

trait GameMessage extends RequestMessage

case class SelectCard(card: String, pile: String, pileIndex: Int) extends GameMessage
case class SelectPile(pile: String) extends GameMessage
case class MoveCards(cards: Seq[String], src: String, tgt: String) extends GameMessage
package models

sealed trait RequestMessage

case class MalformedRequest(reason: String, content: String) extends RequestMessage
case class Ping(timestamp: Long) extends RequestMessage
case object GetVersion extends RequestMessage
case class JoinGame(game: String, name: String) extends RequestMessage

case class SelectCard(card: String, pile: String, pileIndex: Int) extends RequestMessage

case class GameRequest(username: String, request: RequestMessage)



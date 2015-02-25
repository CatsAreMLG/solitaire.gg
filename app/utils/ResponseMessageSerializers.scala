package utils

import models._
import utils.GameSerializers._
import play.api.libs.json._
import play.api.libs.functional.syntax._

object ResponseMessageSerializers {
  implicit val serverErrorWrites = Json.writes[ServerError]
  implicit val pongWrites = Json.writes[Pong]
  implicit val versionResponseWrites = Json.writes[VersionResponse]

  implicit val gameJoinedWrites = Json.writes[GameJoined]
  implicit val cardMovedWrites = Json.writes[CardMoved]

  implicit val responseMessageWrites = Writes[ResponseMessage] { r: ResponseMessage =>
    val json = r match {
      case se: ServerError => serverErrorWrites.writes(se)
      case p: Pong => pongWrites.writes(p)
      case vr: VersionResponse => versionResponseWrites.writes(vr)
      case gj: GameJoined => gameJoinedWrites.writes(gj)
      case cm: CardMoved => cardMovedWrites.writes(cm)
      case _ => throw new IllegalArgumentException("Unhandled ResponseMessage type [" + r.getClass.getSimpleName + "].")
    }
    JsObject(Seq("c" -> JsString(r.getClass.getSimpleName), "v" -> json))
  }
}

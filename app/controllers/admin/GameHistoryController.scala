package controllers.admin

import controllers.BaseController
import controllers.BaseController.AuthenticatedAction
import services.GameHistoryService

object GameHistoryController extends BaseController {
  def gameList(q: String, sortBy: String) = AuthenticatedAction { implicit request =>
    requireAdmin {
      val games = GameHistoryService.searchGames(q, sortBy)
      Ok(views.html.admin.gameList(q, sortBy, games))
    }
  }
}
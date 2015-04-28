// Generated 2015-04-26 for Scalataire.
package models.game.generated

import models.game._
import models.game.rules._

object LuckierThirteen extends GameRules(
  id = "luckierthirteen",
  title = "Luckier Thirteen",
  description = "An easier version of ^luckythirteen^, or a cell-free version of ^freecell^. Also known as \"Thirteen by Zero\".",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 13,
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)

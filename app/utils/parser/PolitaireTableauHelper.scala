package utils.parser

import models.game.rules._

trait PolitaireTableauHelper { this: PolitaireGameRulesParser =>
  protected[this] def getTableaus(deckOptions: DeckOptions) = {
    val tableauCount = getInt("Fn")
    val tableaus = (0 to tableauCount - 1).map { i =>
      val prefix = "T" + i
      TableauSet(
        name = getString(prefix + "Nm"),
        numPiles = getInt(prefix + "n") match {
          case -1 => 4 * deckOptions.numDecks
          case x => x
        },
        initialCards = getInt(prefix + "d") match {
          case -1 => InitialCards.PileIndex
          case -3 => InitialCards.RestOfDeck
          case -2 => InitialCards.Custom
          case x => InitialCards.Count(x)
        },
        cardsFaceDown = getInt(prefix + "df") match {
          case 100 => TableauFaceDownCards.AllButOne
          case 101 => TableauFaceDownCards.EvenNumbered
          case 102 => TableauFaceDownCards.OddNumbered
          case x => TableauFaceDownCards.Count(x)
        },
        suitMatchRuleForBuilding = getSuitMatchRule(getInt(prefix + "s")),
        rankMatchRuleForBuilding = getRankMatchRule(getInt(prefix + "r")),
        wrapFromKingToAce = getBoolean(prefix + "w"),
        suitMatchRuleForMovingStacks = getSuitMatchRule(getInt(prefix + "ts")),
        rankMatchRuleForMovingStacks = getRankMatchRule(getInt(prefix + "tr")),

        autoFillEmptyFrom = getInt(prefix + "af") match {
          case 0 => TableauAutoFillEmptyFrom.Nowhere
          case 1 => TableauAutoFillEmptyFrom.Reserve
          case 4 => TableauAutoFillEmptyFrom.Stock
          case 2 => TableauAutoFillEmptyFrom.Waste
          case 6 => TableauAutoFillEmptyFrom.WasteThenStock
          case 10 => TableauAutoFillEmptyFrom.StockThenWaste
          case -1 => TableauAutoFillEmptyFrom.NextPile
        },
        emptyFilledWith = getInt(prefix + "f") match {
          case 0 => TableauFillEmptyWith.Aces
          case 1 => TableauFillEmptyWith.Kings
          case 2 => TableauFillEmptyWith.KingsUntilStockEmpty
          case 4 => TableauFillEmptyWith.None
          case 5 => TableauFillEmptyWith.None
          case 7 => TableauFillEmptyWith.Aces
          case 9 => TableauFillEmptyWith.KingsOrAces
          case 8 => TableauFillEmptyWith.Sevens
        },

        mayMoveToNonEmptyFrom = Nil,
        mayMoveToEmptyFrom = Nil,

        maxCards = 1,
        actionDuringDeal = PileAction.None,
        actionAfterDeal = PileAction.None,
        pileWithLowCardsAtBottom = 1
      )
    }.toSeq
    tableaus
  }
}

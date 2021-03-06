package models.rules.impl

import models.rules._

object Spider extends GameRules(
  id = "spider",
  completed = true,
  title = "Spider",
  related = Seq(
    "fredsspider", "chinesespider", "astrocyte", "mondospider", "tarantula", "trillium", "spideronesuit", "spidertwosuits",
    "spiderette", "blackwidow", "hugespider", "beetle", "bigspider"
  ),
  links = Seq(
    Link("Wikipedia", "en.wikipedia.org/wiki/Spider_(solitaire)"),
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/spider.htm"),
    Link("Xolitaire", "www.escapedivision.com/xolitaire/en/games/spider.html"),
    Link("Solitaire Game Rules.com", "solitaire-game-rules.com/games/spider.htm"),
    Link("AisleRiot", "help.gnome.org/users/aisleriot/stable/Spider.html.en"),
    Link("Solitaire City", "www.solitairecity.com/Help/Spider.shtml"),
    Link("wikiHow", "www.wikihow.com/Play-Spider-Solitaire"),
    Link("Microsoft", "windows.microsoft.com/en-us/windows/spider-solitaire-how-to"),
    Link("Hagai Eisenberg", "ezinearticles.com/?Spider-Solitaire---History-and-Rules&id=6806794"),
    Link("Dan Fletcher's Strategy Guide", "www.solitairecentral.com/articles/SpiderSolitaireAStrategyGuideForBeginners.html"),
    Link("Boris Sandberg's Strategy Guide", "www.solitairecentral.com/articles/SpiderSolitaireAWinningStrategy.html"),
    Link("Steve Weiss", "home.comcast.net/~srweiss/spider/"),
    Link("Alex Robinson's Spider Solver", "www.tranzoa.net/~alex/plspider.htm")
  ),
  layout = "s:f|t",
  victoryCondition = VictoryCondition.AllOnTableauSorted,
  deckOptions = DeckOptions(numDecks = 2),
  stock = Some(
    StockRules(
      dealTo = StockDealTo.TableauIfNoneEmpty,
      maximumDeals = Some(1)
    )
  ),
  foundations = IndexedSeq(
    FoundationRules(
      numPiles = 8,
      moveCompleteSequencesOnly = true
    )
  ),
  tableaus = IndexedSeq(
    TableauRules(
      numPiles = 10,
      initialCards = InitialCards.Custom,
      customInitialCards = Seq(
        "DDDDDU",
        "DDDDDU",
        "DDDDDU",
        "DDDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU",
        "DDDDU"
      ),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit
    )
  )
)

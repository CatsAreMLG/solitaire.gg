define(['utils/Config', 'game/Options', 'game/state/InitialState', 'game/CardSet'], function (config, options, InitialState, CardSet) {
  "use strict";

  function Game(ws) {
    this.id = null;
    this.ws = ws;
    this.cardSet = CardSet[config.cardSet][config.cardSize];
    var initialState = new InitialState(this);
    Phaser.Game.call(this, '100%', '100%', Phaser.AUTO, 'game-container', initialState);

    this.piles = {};
    this.cards = {};

    console.log("Game started.");

    options.start();
  }

  Game.prototype = Phaser.Game.prototype;
  Game.prototype.constructor = Game;

  Game.prototype.onMessage = function(c, v) {
    if(c != "Pong") {
      //console.log("Message [" + c + "] received with content [" + JSON.stringify(v) + "].");
    }
    switch(c) {
      case "Pong":
        //this.statusPanel.setLatency(new Date().getTime() - v.timestamp);
        break;
      case "VersionResponse":
        //this.statusPanel.setVersion(v.version);
        break;
      default:
        this.state.getCurrentState().onMessage(c, v);
    }
  };

  Game.prototype.cardSelected = function(card) {
    this.ws.send("SelectCard", { card: card.id, pile: card.pile.id, pileIndex: card.pileIndex });
  };

  Game.prototype.pileSelected = function(pile) {
    this.ws.send("SelectPile", { pile: pile.id } );
  };

  Game.prototype.addPile = function(p) {
    this.piles[p.id] = p;
  };

  Game.prototype.addCard = function(c) {
    this.cards[c.id] = c;
  };

  return Game;
});
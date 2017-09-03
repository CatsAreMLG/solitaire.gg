package phaser.state

import com.definitelyscala.phaser.{PluginObj, ScaleManager, State}
import util.JsUtils

import scala.scalajs.js

class InitialState extends State {
  override def create() = {
    game.stage.disableVisibilityChange = true
    game.time.advancedTiming = true
    game.scale.scaleMode = ScaleManager.NO_SCALE

    if (js.Dynamic.global.Phaser.Plugin.Debug.toString != "undefined") {
      game.add.plugin(JsUtils.as[PluginObj](js.Dynamic.global.Phaser.Plugin.Debug))
    }

    game.state.start("loading", clearWorld = false, clearCache = false)
  }
}

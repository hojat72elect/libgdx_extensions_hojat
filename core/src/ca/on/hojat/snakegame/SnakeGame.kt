package ca.on.hojat.snakegame

import ca.on.hojat.snakegame.screens.GameScreen
import com.badlogic.gdx.Game

class SnakeGame: Game() {
    override fun create() {
       screen = GameScreen()
    }
}
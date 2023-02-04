package ca.on.hojat.snakegame.snakegame

import ca.on.hojat.snakegame.snakegame.screens.SnakeGameScreen
import com.badlogic.gdx.Game

class SnakeGame: Game() {
    override fun create() {
       screen = SnakeGameScreen()
    }
}
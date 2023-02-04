package ca.on.hojat.snakegame.snakegame

import ca.on.hojat.snakegame.snakegame.screens.SnakeGameScreen
import com.badlogic.gdx.Game

/**
 * This is the game that "James Cook" develops in the chapters 2 and 3
 * of his book. I wasn't able to fully implement the snake; so , I let it go (for now).
 */
class SnakeGame: Game() {
    override fun create() {
       screen = SnakeGameScreen()
    }
}
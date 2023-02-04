package ca.on.hojat.snakegame.flappybird

import ca.on.hojat.snakegame.flappybird.screens.FlappyBirdScreen
import com.badlogic.gdx.Game

class FlappeeBeeGame: Game() {
    override fun create() {
        screen  = FlappyBirdScreen()
    }
}

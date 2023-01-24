package ca.on.hojat.snakegame.gameobjects

import com.badlogic.gdx.graphics.Texture

data class BodyPart(
    var texture: Texture,
    var x: Int = 0,
    var y: Int = 0
) {
    fun updatePosition(newX: Int, newY: Int) {
        x = newX
        y = newY
    }
}

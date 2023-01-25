package ca.on.hojat.snakegame.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.graphics.Texture

class BodyPart(bodyPartTexture: Texture) : BaseGameObject(bodyPartTexture) {
    fun updatePosition(newX: Int, newY: Int) {
        xPosition = newX
        yPosition = newY
    }
}
package ca.on.hojat.snakegame.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

open class BaseGameObject(
    var xPosition: Float = 0f,
    var yPosition: Float = 0f,
    var movementDirection: MovementDirection? = null,
    vararg val textureAddress: String
) {

    /**
     * The list of Textures used for drawing this game object.
     * this list is being exposed because the child might need to use it.
     */
    val textureGraphic = mutableListOf<Texture>()

    /**
     * The textures used for drawing this object will be loaded to the memory.
     */
    open fun loadTexture() {
        textureAddress.forEach {
            textureGraphic.add(
                Texture(Gdx.files.internal(it))
            )
        }
    }
}
package ca.on.hojat.snakegame.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

open class BaseGameObject(
    vararg val textureAddress: String
) {
    var xPosition = 0
    var yPosition = 0
    val textureGraphic = mutableListOf<Texture>()

    /**
     *  For the times you wanna create a GameObject with a Texture you already have
     *  (and not with the address of that texture).
     */
    constructor(inputTexture: Texture) : this() {
        textureGraphic.add(inputTexture)
    }

    open fun loadTexture() {
        textureAddress.forEach {
            textureGraphic.add(
                Texture(Gdx.files.internal(it))
            )
        }
    }

}
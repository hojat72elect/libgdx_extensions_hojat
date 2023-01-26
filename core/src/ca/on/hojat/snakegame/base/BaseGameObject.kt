package ca.on.hojat.snakegame.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

open class BaseGameObject(
    var textureAddress: String
) {
    var xPosition = 0
    var yPosition = 0
    lateinit var textureGraphic: Texture

    fun loadTexture() {
        textureGraphic = Texture(Gdx.files.internal(textureAddress))
    }

}
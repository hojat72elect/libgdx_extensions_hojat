package ca.on.hojat.snakegame.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.Disposable

open class BaseGameObject(
    var movementDirection: MovementDirection? = null,
    val rectangle: Rectangle,
    vararg val textureAddress: String
) : Disposable {

    val x = rectangle.x
    val y = rectangle.y
    val width = rectangle.width
    val height = rectangle.height

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

    override fun dispose() {
        textureGraphic.forEach { texture -> texture.dispose() }
    }
}
package ca.on.hojat.snakegame.base

import com.badlogic.gdx.graphics.Texture

/**
 * Any game object that will reside in our 2d game world.
 *
 * de basic things each game object will have is a texture and 2D coordinates.
 */
open class BaseGameObject(
    var texture: Texture,
    var xPosition: Int = 0,
    var yPosition: Int = 0
)
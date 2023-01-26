package ca.on.hojat.snakegame.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.graphics.Texture

class Apple(
    texture: Texture,
    var isAvailable: Boolean = false
) : BaseGameObject(texture=texture)
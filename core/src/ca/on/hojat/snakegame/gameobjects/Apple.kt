package ca.on.hojat.snakegame.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.graphics.Texture

class Apple(
    appleTexture: Texture,
    var isAvailable: Boolean = false
) : BaseGameObject(appleTexture)
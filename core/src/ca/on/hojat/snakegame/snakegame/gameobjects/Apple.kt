package ca.on.hojat.snakegame.snakegame.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.math.Rectangle

class Apple(
    var isAvailable: Boolean = false
) : BaseGameObject(rectangle = Rectangle(), textureAddress = *arrayOf("apple.png"))
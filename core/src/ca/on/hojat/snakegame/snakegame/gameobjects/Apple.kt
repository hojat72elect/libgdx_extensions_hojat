package ca.on.hojat.snakegame.snakegame.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject

class Apple(
    var isAvailable: Boolean = false
) : BaseGameObject(textureAddress = *arrayOf("apple.png"))
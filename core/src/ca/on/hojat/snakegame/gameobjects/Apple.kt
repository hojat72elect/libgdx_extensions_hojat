package ca.on.hojat.snakegame.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject

class Apple(
    texture: String,
    var isAvailable: Boolean = false
) : BaseGameObject(textureAddress = *arrayOf(texture))
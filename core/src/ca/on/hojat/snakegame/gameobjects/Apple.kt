package ca.on.hojat.snakegame.gameobjects

import com.badlogic.gdx.graphics.Texture


class Apple(
    var texture: Texture,
    var isAvailable: Boolean = false,
    var x: Int = 0,
    var y: Int = 0
) {
}
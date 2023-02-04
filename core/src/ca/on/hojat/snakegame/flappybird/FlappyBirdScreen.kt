package ca.on.hojat.snakegame.flappybird

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.Viewport

class FlappyBirdScreen : ScreenAdapter() {

    // These 4 will do all the heavy-lifting parts of the game
    private lateinit var shapeRenderer: ShapeRenderer
    private lateinit var viewPort: Viewport
    private lateinit var camera: Camera
    private lateinit var batch: SpriteBatch


    companion object {
        const val WORLD_WIDTH = 480f
        const val WORLD_HEIGHT = 640f
    }
}
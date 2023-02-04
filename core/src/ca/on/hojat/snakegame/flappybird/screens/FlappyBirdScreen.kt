package ca.on.hojat.snakegame.flappybird.screens

import ca.on.hojat.snakegame.flappybird.gameobjects.Bird
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class FlappyBirdScreen : ScreenAdapter() {

    // These 4 will do all the heavy-lifting parts of the game
    private lateinit var shapeRenderer: ShapeRenderer
    private lateinit var viewPort: Viewport
    private lateinit var camera: Camera
    private lateinit var batch: SpriteBatch

    // game objects to be drawn
    private val flappy = Bird()


    override fun resize(width: Int, height: Int) {
//        super.resize(width, height)
        show()
        viewPort.update(width, height)

    }

    /**
     * all the warmup code happens here.
     */
    override fun show() {
        camera = OrthographicCamera()
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0f)
        camera.update()
        viewPort = FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)
        shapeRenderer = ShapeRenderer()
        batch = SpriteBatch()
        flappy.move(WORLD_WIDTH / 4, WORLD_HEIGHT / 2)
    }

    override fun render(delta: Float) {
        clearScreen()
        batch.projectionMatrix = camera.projection
        batch.transformMatrix = camera.view
        batch.begin()
        batch.end()

        shapeRenderer.projectionMatrix = camera.projection
        shapeRenderer.transformMatrix = camera.view
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
        flappy.drawDebug(shapeRenderer)
        shapeRenderer.end()
    }

    private fun clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    companion object {
        const val WORLD_WIDTH = 480f
        const val WORLD_HEIGHT = 640f
    }
}
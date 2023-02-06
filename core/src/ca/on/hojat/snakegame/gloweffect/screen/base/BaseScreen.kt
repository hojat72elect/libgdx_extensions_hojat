package ca.on.hojat.snakegame.gloweffect.screen.base

import ca.on.hojat.snakegame.gloweffect.config.Config
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.FitViewport


abstract class BaseScreen : Screen {

    private val camera = OrthographicCamera()

    protected val viewPort = FitViewport(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat(), camera)

    init {
        camera.setToOrtho(false, Config.WIDTH.toFloat(), Config.HEIGHT.toFloat())
        camera.position.set(viewPort.worldWidth / 2f, viewPort.worldHeight / 2f, 0f)
    }

    override fun render(delta: Float) {
        camera.update()
    }
}
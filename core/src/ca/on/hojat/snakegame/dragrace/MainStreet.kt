package ca.on.hojat.snakegame.dragrace

import ca.on.hojat.snakegame.dragrace.handlers.GameServicesHandler
import ca.on.hojat.snakegame.dragrace.handlers.RequestHandler
import ca.on.hojat.snakegame.dragrace.screens.MainMenuScreen
import ca.on.hojat.snakegame.dragrace.screens.Screens
import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.StretchViewport

class MainStreet(
    @JvmField
    val reqHandler: RequestHandler,
    @JvmField
    val gameServiceHandler: GameServicesHandler
) : Game() {

    lateinit var stage: Stage
    lateinit var batch: SpriteBatch

    override fun create() {
        stage = Stage(
            StretchViewport(
                Screens.SCREEN_WIDTH.toFloat(),
                Screens.SCREEN_HEIGHT.toFloat()
            )
        )
        batch = SpriteBatch()
        Assets.load()

        if(Settings.didBuyNoAds)
            reqHandler.removeAds()

        screen = MainMenuScreen(this)

    }
}
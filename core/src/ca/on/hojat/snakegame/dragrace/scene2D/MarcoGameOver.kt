package ca.on.hojat.snakegame.dragrace.scene2D

import ca.on.hojat.snakegame.dragrace.Assets
import ca.on.hojat.snakegame.dragrace.Settings
import ca.on.hojat.snakegame.dragrace.screens.Screens
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align

class MarcoGameOver(
    val screen: Screens,  distance: Int,  coins: Int
) : Group() {

    init {
        setSize(420f, 350f)
        setPosition(Screens.SCREEN_WIDTH / 2f - width / 2f, 900f)
        addAction(Actions.moveTo(x, 390f, 1f, Interpolation.bounceOut))

        val background = Image(Assets.fondoPuntuaciones)
        background.setSize(width, height)
        addActor(background)

        val labelScore = Label("Distance\n${distance}m", Assets.labelStyleGrande)
        labelScore.setAlignment(Align.center)
        labelScore.setFontScale(1.3f)
        labelScore.setPosition(width / 2f - labelScore.height / 2f, 210f)
        addActor(labelScore)

        val bestScoreTable = Table()
        bestScoreTable.setSize(width, 110f)
        bestScoreTable.y = 80f
        bestScoreTable.padLeft(15f).padRight(15f)

        val labelBestScore = Label("Best Distance", Assets.labelStyleGrande)
        labelBestScore.setAlignment(Align.left)
        labelBestScore.setFontScale(.75f)

        val labelNumBestScore = Label("${Settings.bestScore}m", Assets.labelStyleGrande)
        labelNumBestScore.setAlignment(Align.right)
        labelNumBestScore.setFontScale(.75f)

        val labelCoins = Label("Coins", Assets.labelStyleGrande)
        labelCoins.setAlignment(Align.left)
        labelCoins.setFontScale(.75f)

        val labelNumBestCoins = Label(coins.toString(), Assets.labelStyleGrande)
        labelNumBestCoins.setAlignment(Align.right)
        labelNumBestCoins.setFontScale(.75f)

        bestScoreTable.add(labelBestScore).left()
        bestScoreTable.add(labelNumBestScore).right().expand()

        bestScoreTable.row()
        bestScoreTable.add(labelCoins).left()
        bestScoreTable.add(labelNumBestCoins).right().expand()

        val btShareTwitter = Button(TextureRegionDrawable(Assets.btTwitter))
        btShareTwitter.setSize(50f, 50f)
        btShareTwitter.setPosition(155f, 20f)
        screen.addEfectoPress(btShareTwitter)
        btShareTwitter.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                screen.game.reqHandler.shareOnTwitter(
                        "My best distance playing Drag Racing V6 is ${Settings.bestScore}m, can you beat me?"
                    )
            }
        })

        val btShareFacebook = Button(TextureRegionDrawable(Assets.btFacebook))
        btShareFacebook.setSize(50f, 50f)
        btShareFacebook.setPosition(225f, 20f)
        screen.addEfectoPress(btShareFacebook)
        btShareFacebook.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                screen.game.reqHandler.shareOnFacebook(
                        "My best distance playing Drag Racing V6 is " + Settings.bestScore + "m, can you beat me?"
                    )
            }
        })

        addActor(bestScoreTable)
        addActor(btShareTwitter)
        addActor(btShareFacebook)
    }
}
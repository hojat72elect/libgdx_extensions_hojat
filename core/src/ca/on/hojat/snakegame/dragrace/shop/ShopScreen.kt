package ca.on.hojat.snakegame.dragrace.shop

import ca.on.hojat.snakegame.dragrace.Assets
import ca.on.hojat.snakegame.dragrace.MainStreet
import ca.on.hojat.snakegame.dragrace.Settings
import ca.on.hojat.snakegame.dragrace.screens.MainMenuScreen
import ca.on.hojat.snakegame.dragrace.screens.Screens
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable

class ShopScreen(game: MainStreet?) : Screens(game) {
    var btPersonajes: Button? = null
    var btPowerUps: Button? = null
    var btMonedas: Button? = null
    var btNoAds: Button? = null
    var btAtras: Button? = null
    var lbCoin: Label
    var scroll: ScrollPane
    var contenedor: Table

    init {
        val lbShop = Label("Shop", Assets.labelStyleGrande)
        lbShop.setSize(135f, 50f)
        lbShop.setPosition(3f, 747f)
        val imgCoin = Image(Assets.coinFrente)
        lbCoin = Label("0", Assets.labelStyleGrande)
        lbCoin.setFontScale(.8f)
        val tbScores = Table()
        tbScores.width = SCREEN_WIDTH.toFloat()
        tbScores.setPosition(0f, SCREEN_HEIGHT - lbCoin.height / 2)
        tbScores.padLeft(5f).padRight(5f)
        tbScores.add(lbCoin).right().expand().padRight(5f)
        tbScores.add(imgCoin).right()
        val separadorH = Image(Assets.separadorHorizontal)
        separadorH.setSize(SCREEN_WIDTH.toFloat(), 5f)
        separadorH.color = Color.LIGHT_GRAY
        separadorH.setPosition(0f, 740f)
        val separadorV = Image(Assets.separadorVertical)
        separadorV.setSize(5f, 745f)
        separadorV.color = Color.LIGHT_GRAY
        separadorV.setPosition(90f, 0f)
        initButtons()
        contenedor = Table()
        scroll = ScrollPane(contenedor, Assets.styleScrollPane)
        scroll.setSize((SCREEN_WIDTH - 95).toFloat(), (SCREEN_HEIGHT - 62).toFloat())
        scroll.setPosition(95f, 0f)
        stage.addActor(tbScores)
        stage.addActor(lbShop)
        stage.addActor(separadorV)
        stage.addActor(separadorH)
        stage.addActor(btPersonajes)
        stage.addActor(btMonedas)
        stage.addActor(btNoAds)
        stage.addActor(btAtras)
        stage.addActor(scroll)
        PersonajesSubMenu(game, contenedor)
    }

    private fun initButtons() {
        btPersonajes = Button(
            TextureRegionDrawable(Assets.carroTornado)
        )
        btPersonajes!!.setSize(45f, 65f)
        btPersonajes!!.setPosition(23f, 660f)
        addEfectoPress(btPersonajes)
        btPersonajes!!.addListener(object : ClickListener() {
            override fun clicked(
                event: InputEvent, x: Float,
                y: Float
            ) {
                PersonajesSubMenu(game, contenedor)
            }
        })
        btPowerUps = Button(TextureRegionDrawable(Assets.carroTornado))
        btPowerUps!!.setSize(55f, 55f)
        btPowerUps!!.setPosition(17f, 570f)
        addEfectoPress(btPowerUps)
        btPowerUps!!.addListener(object : ClickListener() {
            override fun clicked(
                event: InputEvent, x: Float,
                y: Float
            ) {
            }
        })
        btMonedas = Button(TextureRegionDrawable(Assets.coinFrente))
        btMonedas!!.setSize(55f, 55f)
        btMonedas!!.setPosition(17f, 480f)
        addEfectoPress(btMonedas)
        btMonedas!!.addListener(object : ClickListener() {
            override fun clicked(
                event: InputEvent, x: Float,
                y: Float
            ) {
                GetCoinsSubMenu(game, contenedor)
            }
        })
        btNoAds = Button(TextureRegionDrawable(Assets.btNoAds))
        btNoAds!!.setSize(55f, 55f)
        btNoAds!!.setPosition(17f, 390f)
        addEfectoPress(btNoAds)
        btNoAds!!.addListener(object : ClickListener() {
            override fun clicked(
                event: InputEvent, x: Float,
                y: Float
            ) {
                NoAdsSubMenu(game, contenedor)
            }
        })
        btAtras = Button(TextureRegionDrawable(Assets.btAtras))
        btAtras!!.setSize(55f, 55f)
        btAtras!!.setPosition(17f, 10f)
        addEfectoPress(btAtras)
        btAtras!!.addListener(object : ClickListener() {
            override fun clicked(
                event: InputEvent, x: Float,
                y: Float
            ) {
                changeScreenWithFadeOut(MainMenuScreen::class.java, game)
            }
        })
    }

    override fun draw(delta: Float) {}
    override fun update(delta: Float) {
        lbCoin.setText(Settings.coinsTotal.toString() + "")
    }

    override fun keyDown(tecleada: Int): Boolean {
        if (tecleada == Input.Keys.BACK || tecleada == Input.Keys.ESCAPE) {
            changeScreenWithFadeOut(MainMenuScreen::class.java, game)
            return true
        }
        return false
    }
}
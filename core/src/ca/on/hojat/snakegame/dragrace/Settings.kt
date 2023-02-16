package ca.on.hojat.snakegame.dragrace

import ca.on.hojat.snakegame.dragrace.shop.PersonajesSubMenu
import com.badlogic.gdx.Gdx

object Settings {


    const val TIMES_TO_SHOW_AD = 5

    @JvmField
    var drawDebugLines = false

    @JvmField
    var numeroVecesJugadas = 0

    @JvmField
    var bestScore = 0


    @JvmField
    var coinsTotal = 0

    @JvmField
    var didBuyNoAds = false

    @JvmField
    var didLikeFacebook = false

    @JvmField
    var isMusicOn = true

    @JvmField
    var skinSeleccionada = PersonajesSubMenu.SKIN_CARRO_DIABLO

    private val prefs = Gdx.app.getPreferences("com.tiar.dragrace.shop")

    /**
     * Loads all the settings from their preferences file into the kotlin objects.
     */
    @JvmStatic
    fun load() {
        numeroVecesJugadas = prefs.getInteger("numeroVecesJugadas")
        bestScore = prefs.getInteger("bestScore")
        coinsTotal = prefs.getInteger("coinsTotal")
        skinSeleccionada = prefs.getInteger("skinSeleccionada")
        didBuyNoAds = prefs.getBoolean("didBuyNoAds")
        didLikeFacebook = prefs.getBoolean("didLikeFacebook")
        isMusicOn = prefs.getBoolean("isMusicOn", true)
    }

    @JvmStatic
    fun save() {
        prefs.putInteger("numeroVecesJugadas", numeroVecesJugadas)
        prefs.putInteger("bestScore", bestScore)
        prefs.putInteger("coinsTotal", coinsTotal)
        prefs.putInteger("skinSeleccionada", skinSeleccionada)
        prefs.putBoolean("didBuyNoAds", didBuyNoAds)
        prefs.putBoolean("didLikeFacebook", didLikeFacebook)
        prefs.putBoolean("isMusicOn", isMusicOn)
        prefs.flush()
    }

    /**
     * The best score of user has changed.
     */
    @JvmStatic
    fun setNewScore(score: Int) {
        if (bestScore < score)
            bestScore = score

        save()
    }
}
package ca.on.hojat.snakegame.dragrace.handlers

interface RequestHandler {
    fun showRater()
    fun showInterstitial()
    fun showFacebook()
    fun shareOnFacebook(mensaje: String?)
    fun shareOnTwitter(mensaje: String?)
    fun removeAds()
    fun showAdBanner()
    fun hideAdBanner()
    fun buy50milCoins()
}
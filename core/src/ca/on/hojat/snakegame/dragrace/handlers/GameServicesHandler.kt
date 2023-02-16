package ca.on.hojat.snakegame.dragrace.handlers

interface GameServicesHandler {

    /**
     * Este metodo abstrae a GPGS o a AGC
     */
    fun submitScore(score: Long)

    /**
     * Este metodo abstrae a GPGS o a AGC
     */
    fun getLeaderboard()

    fun isSignedIn(): Boolean

    fun signIn()
}
package ca.on.hojat.snakegame.base

/**
 * You give it the whole time you want for the delay.
 */
class Timer(var delay: Int, var isRunning: Boolean) {

    private var elapsedTime = 0

    fun tick(delta: Float): Boolean {
        if (isRunning) {
            elapsedTime += (delta * 1000).toInt()
            if (elapsedTime > delay) {
                elapsedTime = elapsedTime - delay
                return true
            }
        }
        return false
    }

    fun start() {
        isRunning = true
    }

    fun stop() {
        isRunning = false
    }

    fun reset() {
        elapsedTime = 0
    }

    fun percent(): Float {
        return elapsedTime / delay.toFloat()
    }
}
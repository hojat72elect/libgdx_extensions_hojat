package ca.on.hojat.snakegame.dragrace.objects

import ca.on.hojat.snakegame.dragrace.Assets
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor

class SpeedBar(
    val maxLife: Float,
    val speedBarX: Float,
    val speedBarY: Float,
    val speedBarWidth: Float,
    val speedBarHeight: Float
) : Actor() {

    var actualLife = maxLife

    init {
        setBounds(speedBarX, speedBarY, speedBarWidth, speedBarHeight)
    }

    fun updateActualLife(life: Float) {
        if (life >= maxLife) {
            this.actualLife = maxLife
        } else {
            this.actualLife = life
        }
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {

        batch?.draw(Assets.barraMarcadorRojo, x, y, width, height)
        if (actualLife > 0)
            batch?.draw(Assets.barraMarcadorVerde, x, y, width * (actualLife / maxLife), height)
    }
}
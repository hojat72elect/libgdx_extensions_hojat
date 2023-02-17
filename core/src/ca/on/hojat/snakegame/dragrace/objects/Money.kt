package ca.on.hojat.snakegame.dragrace.objects

import ca.on.hojat.snakegame.dragrace.Assets
import ca.on.hojat.snakegame.dragrace.Settings
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction

class Money(moneyX: Float, moneyY: Float) : Actor() {

    private var moveAction = MoveToAction()
    private var isSuperSpeed = false

    val bounds = Rectangle()
    private val renders = ShapeRenderer()

    init {
        width = 10f
        height = 32f
        setPosition(moneyX - width / 2f, moneyY)

        addAction(Actions.forever(Actions.rotateBy(360f, 1f)))

        moveAction.setPosition(x, -height)
        moveAction.duration = 5f
        addAction(moveAction)

    }

    override fun act(delta: Float) {
        super.act(delta)
        updateBounds()
    }

    private fun updateBounds() {
        bounds.set(x, y, width, height)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {

        batch?.draw(
            Assets.coin, x, y, width / 2f, height / 2f, width, height, 1f, 1f, rotation
        )

        if (Settings.drawDebugLines) {
            batch?.end()
            renders.projectionMatrix = batch?.projectionMatrix
            renders.begin(ShapeRenderer.ShapeType.Line)
            renders.rect(
                bounds.x.toFloat(),
                bounds.y.toFloat(),
                bounds.width.toFloat(),
                bounds.height.toFloat()
            )
            renders.end()
            batch?.begin()
        }
    }

    fun setSpeed() {
        if (isSuperSpeed.not()) {
            isSuperSpeed = true
            moveAction.reset()
            moveAction.duration = 1f
            addAction(moveAction)
        }
    }

}
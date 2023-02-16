package ca.on.hojat.snakegame.dragrace.objects

import ca.on.hojat.snakegame.dragrace.Assets
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction

/**
 * Our infinitely scrolling 2D background is an [Actor]
 */
class InfiniteScrollBg(
    private val backGroundWidth: Float,
    private val backGroundHeight: Float
) : Actor() {

    private val moveAction = MoveToAction()

    init {
        setPosition(0f, backGroundHeight)
        moveAction.setPosition(0f, 0f)
        moveAction.duration = 1.75f
        addAction(
            Actions.forever(
                Actions.sequence(
                    moveAction, Actions.moveTo(0f, backGroundHeight)
                )
            )
        )
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
        batch?.draw(
            Assets.calle,
            x,
            y - backGroundHeight,
            backGroundWidth,
            backGroundHeight * 2
        )
    }

    fun setSpeed() {
        moveAction.duration = .3f
    }

    fun stopSpeed() {
        moveAction.duration = 1.75f
    }
}
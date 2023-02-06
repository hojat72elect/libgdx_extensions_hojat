package ca.on.hojat.snakegame.gloweffect

import ca.on.hojat.snakegame.gloweffect.screen.GlowEffectGameScreen
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input

class GlowRingsGame : Game() {
    override fun create() {
        screen = GlowEffectGameScreen()
    }

    override fun render() {
        super.render()
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) Gdx.app.exit()
    }
}
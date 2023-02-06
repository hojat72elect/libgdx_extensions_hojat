package ca.on.hojat.snakegame.gloweffect;

import ca.on.hojat.snakegame.gloweffect.screen.GlowEffectGameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GlowEffect extends Game {

	@Override
	public void create () {
		setScreen(new GlowEffectGameScreen());
	}

	@Override
	public void render () {
		super.render();

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
}

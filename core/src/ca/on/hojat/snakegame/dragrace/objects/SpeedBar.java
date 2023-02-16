package ca.on.hojat.snakegame.dragrace.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ca.on.hojat.snakegame.dragrace.Assets;

public class SpeedBar extends Actor {

	public float maxlife;
	public float actualLife;

	public SpeedBar(float maxLife, float x, float y, float width, float height) {
		this.setBounds(x, y, width, height);
		this.maxlife = maxLife;
		this.actualLife = maxLife;
	}

	public void updateActualLife(float actualLife) {
		if (actualLife >= maxlife) {
			actualLife = maxlife;
		}
		this.actualLife = actualLife;

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {

		batch.draw(Assets.barraMarcadorRojo, this.getX(), this.getY(),
				this.getWidth(), this.getHeight());
		if (actualLife > 0)
			batch.draw(Assets.barraMarcadorVerde, this.getX(), this.getY(),
					this.getWidth() * (actualLife / maxlife), this.getHeight());
	}
}

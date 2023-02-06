package ca.on.hojat.snakegame.gloweffect.screen.base;

import ca.on.hojat.snakegame.gloweffect.config.Config;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class BaseScreen implements Screen {

    protected OrthographicCamera camera;
    protected Viewport viewport;

    public BaseScreen() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Config.WIDTH, Config.HEIGHT);
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
    }

    @Override
    public void render(float delta) {
        camera.update();
    }
}

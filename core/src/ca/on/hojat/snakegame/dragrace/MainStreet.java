package ca.on.hojat.snakegame.dragrace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import ca.on.hojat.snakegame.dragrace.handlers.GameServicesHandler;
import ca.on.hojat.snakegame.dragrace.handlers.RequestHandler;
import ca.on.hojat.snakegame.dragrace.screens.MainMenuScreen;
import ca.on.hojat.snakegame.dragrace.screens.Screens;

public class MainStreet extends Game {
    public final GameServicesHandler gameServiceHandler;
    public final RequestHandler reqHandler;

    public MainStreet(RequestHandler reqHandler, GameServicesHandler gameServiceHandler) {
        this.reqHandler = reqHandler;
        this.gameServiceHandler = gameServiceHandler;
    }

    public Stage stage;
    public SpriteBatch batch;

    @Override
    public void create() {
        stage = new Stage(new StretchViewport(Screens.SCREEN_WIDTH,
                Screens.SCREEN_HEIGHT));

        batch = new SpriteBatch();
        Assets.load();

        if (Settings.didBuyNoAds)
            reqHandler.removeAds();

        setScreen(new MainMenuScreen(this));
    }

}
package ca.on.hojat.snakegame;

import ca.on.hojat.snakegame.flappybird.FlappeeBeeGame;
import ca.on.hojat.snakegame.raindropgame.RainDropGame;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Rain Drop");
        config.setWindowedMode(800, 480);
        config.useVsync(true);
        config.setForegroundFPS(60);
        new Lwjgl3Application(new RainDropGame(), config);
    }
}

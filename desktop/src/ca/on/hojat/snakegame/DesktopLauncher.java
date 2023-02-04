package ca.on.hojat.snakegame;

import ca.on.hojat.snakegame.flappybird.FlappeeBeeGame;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setWindowSizeLimits(240, 320,1280,720);
        config.setTitle("Snake Game");
        new Lwjgl3Application(new FlappeeBeeGame(), config);
    }
}

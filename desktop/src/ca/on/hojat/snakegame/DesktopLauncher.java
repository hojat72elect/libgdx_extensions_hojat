package ca.on.hojat.snakegame;

import ca.on.hojat.snakegame.dragrace.MainStreet;
import ca.on.hojat.snakegame.dragrace.Settings;
import ca.on.hojat.snakegame.dragrace.handlers.GoogleGameServicesHandler;
import ca.on.hojat.snakegame.dragrace.handlers.RequestHandler;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("StreetSwipinRace");
        cfg.setWindowedMode(480, 800);


        new Lwjgl3Application(new MainStreet(reqHandler,
                gameHandler), cfg);
    }

    static RequestHandler reqHandler = new RequestHandler() {

        @Override
        public void showRater() {
            // TODO Auto-generated method stub

        }

        @Override
        public void showInterstitial() {
            // TODO Auto-generated method stub

        }

        @Override
        public void showFacebook() {
            // TODO Auto-generated method stub

        }

        @Override
        public void showAdBanner() {
            // TODO Auto-generated method stub

        }

        @Override
        public void shareOnTwitter(String mensaje) {
            // TODO Auto-generated method stub

        }

        @Override
        public void shareOnFacebook(String mensaje) {
            // TODO Auto-generated method stub

        }

        @Override
        public void removeAds() {
            // TODO Auto-generated method stub

        }

        @Override
        public void hideAdBanner() {
            // TODO Auto-generated method stub

        }

        @Override
        public void buy50milCoins() {
            Settings.coinsTotal += 50000;
        }

    };

    static GoogleGameServicesHandler gameHandler = new GoogleGameServicesHandler() {

        @Override
        public void submitScore(long score) {
            // TODO Auto-generated method stub

        }

        @Override
        public void signIn() {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean isSignedIn() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void getLeaderboard() {
            // TODO Auto-generated method stub

        }

    };
}

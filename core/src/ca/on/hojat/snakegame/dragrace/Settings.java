package ca.on.hojat.snakegame.dragrace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import ca.on.hojat.snakegame.dragrace.shop.PersonajesSubMenu;

public class Settings {
    final public static int TIMES_TO_SHOW_AD = 5;

    public static boolean drawDebugLines = false;

    public static int numeroVecesJugadas = 0;
    public static int bestScore = 0;
    public static int coinsTotal = 0;
    public static boolean didBuyNoAds;
    public static boolean didLikeFacebook;
    public static boolean isMusicOn = true;

    public static int skinSeleccionada = PersonajesSubMenu.SKIN_CARRO_DIABLO;

    private final static Preferences prefs = Gdx.app
            .getPreferences("com.tiar.dragrace.shop");

    public static void load() {
        numeroVecesJugadas = prefs.getInteger("numeroVecesJugadas");
        bestScore = prefs.getInteger("bestScore");
        coinsTotal = prefs.getInteger("coinsTotal");
        skinSeleccionada = prefs.getInteger("skinSeleccionada");

        didBuyNoAds = prefs.getBoolean("didBuyNoAds");
        didLikeFacebook = prefs.getBoolean("didLikeFacebook");
        isMusicOn = prefs.getBoolean("isMusicOn", true);

    }

    public static void save() {
        prefs.putInteger("numeroVecesJugadas", numeroVecesJugadas);
        prefs.putInteger("bestScore", bestScore);
        prefs.putInteger("coinsTotal", coinsTotal);
        prefs.putInteger("skinSeleccionada", skinSeleccionada);

        prefs.putBoolean("didBuyNoAds", didBuyNoAds);
        prefs.putBoolean("didLikeFacebook", didLikeFacebook);
        prefs.putBoolean("isMusicOn", isMusicOn);
        prefs.flush();

    }

    public static void setNewScore(int score) {
        if (bestScore < score)
            bestScore = score;
        save();
    }

}

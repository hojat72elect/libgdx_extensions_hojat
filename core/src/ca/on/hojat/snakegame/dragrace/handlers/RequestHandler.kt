package ca.on.hojat.snakegame.dragrace.handlers;

public interface RequestHandler {
    void showRater();

    void showInterstitial();

    void showFacebook();

    void shareOnFacebook(final String mensaje);

    void shareOnTwitter(final String mensaje);

    void removeAds();

    void showAdBanner();

    void hideAdBanner();

    void buy50milCoins();

}

package ca.on.hojat.snakegame.dragrace.handlers;

public interface GameServicesHandler {

	/**
	 * Este metodo abstrae a GPGS o a AGC
	 *
	 */
	 void submitScore(long score);

	/**
	 * Este metodo abstrae a GPGS o a AGC
	 *
	 */
	 void getLeaderboard();

	 boolean isSignedIn();

	 void signIn();

}

package ca.on.hojat.snakegame.dragrace.handlers;

public interface GameServicesHandler {

	/**
	 * Este metodo abstrae a GPGS o a AGC
	 * 
	 *
	 */
	public void submitScore(long score);

	/**
	 * Este metodo abstrae a GPGS o a AGC
	 * 
	 *
	 */
	public void unlockAchievement(String achievementId);

	/**
	 * Este metodo abstrae a GPGS o a AGC
	 * 
	 *
	 */
	public void getLeaderboard();

	/**
	 * Este metodo abstrae a GPGS o a AGC
	 * 
	 *
	 */
	public void getAchievements();

	public boolean isSignedIn();

	public void signIn();

	public void signOut();

}

class Season {
	private static final double battingAverage = 0.350;
	private static final int numAtBats = 4;
	private final int numGames;

	Season(int _numGames) {
		numGames = _numGames;
	}

	private static boolean swing() {
		return Math.random() < battingAverage;
	}

	private static int playGame() {
		int hits = 0;
		for (int i = 0; i < numAtBats; ++i) {
			if (swing()) {
				++hits;
			}
		}
		return hits;
	}

	public double playSeason() {
		int hits = 0;
		for (int i = 0; i < numGames; ++i) {
			hits += playGame();
		}
		return ((double) hits) / (numAtBats * numGames);
	}
}

public class Express {
	public static void main(String[] args) {
		getOdds(10000, 60);
		getOdds(10000, 162);
	}

	private static void getOdds(int numSamples, int numGames) {
		Season s = new Season(numGames);
		int seasonsOver400 = 0;
		for (int i = 0; i < numSamples; ++i) {
			if (s.playSeason() >= 0.400) {
				++seasonsOver400;
			}
		}
		double oddsOfOver400 = ((double) seasonsOver400) / numSamples;
		System.out.println("For N = " + numSamples + ": " + oddsOfOver400 + " for a " + numGames + "-game season.");
	}
}
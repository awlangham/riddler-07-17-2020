class Season {
	private static final double battingAverage = 0.350;
	private static final int numAtBats = 4;
	private static final int numGames = 60;

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

	public static double playSeason() {
		int hits = 0;
		for (int i = 0; i < numGames; ++i) {
			hits += playGame();
		}
		return ((double) hits) / (numAtBats * numGames);
	}
}

public class Express {
	public static void main(String[] args) {
		Season s1 = new Season();
		int numSamples = 1000000;
		int seasonsOver400 = 0;
		for (int i = 0; i < numSamples; ++i) {
			if (s1.playSeason() >= 0.400) {
				++seasonsOver400;
			}
		}
		double oddsOfOver400 = ((double) seasonsOver400) / numSamples;
		System.out.println("For N = " + numSamples + ": " + oddsOfOver400);
	}
}
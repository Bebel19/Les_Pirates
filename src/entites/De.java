package entites;

import java.util.Random;

public class De {
	private Random random;

	public De() {
		this.random = new Random();
	}

	public int lancerDe() {
		return 1 + random.nextInt(6);
	}
}

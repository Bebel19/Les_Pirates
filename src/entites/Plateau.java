package entites;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import utils.Arme;

public class Plateau {
	private static final int NOMBRE_CASES = 30;
	private Map<Integer, Case> cases;

	public Plateau() {
		cases = new HashMap<>();

		genererPlateau();
	}

	public static int getNbCases() {
		return NOMBRE_CASES;
	}

	public Case getCase(int numero) {

		return cases.get(numero);
	}

	public Collection<Case> getCases() {
		return cases.values();
	}

	public int calculPosition(int nouvellePosition) {
		int destinationFinale;

		if (nouvellePosition > Plateau.getNbCases()) {

			destinationFinale = nouvellePosition - NOMBRE_CASES;
		} else {
			destinationFinale = nouvellePosition;
		}

		return destinationFinale;
	}

	private void genererPlateau() {
		Random random = new Random();
		cases.put(0, null);

		for (int i = 1; i < NOMBRE_CASES - 1; i++) {
			int test = random.nextInt(3) + 1;

			switch (test) {
			case 1:
				cases.put(i, new CaseRhum(i));
				break;
			case 2:
				cases.put(i, new CaseArme(i, Arme.obtenirArmeAleatoire()));
				break;
			default:
				cases.put(i, null);
				break;
			}
		}

		cases.put(NOMBRE_CASES - 1, new CaseWin(NOMBRE_CASES - 1));

	}
}

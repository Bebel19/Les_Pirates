/**
 * @class De
 * @brief Classe représentant un dé utilisé dans le jeu pour générer des nombres aléatoires.
 *
 * Fournit une abstraction d'un dé dans le contexte du jeu, permettant de simuler le lancer
 * d'un dé à six faces pour déterminer aléatoirement le déplacement des pirates ou d'autres effets.
 */

package entites;

import java.util.Random;

public class De {
	private Random random;

	/**
	 * @brief Constructeur de la classe De.
	 *
	 *        Initialise une nouvelle instance de Random pour générer des valeurs
	 *        aléatoires représentant les résultats d'un lancer de dé.
	 */

	public De() {
		this.random = new Random();
	}

	/**
	 * @brief Simule le lancer d'un dé à six faces.
	 * @return Un entier entre 1 et 6, représentant le résultat du lancer de dé.
	 *
	 *         Cette méthode génère et retourne un nombre aléatoire entre 1 et 6
	 *         inclus, simulant le résultat d'un lancer d'un dé à six faces
	 *         standard.
	 */

	public int lancerDe() {
		return 1 + random.nextInt(6);
	}
}

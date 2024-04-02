/**
 * @class De
 * @brief Classe repr�sentant un d� utilis� dans le jeu pour g�n�rer des nombres al�atoires.
 *
 * Fournit une abstraction d'un d� dans le contexte du jeu, permettant de simuler le lancer
 * d'un d� � six faces pour d�terminer al�atoirement le d�placement des pirates ou d'autres effets.
 */

package entites;

import java.util.Random;

public class De {
	private Random random;

	/**
	 * @brief Constructeur de la classe De.
	 *
	 *        Initialise une nouvelle instance de Random pour g�n�rer des valeurs
	 *        al�atoires repr�sentant les r�sultats d'un lancer de d�.
	 */

	public De() {
		this.random = new Random();
	}

	/**
	 * @brief Simule le lancer d'un d� � six faces.
	 * @return Un entier entre 1 et 6, repr�sentant le r�sultat du lancer de d�.
	 *
	 *         Cette m�thode g�n�re et retourne un nombre al�atoire entre 1 et 6
	 *         inclus, simulant le r�sultat d'un lancer d'un d� � six faces
	 *         standard.
	 */

	public int lancerDe() {
		return 1 + random.nextInt(6);
	}
}

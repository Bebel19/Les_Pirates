/**
 * @class Plateau
 * @brief Classe représentant le plateau de jeu.
 *
 * Gère l'ensemble des cases du jeu, y compris leur initialisation et la logique pour obtenir des informations
 * sur les cases spécifiques. Le plateau est essentiel pour déterminer le déroulement du jeu et l'interaction
 * des pirates avec les différentes cases.
 */

package entites;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import utils.Arme;

public class Plateau {
	private static final int NOMBRE_CASES = 30;
	private Map<Integer, Case> cases;

	/**
	 * @brief Constructeur du plateau de jeu.
	 *
	 *        Initialise le plateau de jeu avec un nombre prédéfini de cases, en
	 *        générant aléatoirement les cases spéciales telles que les cases rhum
	 *        et les cases arme, tout en réservant une case pour la victoire.
	 */

	public Plateau() {
		cases = new HashMap<>();

		genererPlateau();
	}

	/**
	 * @brief Retourne le nombre total de cases sur le plateau.
	 * @return Le nombre total de cases.
	 */
	public static int getNbCases() {
		return NOMBRE_CASES;
	}

	/**
	 * @brief Obtient la case correspondant au numéro spécifié.
	 * @param numero Le numéro de la case à obtenir.
	 * @return La case au numéro donné ou null si aucune case n'existe à ce numéro.
	 */
	public Case getCase(int numero) {

		return cases.get(numero);
	}

	/**
	 * @brief Retourne une collection de toutes les cases sur le plateau.
	 * @return Une collection contenant toutes les cases du plateau.
	 */

	public Collection<Case> getCases() {
		return cases.values();
	}

	/**
	 * @brief Calcule la position finale sur le plateau en tenant compte des
	 *        débordements.
	 * @param nouvellePosition La position calculée avant ajustement.
	 * @return La position ajustée en fonction des limites du plateau.
	 *
	 *         Cette méthode ajuste la position si le calcul initial dépasse le
	 *         nombre total de cases, permettant ainsi de "boucler" autour du
	 *         plateau.
	 */
	public int calculPosition(int nouvellePosition) {
		int destinationFinale;

		if (nouvellePosition > Plateau.getNbCases()) {

			destinationFinale = nouvellePosition - NOMBRE_CASES;
		} else {
			destinationFinale = nouvellePosition;
		}

		return destinationFinale;
	}

	/**
	 * @brief Génère les cases du plateau, incluant des cases spéciales aléatoires.
	 *
	 *        Initialise le plateau avec un mélange de cases normales, de cases
	 *        contenant du rhum, de cases contenant des armes, et termine avec une
	 *        case de victoire. La répartition et le type des cases spéciales sont
	 *        déterminés aléatoirement.
	 */
	private void genererPlateau() {
		Random random = new Random();
		cases.put(0, null);

		for (int i = 1; i < NOMBRE_CASES; i++) {
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

		cases.put(NOMBRE_CASES , new CaseWin(NOMBRE_CASES ));

	}

	public int getLargeur() {
		// TODO Auto-generated method stub
		return 0;
	}
}

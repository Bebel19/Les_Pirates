/**
 * @class Plateau
 * @brief Classe repr�sentant le plateau de jeu.
 *
 * G�re l'ensemble des cases du jeu, y compris leur initialisation et la logique pour obtenir des informations
 * sur les cases sp�cifiques. Le plateau est essentiel pour d�terminer le d�roulement du jeu et l'interaction
 * des pirates avec les diff�rentes cases.
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
	 *        Initialise le plateau de jeu avec un nombre pr�d�fini de cases, en
	 *        g�n�rant al�atoirement les cases sp�ciales telles que les cases rhum
	 *        et les cases arme, tout en r�servant une case pour la victoire.
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
	 * @brief Obtient la case correspondant au num�ro sp�cifi�.
	 * @param numero Le num�ro de la case � obtenir.
	 * @return La case au num�ro donn� ou null si aucune case n'existe � ce num�ro.
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
	 *        d�bordements.
	 * @param nouvellePosition La position calcul�e avant ajustement.
	 * @return La position ajust�e en fonction des limites du plateau.
	 *
	 *         Cette m�thode ajuste la position si le calcul initial d�passe le
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
	 * @brief G�n�re les cases du plateau, incluant des cases sp�ciales al�atoires.
	 *
	 *        Initialise le plateau avec un m�lange de cases normales, de cases
	 *        contenant du rhum, de cases contenant des armes, et termine avec une
	 *        case de victoire. La r�partition et le type des cases sp�ciales sont
	 *        d�termin�s al�atoirement.
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

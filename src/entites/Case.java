/**
 * @class Case
 * @brief Classe abstraite représentant une case du plateau de jeu.
 *
 * Définit les propriétés communes à toutes les cases du jeu, y compris leur numéro et l'effet associé.
 * Chaque type spécifique de case hérite de cette classe pour implémenter des effets spécifiques.
 */

package entites;

import utils.Effet;

public abstract class Case {
	protected int numero;
	protected Effet effet;

	/**
	 * @brief Constructeur de la classe Case.
	 * @param numero Le numéro identifiant la case sur le plateau.
	 * @param effet  L'effet appliqué à un pirate lorsqu'il arrive sur cette case.
	 *
	 *               Initialise une instance de Case avec un numéro et un effet
	 *               spécifiques.
	 */

	protected Case(int numero, Effet effet) {
		this.numero = numero;
		this.effet = effet;
	}

	/**
	 * @brief Applique l'effet de la case sur le pirate qui y arrive.
	 * @param pirate Le pirate sur lequel l'effet doit être appliqué.
	 * @param jeu    L'instance du jeu, permettant d'accéder à l'état global du jeu
	 *               si nécessaire.
	 *
	 *               Cette méthode doit être implémentée par les sous-classes pour
	 *               définir comment l'effet de la case affecte le pirate et
	 *               potentiellement le jeu lui-même.
	 */

	public abstract void appliquerEffet(Pirate pirate, Jeu jeu);

	/**
	 * @brief Obtient le numéro de la case.
	 * @return Le numéro de la case.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @brief Obtient l'effet associé à la case.
	 * @return L'effet de la case.
	 */
	public Effet getEffet() {
		return effet;
	}

}
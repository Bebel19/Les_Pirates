/**
 * @class Case
 * @brief Classe abstraite repr�sentant une case du plateau de jeu.
 *
 * D�finit les propri�t�s communes � toutes les cases du jeu, y compris leur num�ro et l'effet associ�.
 * Chaque type sp�cifique de case h�rite de cette classe pour impl�menter des effets sp�cifiques.
 */

package entites;

import utils.Effet;

public abstract class Case {
	protected int numero;
	protected Effet effet;

	/**
	 * @brief Constructeur de la classe Case.
	 * @param numero Le num�ro identifiant la case sur le plateau.
	 * @param effet  L'effet appliqu� � un pirate lorsqu'il arrive sur cette case.
	 *
	 *               Initialise une instance de Case avec un num�ro et un effet
	 *               sp�cifiques.
	 */

	protected Case(int numero, Effet effet) {
		this.numero = numero;
		this.effet = effet;
	}

	/**
	 * @brief Applique l'effet de la case sur le pirate qui y arrive.
	 * @param pirate Le pirate sur lequel l'effet doit �tre appliqu�.
	 * @param jeu    L'instance du jeu, permettant d'acc�der � l'�tat global du jeu
	 *               si n�cessaire.
	 *
	 *               Cette m�thode doit �tre impl�ment�e par les sous-classes pour
	 *               d�finir comment l'effet de la case affecte le pirate et
	 *               potentiellement le jeu lui-m�me.
	 */

	public abstract void appliquerEffet(Pirate pirate, Jeu jeu);

	/**
	 * @brief Obtient le num�ro de la case.
	 * @return Le num�ro de la case.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @brief Obtient l'effet associ� � la case.
	 * @return L'effet de la case.
	 */
	public Effet getEffet() {
		return effet;
	}

}
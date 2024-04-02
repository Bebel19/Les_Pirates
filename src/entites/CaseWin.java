/**
 * @class CaseWin
 * @brief Classe représentant une case de victoire sur le plateau de jeu.
 *
 * Cette classe étend la classe abstraite Case en implémentant une case spéciale qui,
 * lorsqu'atteinte par un pirate, déclenche la fin du jeu et désigne ce pirate comme le gagnant.
 */
package entites;

import utils.Effet;

public class CaseWin extends Case {
	/**
	 * @brief Constructeur pour créer une case de victoire.
	 * @param numero Le numéro identifiant la case sur le plateau.
	 *
	 *               Initialise une case avec l'effet Effet.WIN, indiquant que cette
	 *               case est une case de victoire.
	 */

	public CaseWin(int numero) {
		super(numero, Effet.WIN);
	}

	/**
	 * @brief Applique l'effet de victoire sur le pirate qui arrive sur cette case.
	 * @param pirate Le pirate qui atteint la case de victoire.
	 * @param jeu    L'instance du jeu utilisée pour terminer le jeu et déclarer le
	 *               pirate comme gagnant.
	 *
	 *               Cette méthode déclenche la fin du jeu en appelant la méthode
	 *               terminerJeu du jeu, passant le pirate comme argument. Cela
	 *               indique que le pirate qui atteint cette case a gagné le jeu.
	 */

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		jeu.terminerJeu(pirate);
	}
}
/**
 * @class CaseWin
 * @brief Classe repr�sentant une case de victoire sur le plateau de jeu.
 *
 * Cette classe �tend la classe abstraite Case en impl�mentant une case sp�ciale qui,
 * lorsqu'atteinte par un pirate, d�clenche la fin du jeu et d�signe ce pirate comme le gagnant.
 */
package entites;

import utils.Effet;

public class CaseWin extends Case {
	/**
	 * @brief Constructeur pour cr�er une case de victoire.
	 * @param numero Le num�ro identifiant la case sur le plateau.
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
	 * @param jeu    L'instance du jeu utilis�e pour terminer le jeu et d�clarer le
	 *               pirate comme gagnant.
	 *
	 *               Cette m�thode d�clenche la fin du jeu en appelant la m�thode
	 *               terminerJeu du jeu, passant le pirate comme argument. Cela
	 *               indique que le pirate qui atteint cette case a gagn� le jeu.
	 */

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		jeu.terminerJeu(pirate);
	}
}
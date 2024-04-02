/**
 * @class CaseRhum
 * @brief Classe représentant une case contenant du rhum sur le plateau de jeu.
 *
 * Hérite de la classe abstraite Case et implémente l'effet appliqué à un pirate lorsqu'il arrive sur cette case,
 * typiquement en le faisant reculer d'un nombre de cases déterminé par un lancer de dé,
 * simulant l'ivresse causée par le rhum.
 */

package entites;

import utils.Effet;

public class CaseRhum extends Case {
	/**
	 * @brief Constructeur pour créer une case contenant du rhum.
	 * @param numero Le numéro identifiant la case sur le plateau.
	 *
	 *               Initialise une case avec l'effet Effet.RHUM pour simuler la
	 *               présence de rhum sur cette case, qui affectera le pirate y
	 *               arrivant de manière spécifique.
	 */

	public CaseRhum(int numero) {
		super(numero, Effet.RHUM);
	}

	/**
	 * @brief Applique l'effet d'ivresse du rhum sur le pirate qui arrive sur la
	 *        case.
	 * @param pirate Le pirate affecté par l'effet de la case.
	 * @param jeu    L'instance du jeu, utilisée ici pour accéder à l'affichage et
	 *               déplacer le pirate.
	 *
	 *               L'effet fait reculer le pirate d'un nombre de cases déterminé
	 *               aléatoirement par un lancer de dé, simulant l'ivresse causée
	 *               par le rhum. Le jeu est informé du nombre de cases reculées, et
	 *               le pirate est déplacé en conséquence.
	 */

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		De de = new De();
		int valRecul = de.lancerDe();
		jeu.getAffichage().afficherIvresse(valRecul);
		jeu.deplacerPirate(pirate, -valRecul);

	}

}
/**
 * @class CaseRhum
 * @brief Classe repr�sentant une case contenant du rhum sur le plateau de jeu.
 *
 * H�rite de la classe abstraite Case et impl�mente l'effet appliqu� � un pirate lorsqu'il arrive sur cette case,
 * typiquement en le faisant reculer d'un nombre de cases d�termin� par un lancer de d�,
 * simulant l'ivresse caus�e par le rhum.
 */

package entites;

import utils.Effet;

public class CaseRhum extends Case {
	/**
	 * @brief Constructeur pour cr�er une case contenant du rhum.
	 * @param numero Le num�ro identifiant la case sur le plateau.
	 *
	 *               Initialise une case avec l'effet Effet.RHUM pour simuler la
	 *               pr�sence de rhum sur cette case, qui affectera le pirate y
	 *               arrivant de mani�re sp�cifique.
	 */

	public CaseRhum(int numero) {
		super(numero, Effet.RHUM);
	}

	/**
	 * @brief Applique l'effet d'ivresse du rhum sur le pirate qui arrive sur la
	 *        case.
	 * @param pirate Le pirate affect� par l'effet de la case.
	 * @param jeu    L'instance du jeu, utilis�e ici pour acc�der � l'affichage et
	 *               d�placer le pirate.
	 *
	 *               L'effet fait reculer le pirate d'un nombre de cases d�termin�
	 *               al�atoirement par un lancer de d�, simulant l'ivresse caus�e
	 *               par le rhum. Le jeu est inform� du nombre de cases recul�es, et
	 *               le pirate est d�plac� en cons�quence.
	 */

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		De de = new De();
		int valRecul = de.lancerDe();
		jeu.getAffichage().afficherIvresse(valRecul);
		jeu.deplacerPirate(pirate, -valRecul);

	}

}
/**
 * @class CaseArme
 * @brief Classe représentant une case contenant une arme sur le plateau de jeu.
 *
 * Cette classe hérite de la classe abstraite Case et implémente l'effet spécifique
 * appliqué à un pirate lorsqu'il arrive sur une case contenant une arme.
 */

package entites;

import utils.Arme;
import utils.Effet;

public class CaseArme extends Case {
	private Arme arme;

	/**
	 * @brief Constructeur pour créer une case d'arme.
	 * @param numero Le numéro de la case.
	 * @param arme   L'arme présente sur cette case.
	 *
	 *               Initialise une case avec une arme spécifiée. L'effet de cette
	 *               case est automatiquement défini comme étant Effet.ARME.
	 */

	public CaseArme(int numero, Arme arme) {
		super(numero, Effet.ARME);
		this.arme = arme;
	}

	/**
	 * @brief Applique l'effet de trouver une arme sur la case au pirate qui y
	 *        arrive.
	 * @param pirate Le pirate qui arrive sur la case.
	 * @param jeu    L'instance du jeu permettant l'accès à l'affichage et à
	 *               d'autres composantes du jeu.
	 *
	 *               Si le pirate n'a pas d'arme ou si l'arme sur la case est plus
	 *               puissante que celle du pirate, le pirate prend la nouvelle
	 *               arme. Sinon, un message indiquant que le pirate ne prend pas
	 *               l'arme est affiché.
	 */

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		if (pirate.getArme() == null || pirate.getArme().getForce() < this.getArme().getForce()) {
			pirate.setArme(this.getArme()); // Le pirate prend la nouvelle arme
			jeu.getAffichage().afficherChangementArme(pirate, this.getArme());
		} else
			jeu.getAffichage().afficherMessage("Le pirate ne prend pas l'arme");
	}

	/**
	 * @brief Obtient l'arme associée à cette case.
	 * @return L'arme présente sur cette case.
	 */

	public Arme getArme() {
		return this.arme;
	}
}
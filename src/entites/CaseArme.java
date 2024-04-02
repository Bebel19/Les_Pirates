package entites;

import affichage.AffichageTerminal;
import utils.Arme;
import utils.Effet;

public class CaseArme extends Case {
	private Arme arme;

	public CaseArme(int numero, Arme arme) {
		super(numero, Effet.ARME);
		this.arme = arme;
	}

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		if (pirate.getArme() == null || pirate.getArme().getForce() < this.getArme().getForce()) {
			pirate.setArme(this.getArme()); // Le pirate prend la nouvelle arme
			jeu.getAffichage().afficherChangementArme(pirate, this.getArme());
		}
		else
			jeu.getAffichage().afficherMessage("Le pirate ne prend pas l'arme");
	}

	// Getters et Setters pour arme
	public Arme getArme() {
		return this.arme;
	}
}
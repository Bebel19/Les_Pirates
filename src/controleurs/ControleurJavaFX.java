package controleurs;

import entites.Jeu;
import entites.Pirate;


import affichage.IAffichage;

public class ControleurJavaFX {
	private Jeu jeu;
	private IAffichage affichage;

	public ControleurJavaFX(Jeu jeu, IAffichage affichage) {
		this.jeu = jeu;
		this.affichage = affichage;
	}

	public void demarrerJeu() {
		jeu.choisirJoueursEtPirates();
		affichage.afficherPlateau(jeu.getPlateau());
		while (!jeu.getJeuTermine()) {
			for (Pirate pirate : jeu.getPirates()) {
				jeu.verifierDernierPirateRestant();
				if (!jeu.getJeuTermine()) {
					affichage.afficherPirates(jeu.getPirates(), jeu.getPlateau());
					affichage.afficherDebutTour(pirate); // Afficher le début du tour
					tourPirate(pirate);
					affichage.afficherFinTour(pirate); // Afficher la fin du tour
					affichage.afficherPirates(jeu.getPirates(), jeu.getPlateau());
					jeu.verifierDernierPirateRestant(); // Vérifier s'il ne reste qu'un seul pirate en jeu
				}
			}
		}
		affichage.afficherGagnant(jeu.getPirateGagnant());
	}

	public void tourPirate(Pirate pirate) {
		if (!jeu.getJeuTermine()) {

			int lance = jeu.getDe().lancerDe();
			jeu.deplacerPirate(pirate, lance);
			duel(pirate);
			affichage.afficherPirates(jeu.getPirates(), jeu.getPlateau());

		}
	}

	private void duel(Pirate pirate) {
		for (Pirate autrePirate : jeu.getPirates()) {
			if (!jeu.getJeuTermine() && autrePirate != pirate
					&& Math.abs(autrePirate.getPosition() - pirate.getPosition()) <= 2
					&& jeu.engagerDuel(pirate, autrePirate)) {

				break;
			}

		}

	}

}
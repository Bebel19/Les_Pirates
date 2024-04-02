package controleurs;

import entites.Jeu;
import entites.Pirate;

import java.util.HashSet;
import java.util.Set;

import affichage.IAffichage;

public class ControleurJavaFX {
    private Jeu jeu;
    private IAffichage affichage;

    public ControleurJavaFX(Jeu jeu, IAffichage affichage) {
        this.jeu = jeu;
        this.affichage = affichage;
    }

    public void demarrerJeu() {
        affichage.afficherMessage("Le jeu des Pirates commence !");
        jeu.choisirJoueursEtPirates(); // Initialise le plateau, les pirates, etc.
        boucleDeJeu();
    }

    private void boucleDeJeu() {
		while (!jeu.getJeuTermine()) {

			for (Pirate pirate : jeu.getPirates()) {
            affichage.afficherPlateau(jeu.getPlateau());
                if (!jeu.getJeuTermine()) {
                    effectuerTourPirate(pirate);
                }
            }
        }
        affichage.afficherMessage("Le jeu est terminé !");
        affichage.afficherGagnant(jeu.getPirateGagnant()); // Supposition d'une méthode pour obtenir le gagnant
    }

    private void effectuerTourPirate(Pirate pirate) {				
		Set<Pirate> piratesAyantCombattu = new HashSet<>();
	if (!piratesAyantCombattu.contains(pirate)) {
		affichage.afficherPirates(jeu.getPirates());
		affichage.afficherDebutTour(pirate); // Afficher le début du tour
		
		int lance = jeu.getDe().lancerDe();
		jeu.deplacerPirate(pirate, lance);
		for (Pirate autrePirate : jeu.getPirates()) {
			if (autrePirate != pirate && !piratesAyantCombattu.contains(autrePirate)
					&& Math.abs(autrePirate.getPosition() - pirate.getPosition()) <= 2) {
				if (jeu.engagerDuel(pirate, autrePirate) && !jeu.getJeuTermine()) {
					piratesAyantCombattu.add(pirate);
					piratesAyantCombattu.add(autrePirate);
					break;
				}
			}
		}
		affichage.afficherPirates(jeu.getPirates());
		affichage.afficherFinTour(pirate); // Afficher la fin du tour
		jeu.verifierTresorTrouve(pirate); // Vérifier si le pirate a trouvé le trésor
		jeu.verifierDernierPirateRestant(); // Vérifier s'il ne reste qu'un seul pirate en jeu
	}
    }
}

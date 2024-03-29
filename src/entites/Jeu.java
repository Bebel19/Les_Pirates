package entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import affichage.AffichageTerminal;
import utils.PirateNom;
import utils.Couleur;

public class Jeu {
	private int nbJoueurs;
	private Pirate[] listePirates;
	private Plateau plateau = new Plateau();
	private De de;
	private AffichageTerminal aff;
	private boolean jeuTermine = false;

	public Jeu() {

		this.listePirates = new Pirate[nbJoueurs];
		this.nbJoueurs = 2;
		this.de = new De();
		this.aff = new AffichageTerminal();
	}

	public Jeu(int nbJoueurs) {
		this.listePirates = new Pirate[nbJoueurs];
		this.nbJoueurs = nbJoueurs;
		this.de = new De();
		this.aff = new AffichageTerminal();
	}



	public void start() {
	    choisirJoueursEtPirates();
	    while (!jeuTermine) {
	        Set<Pirate> piratesAyantCombattu = new HashSet<>();
	        for (Pirate pirate : listePirates) {
	            if (jeuTermine) {
	                break;
	            }
	            if (!piratesAyantCombattu.contains(pirate)) {
	                aff.afficherDebutTour(pirate);
	                int lance = de.lancerDe();
	                aff.afficherLanceDe(pirate, lance);
	                deplacerPirate(pirate, lance);
	                for (Pirate autrePirate : listePirates) {
	                    if (autrePirate != pirate && !piratesAyantCombattu.contains(autrePirate) && Math.abs(autrePirate.getPosition() - pirate.getPosition()) <= 2) {
	                        if (engagerDuel(pirate, autrePirate)&& !jeuTermine) {
	                            piratesAyantCombattu.add(pirate);
	                            piratesAyantCombattu.add(autrePirate);
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	    }
	}

	
	public Pirate[] getPirates() {
		return listePirates;
	}

	public void deplacerPirate(Pirate pirate, int valeurDe) {
		if (jeuTermine) {
			return;
		}

		int nouvellePosition = pirate.getPosition() + valeurDe;

		if (nouvellePosition > Plateau.getNbCases()) {

			nouvellePosition -= Plateau.getNbCases();
		}

		pirate.setPosition(nouvellePosition);

		Case caseCourante = plateau.getCase(nouvellePosition);
		aff.afficherPosition(nouvellePosition, caseCourante);

		if (caseCourante != null) {
			caseCourante.appliquerEffet(pirate, this);
			if (jeuTermine) {
				return;
			}
		} else {

			aff.afficherCaseNormale(nouvellePosition);
		}


	}

	public void terminerJeu(Pirate pirate) {
		aff.afficherGagnant(pirate);
		jeuTermine = true;
	}

	public void choisirJoueursEtPirates() {
		int nombreJoueurs = this.aff.demanderNombreJoueurs();
		listePirates = new Pirate[nombreJoueurs];

		for (int i = 0; i < nombreJoueurs; i++) {
			PirateNom choixPirate = this.aff.choisirPirate();
			Couleur choixCouleur = this.aff.choisirCouleur();

			Pirate pirate = new Pirate(choixPirate.toString(), choixCouleur);
			listePirates[i] = pirate;
		}
	}

	public boolean engagerDuel(Pirate pirate1, Pirate pirate2) {

		aff.afficherMessage("Un duel est engagé entre " + pirate1.getNom() + " et " + pirate2.getNom() + ".");

		int forcePirate1 = pirate1.getArme() != null ? pirate1.getArme().getForce() : 0;
		int forcePirate2 = pirate2.getArme() != null ? pirate2.getArme().getForce() : 0;

		if (forcePirate1 > forcePirate2) {
			pirate2.perdrePv(1);
			aff.afficherMessage(pirate2.getNom() + " perd le duel et 1 PV. PV restants : " + pirate2.getPv());
			if (pirate2.estMort()) {
				aff.afficherMessage("Le pirate " + pirate2.getNom() + " est mort ce soir.");
				verifierEtRetirerPiratesMorts();
			}
		} else if (forcePirate2 > forcePirate1) {
			pirate1.perdrePv(1);
			aff.afficherMessage(pirate1.getNom() + " perd le duel et 1 PV. PV restants : " + pirate1.getPv());
			if (pirate1.estMort()) {
				aff.afficherMessage("Le pirate " + pirate1.getNom() + " est mort ce soir.");
				verifierEtRetirerPiratesMorts();
			}
		} else {
			aff.afficherMessage("Le duel se termine par un match nul.");
		}
		return true;

	}

	public void verifierEtRetirerPiratesMorts() {
	    // Créer une liste temporaire pour les pirates vivants
	    List<Pirate> piratesVivants = new ArrayList<>();

	    // Parcourir tous les pirates et ajouter les vivants à la liste temporaire
	    for (Pirate pirate : listePirates) {
	        if (!pirate.estMort()) {
	            piratesVivants.add(pirate);
	        } else {
	            // Gérer la logique liée à la mort du pirate, par exemple afficher un message
	            System.out.println("Le pirate " + pirate.getNom() + " est mort.");
	        }
	    }

	    // Convertir la liste des pirates vivants en un nouveau tableau et le réaffecter à listePirates
	    listePirates = piratesVivants.toArray(new Pirate[0]);
	}

}

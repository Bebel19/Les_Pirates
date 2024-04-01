package entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import affichage.IAffichage;

public class Jeu {
	private List<Pirate> listePirates = new ArrayList<>();
	private Plateau plateau = new Plateau();
	private De de;
	private IAffichage aff;
	private boolean jeuTermine = false;

	public Jeu(IAffichage aff) {
		this.aff = aff;
		this.de = new De();
        this.aff.setOnSelectionComplete(this::onPiratesSelected);
        
	}

	public void setPirates(List<Pirate> pirates) {
        this.listePirates = pirates;
    }

    private void onPiratesSelected(List<Pirate> pirates) {
        this.listePirates.addAll(pirates);
        start(); // Commencez le jeu après la sélection des joueurs
    }
	public void start() {
	    
	    while (!jeuTermine && (listePirates.size()>1)) {
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
	                    if (autrePirate != pirate && !piratesAyantCombattu.contains(autrePirate) && Math.abs(autrePirate.getPosition() - pirate.getPosition()) <= 2 && engagerDuel(pirate, autrePirate)&& !jeuTermine) {
	                        
	                            piratesAyantCombattu.add(pirate);
	                            piratesAyantCombattu.add(autrePirate);
	                            break;
	                        
	                    }
	                }
	            }
	        }
	    }
	}

	public void setAffichage(IAffichage aff) {
	    this.aff = aff;
	}

	public List<Pirate> getPirates() {
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
	    aff.lancerSelectionJoueurs(selectedPirates -> {
	        this.listePirates = selectedPirates;
	        // Tout autre code nécessaire après la sélection des pirates
	        start();
	    });
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
	    Iterator<Pirate> iterator = listePirates.iterator();
	    while (iterator.hasNext()) {
	        Pirate pirate = iterator.next();
	        if (pirate.estMort()) {
	            aff.afficherMessage("Le pirate " + pirate.getNom() + " est mort.");
	            iterator.remove(); 
	        }
	    }
	}

	

    public void ajouterPirate(Pirate pirate) {
        listePirates.add(pirate);
    }
    

}

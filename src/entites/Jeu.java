package entites;

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
			for (Pirate pirate : listePirates) {
				if (jeuTermine) {
					break;
				}
				aff.afficherDebutTour(pirate);
				int lance = de.lancerDe();
				aff.afficherLanceDe(pirate, lance);
				deplacerPirate(pirate, lance);

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
		for (Pirate autrePirate : listePirates) {
			if (autrePirate != pirate && Math.abs(autrePirate.getPosition() - pirate.getPosition()) <= 2) {
				engagerDuel(pirate, autrePirate);
				break;
			}
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

	public void engagerDuel(Pirate pirate1, Pirate pirate2) {

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

	}

	public void verifierEtRetirerPiratesMorts() {
		int nbVivants = 0;

		for (Pirate pirate : listePirates) {
			if (!pirate.estMort()) {
				nbVivants++;
			}
		}

		Pirate[] piratesVivants = new Pirate[nbVivants];

		int index = 0;
		for (Pirate pirate : listePirates) {
			if (!pirate.estMort()) {
				piratesVivants[index++] = pirate;
			}
		}

		listePirates = piratesVivants;
	}
}

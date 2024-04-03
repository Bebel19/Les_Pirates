/**
 * @class Jeu
 * @brief Classe principale qui gère la logique du jeu.
 *
 * Responsable de l'initialisation du jeu, de la gestion des tours, des duels entre pirates,
 * et de la détermination du gagnant. Elle utilise un plateau de jeu, des dés, et un système d'affichage
 * pour interagir avec les joueurs.
 */
package entites;

import java.util.ArrayList;
import java.util.List;

import affichage.IAffichage;
import utils.PirateNom;
import utils.Couleur;

public class Jeu {
	private int nbJoueurs = 2;
	private Pirate[] listePirates;
	private Plateau plateau = new Plateau();
	private De de;
	private IAffichage affichage;
	private boolean jeuTermine = false;
	private Pirate pirateGagnant = null;

	/**
	 * @brief Constructeur du jeu avec affichage spécifié.
	 * @param affichage L'interface d'affichage utilisée pour interagir avec
	 *                  l'utilisateur.
	 *
	 *                  Initialise le jeu avec un dé, et l'interface d'affichage
	 *                  fournie.
	 */
	public Jeu(IAffichage affichage) {

		this.listePirates = new Pirate[nbJoueurs];
		this.de = new De();
		this.affichage = affichage;
	}

	/**
	 * @brief Commence et exécute le cycle de jeu jusqu'à ce qu'un gagnant soit
	 *        déterminé.
	 *
	 *        Cette méthode gère la séquence complète du jeu, incluant le choix des
	 *        joueurs et des pirates, les déplacements sur le plateau, les duels, et
	 *        la vérification des conditions de victoire.
	 */
	public void start() {
		choisirJoueursEtPirates();
		while (!jeuTermine) {
			for (Pirate pirate : listePirates) {
				verifierDernierPirateRestant();
				if (!jeuTermine) {
					affichage.afficherDebutTour(pirate); // Afficher le début du tour
					tourPirate(pirate);
					affichage.afficherFinTour(pirate); // Afficher la fin du tour
					verifierDernierPirateRestant(); // Vérifier s'il ne reste qu'un seul pirate en jeu
				}
			}
		}
		affichage.afficherGagnant(pirateGagnant);
	}

	public void tourPirate(Pirate pirate) {
		if (!jeuTermine) {
			int lance = de.lancerDe();
			affichage.affichageDe(pirate, lance);
			deplacerPirate(pirate, lance);
			duel(pirate);

		}
	}

	private void duel(Pirate pirate) {
		for (Pirate autrePirate : listePirates) {
			if (!jeuTermine && autrePirate != pirate && Math.abs(autrePirate.getPosition() - pirate.getPosition()) <= 2
					&& engagerDuel(pirate, autrePirate)) {

				break;
			}

		}

	}

	/**
	 * @brief Détermine si un pirate a trouvé le trésor et termine le jeu si c'est
	 *        le cas.
	 * @param pirate Le pirate à vérifier.
	 *
	 *               Si le pirate a atteint ou dépassé la dernière case du plateau,
	 *               le jeu est terminé, et ce pirate est déclaré gagnant.
	 */
	public void verifierTresorTrouve(Pirate pirate) {
		if (pirate.getPosition() >= Plateau.getNbCases()) {
			affichage.afficherMessage("Félicitations ! " + pirate.getNom() + ", le vaillant pirate en "
					+ pirate.getCouleur() + ", a trouvé le trésor !");
			jeuTermine = true;
		}
	}

	public void verifierDernierPirateRestant() {
		int piratesRestants = 0;
		for (Pirate p : listePirates) {
			if (p.getPosition() < Plateau.getNbCases()) {
				piratesRestants++;
			}
		}
		if (piratesRestants == 1) {
			// Trouver le seul pirate restant en jeu
			for (Pirate p : listePirates) {
				if (p.getPosition() >= Plateau.getNbCases()) {
					pirateGagnant = p;
					jeuTermine = true;
					break;
				}
			}
		}
	}

	public Pirate[] getPirates() {
		return listePirates;
	}

	/**
	 * @brief Déplace un pirate sur le plateau en fonction du résultat d'un lancer
	 *        de dé.
	 * @param pirate   Le pirate à déplacer.
	 * @param valeurDe Le nombre de cases à déplacer le pirate.
	 *
	 *                 Calcule la nouvelle position du pirate sur le plateau,
	 *                 applique les effets de la case atteinte, et vérifie les
	 *                 conditions de fin de jeu.
	 */
	public void deplacerPirate(Pirate pirate, int valeurDe) {
		if (jeuTermine) {
			return;
		}

		int nouvellePosition = calculerNouvellePosition(pirate.getPosition(), valeurDe);
		pirate.setPosition(nouvellePosition);

		Case caseCourante = plateau.getCase(pirate.getPosition());
		affichage.afficherPosition(pirate, caseCourante);

		if (caseCourante != null) {
			caseCourante.appliquerEffet(pirate, this);
		}
	}

	private int calculerNouvellePosition(int positionActuelle, int deplacement) {
		int nouvellePosition = positionActuelle + deplacement;
		int nbCases = Plateau.getNbCases();

		if (nouvellePosition > nbCases) {
			nouvellePosition -= nbCases;
		} else if (nouvellePosition < 1) {
			nouvellePosition += nbCases;
		}
		return nouvellePosition;
	}

	public void terminerJeu(Pirate pirate) {
		pirateGagnant = pirate;
		affichage.afficherGagnant(pirate);
	}

	/**
	 * @brief Génère les joueurs et assigne des pirates et des couleurs.
	 *
	 *        Demande à l'utilisateur de choisir des noms de pirates et des couleurs
	 *        pour chaque joueur, initialisant ainsi les joueurs du jeu.
	 */
	public void choisirJoueursEtPirates() {
		int nombreJoueurs = this.affichage.demanderNombreJoueurs();
		listePirates = new Pirate[nombreJoueurs];

		for (int i = 0; i < nombreJoueurs; i++) {
			PirateNom choixPirate = this.affichage.choisirPirate();
			Couleur choixCouleur = this.affichage.choisirCouleur();

			Pirate pirate = new Pirate(choixPirate.toString(), choixCouleur);
			listePirates[i] = pirate;
		}
	}

	/**
	 * @brief Engage un duel entre deux pirates lorsqu'ils se rencontrent sur le
	 *        plateau.
	 * @param pirate1 Le premier pirate.
	 * @param pirate2 Le second pirate.
	 * @return Un booléen indiquant si un duel a eu lieu.
	 *
	 *         Compare la force des armes des pirates et détermine le vainqueur du
	 *         duel. Le pirate perdant subit une perte de points de vie.
	 */
	public boolean engagerDuel(Pirate pirate1, Pirate pirate2) {

		affichage.afficherMessage("Un duel est engagé entre " + pirate1.getNom() + " et " + pirate2.getNom() + ".");

		int forcePirate1 = pirate1.getArme() != null ? pirate1.getArme().getForce() : 0;
		int forcePirate2 = pirate2.getArme() != null ? pirate2.getArme().getForce() : 0;

		if (forcePirate1 > forcePirate2) {
			pirate2.perdrePv(1);
			affichage.afficherMessage(pirate2.getNom() + " perd le duel et 1 PV. PV restants : " + pirate2.getPv());
			if (pirate2.estMort()) {
				affichage.afficherMessage("Le pirate " + pirate2.getNom() + " est mort ce soir.");
				verifierEtRetirerPiratesMorts();
			}
		} else if (forcePirate2 > forcePirate1) {
			pirate1.perdrePv(1);
			affichage.afficherMessage(pirate1.getNom() + " perd le duel et 1 PV. PV restants : " + pirate1.getPv());
			if (pirate1.estMort()) {
				affichage.afficherMessage("Le pirate " + pirate1.getNom() + " est mort ce soir.");
				verifierEtRetirerPiratesMorts();
			}
		} else {
			affichage.afficherMessage("Le duel se termine par un match nul.");
		}
		return true;

	}

	public void verifierEtRetirerPiratesMorts() {
		// Créer une liste temporaire pour les pirates vivantsC
		List<Pirate> piratesVivants = new ArrayList<>();

		// Parcourir tous les pirates et ajouter les vivants à la liste temporaire
		for (Pirate pirate : listePirates) {
			if (!pirate.estMort()) {
				piratesVivants.add(pirate);
			}
		}

		// Convertir la liste des pirates vivants en un nouveau tableau et le réaffecter
		// à listePirates
		listePirates = piratesVivants.toArray(new Pirate[0]);
	}

	public boolean getJeuTermine() {
		return jeuTermine;
	}

	public void setJeuTermine(boolean jeuTermine) {
		this.jeuTermine = jeuTermine;
	}

	public IAffichage getAffichage() {
		return affichage;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public De getDe() {
		// TODO Auto-generated method stub
		return de;
	}

	public Pirate getPirateGagnant() {
		// TODO Auto-generated method stub
		return pirateGagnant;
	}

	public void setPirateGagnant(Pirate pirate) {
		pirateGagnant = pirate;

	}

}

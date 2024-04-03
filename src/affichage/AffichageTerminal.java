/**
 * @class AffichageTerminal
 * @brief Implémentation de l'interface IAffichage pour un affichage en terminal.
 *
 * Cette classe offre une interface utilisateur simple en ligne de commande pour interagir avec le jeu,
 * y compris l'affichage du plateau, des messages aux joueurs, et la prise de décisions.
 */

package affichage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import entites.Case;
import entites.CaseArme;
import entites.CaseRhum;
import entites.Pirate;
import entites.Plateau;
import utils.Arme;
import utils.Couleur;
import utils.PirateNom;

public class AffichageTerminal implements IAffichage {
	// Scanner pour lire les entrées utilisateur depuis le terminal.
	private Scanner scanner = new Scanner(System.in);
	// Liste des noms de pirates disponibles pour la sélection par les joueurs.
	private List<PirateNom> piratesDisponibles = new ArrayList<>(List.of(PirateNom.values()));
	// Liste des couleurs disponibles pour la sélection par les joueurs.
	private List<Couleur> couleursDisponibles = new ArrayList<>(List.of(Couleur.values()));

	
	/**
	 * @brief Affiche les détails d'une case spécifique.
	 * @param caseAfficher La case à afficher.
	 *
	 * Cette méthode imprime les informations de la case, y compris son numéro et son contenu,
	 * tel qu'une arme ou du rhum, en ligne de commande.
	 */

	public void afficherCase(Case caseAfficher) {
		if (caseAfficher == null) {
			System.out.println("La case à afficher est vide.");
		} else {
			System.out.println("Numéro case : " + caseAfficher.getNumero());
			switch (caseAfficher.getEffet()) {
			case ARME:
				afficherArme((CaseArme) caseAfficher);
				break;
			case RHUM:
				System.out.println("Sur la case il y a du rhum. Un vrai pirate ne dit jamais non à du rhum !");
				break;
			default:
				System.out.println("C'est une case normale.");
				break;
			}
		}
	}

	public void afficherArme(CaseArme caseArme) {
		System.out.println("Sur la case il y a " + caseArme.getArme().getNom() + " avec une force de "
				+ caseArme.getArme().getForce() + ".");
	}

	public void afficherResultatDe(int resultatDe) {
		if (resultatDe > 0) {
			System.out.println("Le pirate avance de " + resultatDe + " case" + (resultatDe > 1 ? "s." : "."));
		} else {
			System.out.println("Erreur : résultat de dé invalide.");
		}
	}
	
	@Override

	public void afficherIvresse(int valRecul) {
		System.out.println("Trop de rhum ! Le pirate recule de " + valRecul + " case" + (valRecul > 1 ? "s." : "."));
	}

	public void afficherGagnant(Pirate gagnant) {
		System.out.println("Félicitations ! " + gagnant.getNom() + ", le vaillant pirate en " + gagnant.getCouleur()
				+ ", a trouvé le trésor !");
	}

	public void afficherCaseNormale(int nouvellePosition) {
		// TODO Auto-generated method stub

	}
	/**
	 * @brief Demande et valide le nombre de joueurs participant au jeu.
	 * @return Le nombre de joueurs validé.
	 *
	 * Demande aux utilisateurs d'entrer le nombre de joueurs et valide cet input pour s'assurer
	 * qu'il est dans une plage acceptable. Répète la demande jusqu'à recevoir un input valide.
	 */

	@Override
	public int demanderNombreJoueurs() {
	    int maxJoueurs = Math.min(PirateNom.values().length, Couleur.values().length);
	    System.out.print("Combien de joueurs ? (au moins 2 et au maximum " + maxJoueurs + ") ");
	    while (!scanner.hasNextInt()) {
	        scanner.next(); // Consommer l'entrée non valide
	        System.out.println("Veuillez entrer un nombre valide.");
	        System.out.print("Combien de joueurs ? (au moins 2 et au maximum " + maxJoueurs + ") ");
	    }
	    int nombreJoueurs = scanner.nextInt();
	    while (nombreJoueurs < 2 || nombreJoueurs > maxJoueurs) {
	        System.out.println("Le nombre de joueurs doit être entre 2 et " + maxJoueurs + ". Veuillez réessayer.");
	        while (!scanner.hasNextInt()) {
	            scanner.next(); // Consommer l'entrée non valide
	            System.out.println("Veuillez entrer un nombre valide.");
	        }
	        nombreJoueurs = scanner.nextInt();
	    }
	    return nombreJoueurs;
	}

	/**
	 * @brief Permet à l'utilisateur de choisir un pirate parmi les options disponibles.
	 * @return Le nom du pirate choisi.
	 *
	 * Affiche une liste des pirates disponibles et demande à l'utilisateur d'en choisir un.
	 * La sélection est faite via un input numérique correspondant à l'index du pirate.
	 */

	@Override
	public PirateNom choisirPirate() {
	    System.out.println("Pirates disponibles : ");
	    for (int i = 0; i < piratesDisponibles.size(); i++) {
	        System.out.println((i + 1) + ". " + piratesDisponibles.get(i));
	    }
	    System.out.print("Choisissez un pirate : ");
	    while (!scanner.hasNextInt()) {
	        scanner.next(); // Consommer l'entrée non valide
	        System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
	        System.out.print("Choisissez un pirate : ");
	    }
	    int choix = scanner.nextInt();
	    // Vérifier si le choix est valide
	    while (choix < 1 || choix > piratesDisponibles.size()) {
	        System.out.println("Choix invalide. Veuillez choisir un pirate parmi les options disponibles.");
	        System.out.print("Choisissez un pirate : ");
	        while (!scanner.hasNextInt()) {
	            scanner.next(); // Consommer l'entrée non valide
	            System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
	            System.out.print("Choisissez un pirate : ");
	        }
	        choix = scanner.nextInt();
	    }
	    // Retirer le pirate choisi de la liste des pirates disponibles
	    PirateNom pirateChoisi = piratesDisponibles.remove(choix - 1);
	    return pirateChoisi;
	}
	/**
	 * @brief Permet à l'utilisateur de choisir une couleur parmi les options disponibles.
	 * @return La couleur choisie.
	 *
	 * Affiche une liste des couleurs disponibles et demande à l'utilisateur d'en choisir une.
	 * La sélection est faite via un input numérique correspondant à l'index de la couleur.
	 */


	@Override
	public Couleur choisirCouleur() {
	    System.out.println("Couleurs disponibles : ");
	    for (int i = 0; i < couleursDisponibles.size(); i++) {
	        System.out.println((i + 1) + ". " + couleursDisponibles.get(i));
	    }
	    System.out.print("Choisissez une couleur : ");
	    while (!scanner.hasNextInt()) {
	        scanner.next(); // Consommer l'entrée non valide
	        System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
	        System.out.print("Choisissez une couleur : ");
	    }
	    int choix = scanner.nextInt();
	    // Vérifier si le choix est valide
	    while (choix < 1 || choix > couleursDisponibles.size()) {
	        System.out.println("Choix invalide. Veuillez choisir une couleur parmi les options disponibles.");
	        System.out.print("Choisissez une couleur : ");
	        while (!scanner.hasNextInt()) {
	            scanner.next(); // Consommer l'entrée non valide
	            System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
	            System.out.print("Choisissez une couleur : ");
	        }
	        choix = scanner.nextInt();
	    }
	    // Retirer la couleur choisie de la liste des couleurs disponibles
	    Couleur couleurChoisie = couleursDisponibles.remove(choix - 1);
	    return couleurChoisie;
	}


	@Override
	public void afficherChangementArme(Pirate pirate, Arme nouvelleArme) {
		System.out.println(pirate.getNom() + " trouve " + nouvelleArme.getNom() + " avec une force de "
				+ nouvelleArme.getForce() + " et décide de la prendre.");
	}

	@Override
	public void afficherPlateau(Plateau plateau) {
		// Récupère la collection de cases du plateau
		Collection<Case> cases = plateau.getCases();

		// Parcourt la collection et affiche le contenu de chaque case
		for (Case uneCase : cases) {
			afficherCase(uneCase);
		}
	}

	@Override
	public void afficherMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void afficherPosition(Pirate pirate, Case caseCourante) {
		System.out.println(pirate.getNom() + " est à la case " + pirate.getPosition());
		// Vérifie le type de la case
		if (caseCourante instanceof CaseArme) {
			CaseArme caseArme = (CaseArme) caseCourante;
			System.out.println("Cette case contient une arme : " + caseArme.getArme());
		} else if (caseCourante instanceof CaseRhum) {
			System.out.println("Cette case contient du rhum. Attention à l'ivresse !");
		}
	}

	@Override
	public void afficherDebutTour(Pirate pirate) {
		System.out.println("C'est le tour de " + pirate.getNom() + " [" + pirate.getCouleur()
				+ "]. Il commence son tour sur la case : " + pirate.getPosition() + ".");
	}

	@Override
	public void afficherFinTour(Pirate pirate) {
		System.out.println("Fin du tour pour le pirate : " + pirate.getNom());
	}

	@Override
	public void afficherPirates(Pirate[] pirates,Plateau plateau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affichageDe(Pirate pirate, int lance) {
		afficherMessage("Le pirate " + pirate.getNom() + " à lancé le dé il obtient un " + lance + ".");
		
	}
	

}

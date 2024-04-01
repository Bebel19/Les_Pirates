package affichage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
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
	private Scanner scanner = new Scanner(System.in);
	private List<PirateNom> piratesDisponibles = new ArrayList<>(List.of(PirateNom.values()));
	private List<Couleur> couleursDisponibles = new ArrayList<>(List.of(Couleur.values()));

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

	@Override
	public int demanderNombreJoueurs() {
		int maxJoueurs = Math.min(PirateNom.values().length, Couleur.values().length);
		System.out.print("Combien de joueurs ? (au moins 2 et au maximum " + maxJoueurs + ") ");
		int nombreJoueurs = scanner.nextInt();
		while (nombreJoueurs < 2 || nombreJoueurs > maxJoueurs) {
			System.out.println("Le nombre de joueurs doit être entre 2 et " + maxJoueurs + ". Veuillez réessayer.");
			nombreJoueurs = scanner.nextInt();
		}
		return nombreJoueurs;
	}
	
	@Override
	public PirateNom choisirPirate() {
	    try {
	        System.out.println("Pirates disponibles : ");
	        for (int i = 0; i < piratesDisponibles.size(); i++) {
	            System.out.println((i + 1) + ". " + piratesDisponibles.get(i));
	        }
	        System.out.print("Choisissez un pirate : ");
	        int choix = scanner.nextInt();
	        // Vérifier si le choix est valide
	        while (choix < 1 || choix > piratesDisponibles.size()) {
	            System.out.println("Choix invalide. Veuillez choisir un pirate parmi les options disponibles.");
	            System.out.print("Choisissez un pirate : ");
	            choix = scanner.nextInt();
	        }
	        // Retirer le pirate choisi de la liste des pirates disponibles
	        PirateNom pirateChoisi = piratesDisponibles.remove(choix - 1);
	        return pirateChoisi;
	    } catch (InputMismatchException e) {
	        System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
	        // Vider le scanner pour éviter une boucle infinie
	        scanner.nextLine();
	        return choisirPirate(); // Appel récursif pour redemander à l'utilisateur de saisir un pirate
	    }
	}

	@Override
	public Couleur choisirCouleur() {
	    try {
	        System.out.println("Couleurs disponibles : ");
	        for (int i = 0; i < couleursDisponibles.size(); i++) {
	            System.out.println((i + 1) + ". " + couleursDisponibles.get(i));
	        }
	        System.out.print("Choisissez une couleur : ");
	        int choix = scanner.nextInt();
	        // Vérifier si le choix est valide
	        while (choix < 1 || choix > couleursDisponibles.size()) {
	            System.out.println("Choix invalide. Veuillez choisir une couleur parmi les options disponibles.");
	            System.out.print("Choisissez une couleur : ");
	            choix = scanner.nextInt();
	        }
	        // Retirer la couleur choisie de la liste des couleurs disponibles
	        Couleur couleurChoisie = couleursDisponibles.remove(choix - 1);
	        return couleurChoisie;
	    } catch (InputMismatchException e) {
	        System.out.println("Entrée invalide. Veuillez saisir un nombre entier.");
	        // Vider le scanner pour éviter une boucle infinie
	        scanner.nextLine();
	        return choisirCouleur(); // Appel récursif pour redemander à l'utilisateur de saisir une couleur
	    }
	}



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
	        int numeroCase = uneCase.getNumero();
	        String contenuCase = uneCase.getEffet().toString();
	        System.out.println("Case numéro " + numeroCase + " : " + contenuCase);
	    }
	}

	@Override
	public void afficherMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void afficherPosition(int positionAfficher, Case caseCourante) {
	    System.out.println("Numéro case : " + positionAfficher);
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
		System.out.println("C'est le tour de " + pirate.getNom() + " [" + pirate.getCouleur() + "]. Il commence son tour sur la case : " + pirate.getPosition() + ".");
	}

    @Override
    public void afficherFinTour(Pirate pirate) {
        System.out.println("Fin du tour pour le pirate : " + pirate.getNom());
    }

	


}

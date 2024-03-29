package affichage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entites.Case;
import entites.CaseArme;
import entites.CaseRhum;
import entites.Pirate;
import utils.Arme;
import utils.Couleur;
import utils.Effet;
import utils.PirateNom;

public class AffichageTerminal {
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

	public void afficherPosition(int positionAfficher, Case caseCourante) {
		System.out.println("Numéro case : " + positionAfficher);
		if (caseCourante instanceof CaseArme) {
			afficherArme((CaseArme) caseCourante);
		} else if (caseCourante instanceof CaseRhum) {
			System.out.println("Cette case contient du rhum. Attention à l'ivresse !");
		}
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

	public PirateNom choisirPirate() {
		if (piratesDisponibles.isEmpty()) {
			System.out.println("Il n'y a plus de pirates disponibles.");
			return null;
		}
		System.out.println("Pirates disponibles : ");
		for (int i = 0; i < piratesDisponibles.size(); i++) {
			System.out.println((i + 1) + ". " + piratesDisponibles.get(i));
		}
		System.out.print("Choisissez un pirate : ");
		int choix = scanner.nextInt() - 1;
		PirateNom pirateChoisi = piratesDisponibles.get(choix);
		piratesDisponibles.remove(choix); // Met à jour les pirates disponibles
		return pirateChoisi;
	}

	public Couleur choisirCouleur() {
		if (couleursDisponibles.isEmpty()) {
			System.out.println("Il n'y a plus de couleurs disponibles.");
			return null;
		}
		System.out.println("Couleurs disponibles : ");
		for (int i = 0; i < couleursDisponibles.size(); i++) {
			System.out.println((i + 1) + ". " + couleursDisponibles.get(i).toString());
		}
		System.out.print("Choisissez une couleur : ");
		int choix = scanner.nextInt() - 1;
		Couleur couleurChoisie = couleursDisponibles.get(choix);
		couleursDisponibles.remove(choix); // Met à jour les couleurs disponibles
		return couleurChoisie;
	}

	public void afficherMessage(String message) {
		System.out.println(message);
	}

	public void afficherLanceDe(Pirate pirate, int lance) {
		System.out.println(pirate.getNom() + " lance le dé et avance de " + lance + " cases.");
	}

	public void afficherDebutTour(Pirate pirate) {
		System.out.println("C'est le tour de " + pirate.getNom() + " [" + pirate.getCouleur() + "].");
	}

	public void afficherChangementArme(Pirate pirate, Arme nouvelleArme) {
		System.out.println(pirate.getNom() + " trouve " + nouvelleArme.getNom() + " avec une force de "
				+ nouvelleArme.getForce() + " et décide de la prendre.");
	}

}

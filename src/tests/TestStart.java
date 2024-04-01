package tests;

import affichage.AffichageTerminal;
import entites.Jeu;
import entites.Pirate;
import utils.Couleur;

public class TestStart {
	public static void main(String[] args) {
		AffichageTerminal affichage = new AffichageTerminal();
		Jeu jeu = new Jeu(affichage);

		jeu.start();
	}
}

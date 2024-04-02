package tests;

import affichage.AffichageTerminal;
import utils.Couleur;
import entites.De;
import entites.Jeu;
import entites.Pirate;

public class TestDeplacements {
	public static void main(String[] args) {
		
		AffichageTerminal aff = new AffichageTerminal();
		Jeu jeu = new Jeu(aff);
		
		Pirate franky = new Pirate("Franky", Couleur.ROUGE);
		De de = new De();

		for (int i = 0; i < 60; i++) {
			aff.afficherPosition(franky.getPosition());
			jeu.deplacerPirate(franky, de.lancerDe());
		}

	}
}

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
            int lance = de.lancerDe();
            System.out.println("Lancer du dé : " + lance);
			aff.afficherPosition(franky, null);
			jeu.deplacerPirate(franky, lance);
			aff.afficherPosition(franky, null);
		}

	}
}

package tests;

import affichage.AffichageTerminal;
import utils.Couleur;
import entites.Jeu;
import entites.Pirate;

public class TestDeplacements {
	public static void main(String[] args) {
		
		Jeu jeu = new Jeu();
		AffichageTerminal aff = new AffichageTerminal();
		Pirate franky = new Pirate("Franky", Couleur.ROUGE) ;
		
		
		for (int i = 0; i<60; i++) {
			aff.afficherPosition(franky.getPosition());
			jeu.deplacerPirate(franky, 3);
			}
		
	}
}

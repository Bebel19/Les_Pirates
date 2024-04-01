package tests;

import affichage.AffichageTerminal;
import entites.Jeu;

public class TestStart {
	public static void main(String[] args) {
		
		AffichageTerminal aff = new AffichageTerminal();
		
		Jeu jeu = new Jeu(aff);
		aff.setJeu(jeu);

		jeu.start();
	}
}

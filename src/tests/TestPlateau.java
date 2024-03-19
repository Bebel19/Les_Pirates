package tests;

import entites.Plateau;
import affichage.AffichageTerminal;

public class TestPlateau {
	public static void main(String[] args) {
		
		AffichageTerminal aff = new AffichageTerminal();
		Plateau plateau = new Plateau();
		
		for (int i = 0; i < Plateau.getNbCases(); i ++)
			aff.afficherCase(plateau.getCase(i));
		
	}
}

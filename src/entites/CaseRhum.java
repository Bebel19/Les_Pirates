package entites;

import affichage.AffichageTerminal;
import utils.Effet;

public class CaseRhum extends Case {

	public CaseRhum(int numero) {
		super(numero, Effet.RHUM);
	}

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		De de = new De();
		AffichageTerminal aff = new AffichageTerminal();
		int valRecul =1;
		aff.afficherIvresse(valRecul);
		jeu.deplacerPirate(pirate, -valRecul);
		
	}

}
package entites;

import utils.Effet;

public class CaseWin extends Case {

	public CaseWin(int numero) {
		super(numero, Effet.WIN);
	}

	@Override
	public void appliquerEffet(Pirate pirate, Jeu jeu) {
		jeu.terminerJeu(pirate);
	}
}
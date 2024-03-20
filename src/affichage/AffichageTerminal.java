package affichage;

import entites.Case;

public class AffichageTerminal {
	
	public void afficherCase(Case caseAfficher) {
		if ( caseAfficher != null) {
		System.out.println("NumÃ©ro case = " + caseAfficher.getNumero());
		System.out.println("Effet case = " + caseAfficher.getEffet());
		}
		else 
			System.out.println("La case Ã  afficher est null ");
	}
	public void afficherPosition(int positionAfficher) {
		System.out.println("NumÃ©ro case = " + positionAfficher);
		
	}
	
	public void afficherResultatDe(int resultatDe) {
		
		if (resultatDe >1)
			System.out.println("Le pirate avance de " + resultatDe + " cases.");
		
		else if (resultatDe == 1)
			System.out.println("Le pirate avance de " + resultatDe + " case.");
		
		else if (resultatDe <= 0)
			System.out.println("Le dé renvois une valeur négative ou 0.");
	}
}

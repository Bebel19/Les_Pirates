package affichage;

import entites.Case;

public class AffichageTerminal {
	
	public void afficherCase(Case caseAfficher) {
		if ( caseAfficher != null) {
		System.out.println("Numéro case = " + caseAfficher.getNumero());
		System.out.println("Effet case = " + caseAfficher.getEffet());
		}
		else 
			System.out.println("La case à afficher est null ");
	}

}

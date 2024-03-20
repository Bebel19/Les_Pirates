package affichage;

import entites.Case;
import entites.CaseArme;
import utils.Effet;

public class AffichageTerminal {
	
	public void afficherCase(Case caseAfficher) {
		if (caseAfficher == null)
			System.out.println("La case à afficher est null ");
		else if ( caseAfficher.getEffet() == Effet.ARME) {
			System.out.println("Numéro case = " + caseAfficher.getNumero());
			afficherArme((CaseArme) caseAfficher);
		}
		else if ( caseAfficher.getEffet() == Effet.RHUM) {
			System.out.println("Numéro case = " + caseAfficher.getNumero());
			System.out.println("Sur la case il y � du rhum et un vrai pirate ne dis pas non � du rhum.");
		}

	}
	
	public void afficherArme(CaseArme caseArme) {
		System.out.println("Sur la case il y � " + caseArme.getArme());
	}
	
	public void afficherPosition(int positionAfficher) {
		System.out.println("Numéro case = " + positionAfficher);
		
	}
	
	public void afficherResultatDe(int resultatDe) {
		
		if (resultatDe >1)
			System.out.println("Le pirate avance de " + resultatDe + " cases.");
		
		else if (resultatDe == 1)
			System.out.println("Le pirate avance de " + resultatDe + " case.");
		
		else if (resultatDe <= 0)
			System.out.println("Le d� renvois une valeur n�gative ou 0.");
	}
}

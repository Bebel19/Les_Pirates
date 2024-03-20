package affichage;

import entites.Case;
import entites.CaseArme;
import utils.Effet;

public class AffichageTerminal {
	
	public void afficherCase(Case caseAfficher) {
		if (caseAfficher == null)
			System.out.println("La case Ã  afficher est null ");
		else if ( caseAfficher.getEffet() == Effet.ARME) {
			System.out.println("NumÃ©ro case = " + caseAfficher.getNumero());
			afficherArme((CaseArme) caseAfficher);
		}
		else if ( caseAfficher.getEffet() == Effet.RHUM) {
			System.out.println("NumÃ©ro case = " + caseAfficher.getNumero());
			System.out.println("Sur la case il y à du rhum et un vrai pirate ne dis pas non à du rhum.");
		}

	}
	
	public void afficherArme(CaseArme caseArme) {
		System.out.println("Sur la case il y à " + caseArme.getArme());
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

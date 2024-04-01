package affichage;

import entites.Case;
import entites.Pirate;
import entites.Plateau;
import utils.Couleur;
import utils.PirateNom;

public interface IAffichage {
    void afficherPlateau(Plateau plateau);
    void afficherMessage(String message);
	void afficherPosition(int positionAfficher, Case caseCourante);
	void afficherGagnant(Pirate pirate);
	void afficherDebutTour(Pirate pirate);
	void afficherFinTour(Pirate pirate);
	
    int demanderNombreJoueurs();
    PirateNom choisirPirate();
    Couleur choisirCouleur();
}

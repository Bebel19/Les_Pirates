package affichage;

import entites.Case;
import entites.Pirate;
import entites.Plateau;
import utils.Arme;
import utils.Couleur;
import utils.PirateNom;

public interface IAffichage {
    void afficherPlateau(Plateau plateau);
    void afficherMessage(String message);
	void afficherPosition(int positionAfficher, Case caseCourante);
	void afficherGagnant(Pirate pirate);
	void afficherDebutTour(Pirate pirate);
	void afficherFinTour(Pirate pirate);
	void afficherIvresse(int valRecul);
	void afficherChangementArme(Pirate pirate, Arme nouvelleArme);


	
    int demanderNombreJoueurs();
    PirateNom choisirPirate();
    Couleur choisirCouleur();
}

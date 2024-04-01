package affichage;

import java.util.List;

import entites.Case;
import entites.CaseArme;
import entites.Jeu;
import entites.Pirate;
import utils.Arme;
import utils.Couleur;
import utils.PirateNom;

public interface IAffichage {
    void afficherPlateau();
    void afficherMessage(String message);
    void afficherJoueurs();
    void afficherStart();
	void afficherCase(Case caseAfficher);
	void afficherArme(CaseArme caseArme);
	void afficherResultatDe(int resultatDe);
	void afficherIvresse(int valRecul);
	void afficherGagnant(Pirate gagnant);
	void afficherCaseNormale(int nouvellePosition);
	int demanderNombreJoueurs();
	PirateNom choisirPirate();
	Couleur choisirCouleur();
	void afficherLanceDe(Pirate pirate, int lance);
	void afficherDebutTour(Pirate pirate);
	void afficherChangementArme(Pirate pirate, Arme nouvelleArme);
	void afficherPosition(int nouvellePosition, Case caseCourante);
	void setOnSelectionComplete(SelectionCompleteCallback callback);
	void lancerSelectionJoueurs(SelectionCompleteCallback callback);
	void setJeu(Jeu jeu);
}

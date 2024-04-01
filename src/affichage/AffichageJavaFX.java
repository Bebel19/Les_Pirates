package affichage;

import entites.Case;
import entites.Pirate;
import entites.Plateau;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import utils.Couleur;
import utils.PirateNom;

public class AffichageJavaFX implements IAffichage {

    private GridPane plateauGrid;

    // Constructeur
    public AffichageJavaFX(GridPane plateauGrid) {
        this.plateauGrid = plateauGrid;
    }

    @Override
    public void afficherPlateau(Plateau plateau) {
        // Effacer le plateau existant
        plateauGrid.getChildren().clear();

        // Parcourir le plateau et afficher chaque case
        for (int i = 0; i < plateau.getNbLignes(); i++) {
            for (int j = 0; j < plateau.getNbColonnes(); j++) {
                Case caseCourante = plateau.getCase(i, j);
                Rectangle rectangle = new Rectangle(50, 50); // Taille de la case
                rectangle.setFill(Color.LIGHTGRAY); // Couleur de fond par défaut

                // Définir la couleur de la case en fonction de son état (si nécessaire)
                // rectangle.setFill(...);

                // Ajouter la case à la grille du plateau
                plateauGrid.add(rectangle, j, i);
            }
        }
    }


	@Override
	public void afficherMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherPosition(int positionAfficher, Case caseCourante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherGagnant(Pirate pirate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherDebutTour(Pirate pirate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherFinTour(Pirate pirate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int demanderNombreJoueurs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PirateNom choisirPirate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur choisirCouleur() {
		// TODO Auto-generated method stub
		return null;
	}

    // Les autres méthodes de l'interface IAffichage
}

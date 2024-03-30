package affichage;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VuePirate extends Pane {
    private Circle representation;

    public VuePirate(Color couleur) {
        // Créer une représentation visuelle du pirate, par exemple, un cercle
        representation = new Circle(20, couleur); // Rayon 20, couleur spécifiée
        representation.setStroke(Color.BLACK); // Contour noir pour le cercle
        getChildren().add(representation); // Ajouter le cercle à ce Pane
    }

    // Méthode pour déplacer le pirate sur le plateau
    public void deplacer(int x, int y) {
        representation.setCenterX(x);
        representation.setCenterY(y);
    }
}

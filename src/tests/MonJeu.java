package tests;

import affichage.AffichageJavaFX;
import affichage.IAffichage;
import entites.Jeu;
import javafx.application.Application;
import javafx.stage.Stage;

public class MonJeu extends Application {
    private IAffichage affichage;

    @Override
    public void start(Stage primaryStage) {
		Jeu jeu = new Jeu(2);

		
        this.affichage = new AffichageJavaFX(primaryStage,jeu);
        // Configurez votre sc�ne et vos �l�ments UI ici
        
        // Exemple d'utilisation:
        affichage.afficherStart();
        // Plus de logique pour d�marrer le jeu...
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package tests;

import affichage.AffichageJavaFX;
import entites.Jeu;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestStartJavaFX extends Application {

	@Override
	public void start(Stage primaryStage) {
	    AffichageJavaFX affichage = new AffichageJavaFX(primaryStage);
	    Jeu jeu = new Jeu();
	    affichage.setJeu(jeu);
	    jeu.setAffichage(affichage);
	    // Initialisation supplémentaire au besoin...
	}

    public static void main(String[] args) {
        launch(args);
    }
}

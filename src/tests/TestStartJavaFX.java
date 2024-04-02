package tests;

import affichage.AffichageJavaFX;
import entites.Jeu;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestStartJavaFX extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a grid pane to display the plateau
        GridPane plateauGrid = new GridPane();
        
        AffichageJavaFX affichage = new AffichageJavaFX(plateauGrid);
        Jeu jeu = new Jeu(affichage);

        jeu.start();
    }
}

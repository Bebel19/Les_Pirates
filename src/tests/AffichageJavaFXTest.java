package tests;

import affichage.AffichageJavaFX;
import entites.Pirate;
import entites.Plateau;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.Arme;
import utils.Couleur;
import utils.PirateNom;

public class AffichageJavaFXTest extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a grid pane to display the plateau
        GridPane plateauGrid = new GridPane();

        // Create an instance of AffichageJavaFX
        AffichageJavaFX affichageJavaFX = new AffichageJavaFX(plateauGrid);

        // Create a plateau
        Plateau plateau = new Plateau(); // Assuming a 10x10 plateau

        // Call afficherPlateau to display the plateau
        affichageJavaFX.afficherPlateau(plateau);

        // Create a scene and add the plateauGrid to it
        Scene scene = new Scene(plateauGrid, 600, 600);
        
        // Cr�er un pirate pour tester
        Pirate pirateTest = new Pirate("Jack Sparrow", Couleur.BLANC);
        
        // Set the scene to the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Affichage Plateau");
        primaryStage.show();

        // Display a te st message
        affichageJavaFX.afficherMessage("Ceci est un message de test.");
        
        // Appeler la m�thode afficherDebutTour pour afficher la fen�tre contextuelle du d�but du tour
        affichageJavaFX.afficherDebutTour(pirateTest);

        // Appeler la m�thode afficherFinTour pour afficher la fen�tre contextuelle de fin du tour
        affichageJavaFX.afficherFinTour(pirateTest);
        
        // Appeler la m�thode afficherGagnant pour afficher la fen�tre contextuelle de victoire
        affichageJavaFX.afficherGagnant(pirateTest);
     // Appeler la m�thode demanderNombreJoueurs()
        int nombreJoueurs = affichageJavaFX.demanderNombreJoueurs();
        // Appeler la m�thode choisirPirate()
        
        PirateNom pirateChoisi = affichageJavaFX.choisirPirate();
        
        // Appeler la m�thode choisirCouleur()
        Couleur couleurChoisie = affichageJavaFX.choisirCouleur();
        
        // Afficher l'ivresse du pirate
        affichageJavaFX.afficherIvresse(4);

        // Afficher le changement d'arme du pirate
        affichageJavaFX.afficherChangementArme(pirateTest, Arme.PISTOLET);
    }
}

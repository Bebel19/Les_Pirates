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
        
        // Créer un pirate pour tester
        Pirate pirateTest = new Pirate("Jack Sparrow", Couleur.BLANC);
        
        // Set the scene to the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Affichage Plateau");
        primaryStage.show();

        // Display a te st message
        affichageJavaFX.afficherMessage("Ceci est un message de test.");
        
        // Appeler la méthode afficherDebutTour pour afficher la fenêtre contextuelle du début du tour
        affichageJavaFX.afficherDebutTour(pirateTest);

        // Appeler la méthode afficherFinTour pour afficher la fenêtre contextuelle de fin du tour
        affichageJavaFX.afficherFinTour(pirateTest);
        
        // Appeler la méthode afficherGagnant pour afficher la fenêtre contextuelle de victoire
        affichageJavaFX.afficherGagnant(pirateTest);
     // Appeler la méthode demanderNombreJoueurs()
        int nombreJoueurs = affichageJavaFX.demanderNombreJoueurs();
        // Appeler la méthode choisirPirate()
        
        PirateNom pirateChoisi = affichageJavaFX.choisirPirate();
        
        // Appeler la méthode choisirCouleur()
        Couleur couleurChoisie = affichageJavaFX.choisirCouleur();
        
        // Afficher l'ivresse du pirate
        affichageJavaFX.afficherIvresse(4);

        // Afficher le changement d'arme du pirate
        affichageJavaFX.afficherChangementArme(pirateTest, Arme.PISTOLET);
    }
}

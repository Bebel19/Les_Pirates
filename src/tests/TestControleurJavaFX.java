package tests;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import affichage.AffichageJavaFX;
import controleurs.ControleurJavaFX;
import entites.Jeu;

public class TestControleurJavaFX extends Application {
    
	@Override
	public void start(Stage primaryStage) {
	    GridPane plateauGrid = new GridPane();
	    AffichageJavaFX aff = new AffichageJavaFX(plateauGrid);
	    Jeu jeu = new Jeu(aff);
	    ControleurJavaFX ctrl = new ControleurJavaFX(jeu, aff);

	    Scene scene = new Scene(plateauGrid, 600, 600); // Définissez la taille selon vos besoins
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Le Jeu des Pirates");
	    primaryStage.show();

	    ctrl.demarrerJeu();
	}

    
    public static void main(String[] args) {
        launch(args); // Lance l'application JavaFX
    }
}

package affichage;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import entites.Case;
import entites.CaseArme;
import entites.Jeu;
import entites.Pirate;
import javafx.application.Platform;
import javafx.geometry.Pos;

import javafx.stage.Stage;
import utils.Arme;
import utils.Couleur;
import utils.PirateNom;

public class AffichageJavaFX implements IAffichage {
	private Label messageLabel; // Déclaration du Label pour les messages
	private VBox root;
	private Stage primaryStage;
	private Consumer<List<Pirate>> onSelectionComplete;
	private Jeu jeu;
	private SelectionCompleteCallback selectionCompleteCallback;

	public AffichageJavaFX(Stage primaryStage) {
		// Initialisation du Label pour les messages
		messageLabel = new Label();
		messageLabel.setText("Bienvenue !"); // Texte initial
		this.primaryStage = primaryStage;
		initUI();
	}
	


	@Override
	public void setOnSelectionComplete(SelectionCompleteCallback callback) {
	    this.selectionCompleteCallback = callback;
	}

	
	public void setJeu(Jeu jeu) {
	    this.jeu = jeu;
	}

	private void initUI() {
		root = new VBox(10);
		Scene scene = new Scene(root, 1920, 1080);
		primaryStage.setTitle("La légende Kaizoku : poudre noir et rhum doré");
		primaryStage.setScene(scene);
		primaryStage.show();
		afficherStart();
	}

	@Override
	public void afficherPlateau() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherMessage(String message) {
		// Supposons que vous avez un Label pour les messages dans votre UI
		Platform.runLater(() -> messageLabel.setText(message));
		root.getChildren().add(messageLabel);

	}

	@Override
	public void afficherJoueurs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherStart() {
		ImageView imageView = new ImageView(new Image("file:ressources/images/start.jpg"));
		imageView.setFitHeight(720);
		imageView.setFitWidth(1280);

		Label gameNameLabel = new Label("La légende Kaizoku : poudre noir et rhum doré");
		gameNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 60));
		gameNameLabel.setTextFill(Color.GOLD);

		Button startButton = new Button("Start");
		startButton.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		startButton.setTextFill(Color.WHITE);
		startButton.setStyle("-fx-background-color: #4CAF50;");
		startButton.setPrefHeight(80);
		startButton.setPrefWidth(200);
		startButton.setOnAction(e -> jeu.start());

		root.getChildren().clear();
		root.getChildren().addAll(imageView, gameNameLabel, startButton);
		root.setAlignment(Pos.CENTER);}

	// Méthode pour définir le callback depuis l'extérieur
	public void setOnSelectionComplete(Consumer<List<Pirate>> callback) {
	    this.onSelectionComplete = callback;
	}

	@Override
	public void lancerSelectionJoueurs(SelectionCompleteCallback callback) {
	    Platform.runLater(() -> {
	        Stage stage = new Stage();
	        VBox layout = new VBox(10);
	        layout.setAlignment(Pos.CENTER);

	        List<HBox> lignesPirates = new ArrayList<>();
	        for (PirateNom pirateNom : PirateNom.values()) {
	            HBox lignePirate = new HBox(10);
	            lignePirate.setAlignment(Pos.CENTER_LEFT);

	            Image image = new Image(getClass().getResourceAsStream("/images/" + pirateNom.toString().toLowerCase() + ".png"));
	            ImageView imageView = new ImageView(image);
	            imageView.setFitHeight(50);
	            imageView.setFitWidth(50);

	            ComboBox<Couleur> comboBoxCouleurs = new ComboBox<>();
	            comboBoxCouleurs.getItems().addAll(Couleur.values());

	            CheckBox checkBox = new CheckBox(pirateNom.toString());

	            lignePirate.getChildren().addAll(checkBox, imageView, comboBoxCouleurs);
	            lignesPirates.add(lignePirate);
	        }

	        Button btnValider = new Button("Valider choix");
	        btnValider.setOnAction(event -> {
	            List<Pirate> selectedPirates = // Logique pour récupérer les pirates sélectionnés
	            if (selectionCompleteCallback != null) {
	                selectionCompleteCallback.onSelectionComplete(selectedPirates);
	            }
	            stage.close(); // Fermer la fenêtre après la sélection
	        });

	        layout.getChildren().addAll(lignesPirates);
	        layout.getChildren().add(btnValider);

	        Scene scene = new Scene(layout, 400, 600);
	        stage.setScene(scene);
	        stage.showAndWait();
	    });
	}


	@Override
	public void afficherCase(Case caseAfficher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherArme(CaseArme caseArme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherResultatDe(int resultatDe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherIvresse(int valRecul) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherGagnant(Pirate gagnant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherCaseNormale(int nouvellePosition) {
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

	@Override
	public void afficherLanceDe(Pirate pirate, int lance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherDebutTour(Pirate pirate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherChangementArme(Pirate pirate, Arme nouvelleArme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherPosition(int nouvellePosition, Case caseCourante) {
		// TODO Auto-generated method stub
		
	}









}

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
	private Jeu jeu;

	public AffichageJavaFX(Stage primaryStage, Jeu jeu) {
		// Initialisation du Label pour les messages
		messageLabel = new Label();
		messageLabel.setText("Bienvenue !"); // Texte initial
		this.primaryStage = primaryStage;
		initUI();
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
		startButton.setOnAction(e -> lancerSelectionJoueurs());

		root.getChildren().clear();
		root.getChildren().addAll(imageView, gameNameLabel, startButton);
		root.setAlignment(Pos.CENTER);}

	@Override
	public void lancerSelectionJoueurs() {
	    VBox layout = new VBox(10); // Espace vertical entre les éléments
	    layout.setAlignment(Pos.CENTER); // Centre les éléments dans le VBox
	    
	    // Titre pour la sélection des joueurs
	    Text titre = new Text("Sélection des joueurs");
	    titre.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    layout.getChildren().add(titre);
	    
	    // Pour chaque pirate dans PirateNom, créer une ligne avec son image et un ComboBox pour les couleurs
	    for (PirateNom pirateNom : PirateNom.values()) {
	        
	    	
	    	HBox lignePirate = new HBox(10); // Espace horizontal entre les éléments
	        lignePirate.setAlignment(Pos.CENTER_LEFT);
	        
	        // Charger et afficher l'image du pirate
	        Image image = new Image(getClass().getResourceAsStream("/ressources/images/" + pirateNom.toString().toLowerCase() + ".png"));
	        ImageView imageView = new ImageView(image);
	        imageView.setFitHeight(50); // Hauteur de l'image
	        imageView.setFitWidth(50); // Largeur de l'image
	        
	        // Créer un ComboBox pour les couleurs
	        ComboBox<Couleur> comboBoxCouleurs = new ComboBox<>();
	        comboBoxCouleurs.getItems().addAll(Couleur.values());
	        
	        // Ajouter un CheckBox pour sélectionner le pirate
	        CheckBox checkBox = new CheckBox(pirateNom.toString());
	        
	        lignePirate.getChildren().addAll(checkBox, imageView, comboBoxCouleurs);
	        layout.getChildren().add(lignePirate);
	    }
	    
	    // Bouton pour valider la sélection
	    Button btnValider = new Button("Valider choix");
	    btnValider.setOnAction(event -> {
	        // Ici, vous devriez collecter les informations des sélections,
	        // mettre à jour jeu.pirateListe, jeu.nbJoueurs et ensuite afficher le plateau de jeu.
	    });
	    
	    layout.getChildren().add(btnValider);
	    
	    // Mettre à jour la scène principale avec ce nouveau layout
	    Scene scene = new Scene(layout, 400, 600);
	    primaryStage.setScene(scene);
	    primaryStage.show();
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

}

/**
 * @class AffichageJavaFX
 * @brief Implémentation de l'interface IAffichage utilisant JavaFX pour l'affichage graphique du jeu.
 *
 * Cette classe fournit une implémentation concrète pour afficher le plateau de jeu,
 * les messages, et les interactions utilisateur à travers une interface graphique construite avec JavaFX.
 */


package affichage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entites.Case;
import entites.Pirate;
import entites.Plateau;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import utils.Arme;
import utils.Couleur;
import utils.PirateNom;

public class AffichageJavaFX implements IAffichage {
	
	// Le GridPane de JavaFX utilisé pour afficher le plateau de jeu.
	private GridPane plateauGrid;
	// Liste des noms de pirates déjà choisis par les joueurs.
	private List<PirateNom> piratesDejaChoisis = new ArrayList<>();
	// Liste des couleurs déjà choisies par les joueurs.
	private List<Couleur> couleursDejaChoisies = new ArrayList<>();

	/**
	 * @brief Constructeur pour l'affichage JavaFX.
	 * @param plateauGrid Le GridPane de JavaFX utilisé pour afficher le plateau de jeu.
	 *
	 * Ce constructeur initialise l'affichage JavaFX avec le GridPane donné,
	 * sur lequel le plateau de jeu et d'autres éléments graphiques seront dessinés.
	 */

	public AffichageJavaFX(GridPane plateauGrid) {
		this.plateauGrid = plateauGrid;
	}

	/**
	 * @brief Affiche le plateau de jeu sur l'interface graphique.
	 * @param plateau L'objet Plateau contenant les données du plateau de jeu à afficher.
	 *
	 * Cette méthode dessine le plateau de jeu dans le GridPane, en utilisant différentes couleurs
	 * pour représenter les types de cases. Chaque case est représentée par un Rectangle de JavaFX.
	 */

	@Override
	public void afficherPlateau(Plateau plateau) {
		// Effacer le plateau existant
		plateauGrid.getChildren().clear();

		int nbCases = Plateau.getNbCases();
		int size = 100; // Taille de chaque case

		// Calculate the number of rows and columns based on the total number of cells
		int numRows = (int) Math.ceil(Math.sqrt(nbCases));
		int numCols = (int) Math.ceil((double) nbCases / numRows);

		int row = 0, col = 0;
		int dx = 1, dy = 0;
		int steps = numCols;
		int stepCounter = 0;

		for (int i = 0; i < nbCases; i++) {
			Case caseCourante = plateau.getCase(i); // Get the current case from the plateau

			Rectangle rectangle = new Rectangle(size, size);

			// Fill the rectangle based on the type of the current case
			if (caseCourante == null) {
				rectangle.setFill(Color.GREEN);
			} else {
				switch (caseCourante.getEffet()) {
				case ARME:
					rectangle.setFill(Color.BLUE);
					break;
				case RHUM:
					rectangle.setFill(Color.YELLOW);
					break;
				default:
					rectangle.setFill(Color.LIGHTGRAY);
					break;
				}
			}
			// Add a border to the rectangles
			rectangle.setStroke(Color.BLACK);
			rectangle.setStrokeWidth(1);

			// Add the rectangle to the grid pane
			plateauGrid.add(rectangle, col, row);

			row += dy;
			col += dx;
			stepCounter++;

			// Change direction when reaching the end of steps in one direction
			if (stepCounter == steps) {
				stepCounter = 0;
				int temp = dx;
				dx = -dy;
				dy = temp;
				if (dy == 0) {
					steps--; // Reduce the number of steps after changing direction horizontally
				}
			}
		}
	}
	
	@Override
	
	public void afficherPirates(Pirate[] listePirates) {
	        int nbCases = Plateau.getNbCases();
	        int numRows = (int) Math.ceil(Math.sqrt(nbCases));
	        int numCols = (int) Math.ceil((double) nbCases / numRows);

	        for (Pirate pirate : listePirates) {
	            // Supposons que chaque pirate a une propriété 'position' indiquant sa position linéaire
	            int position = pirate.getPosition(); // Position linéaire 0 à (nbCases-1)
	            int row = position / numCols;
	            int col = position % numCols;
	            
	            Circle pirateCircle = new Circle(10);
	            pirateCircle.setFill(Color.RED); // Assurez-vous de la correspondance
	            GridPane.setConstraints(pirateCircle, col, row);
	        // Ajoutez le cercle au GridPane à la position calculée
	        GridPane.setRowIndex(pirateCircle, row);
	        GridPane.setColumnIndex(pirateCircle, col);
	        plateauGrid.getChildren().add(pirateCircle);
	    }
	}
	
	/**
	 * @brief Affiche un message d'information à l'utilisateur.
	 * @param message Le message à afficher dans une boîte de dialogue.
	 *
	 * Utilise un Alert de type INFORMATION pour montrer le message.
	 */


	@Override
	public void afficherMessage(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@Override
	public void afficherPosition(Pirate pirate, Case caseCourante) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherGagnant(Pirate pirate) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Félicitations !");
		alert.setHeaderText(null);
		alert.setContentText("Le vaillant pirate " + pirate.getNom() + " remporte la partie !");
		alert.showAndWait();
	}

	@Override
	public void afficherDebutTour(Pirate pirate) {
		afficherPopup("Début du tour de " + pirate.getNom(), "Le tour du pirate " + pirate.getNom() + " commence.");
	}

	@Override
	public void afficherFinTour(Pirate pirate) {
		afficherPopup("Fin du tour de " + pirate.getNom(), "Le tour du pirate " + pirate.getNom() + " se termine.");
	}


	/**
	 * @brief Demande à l'utilisateur le nombre de joueurs participant au jeu.
	 * @return Le nombre de joueurs choisi par l'utilisateur.
	 *
	 * Affiche une boîte de dialogue demandant le nombre de joueurs. La méthode valide
	 * l'entrée de l'utilisateur et répète la demande jusqu'à ce qu'un nombre valide soit entré.
	 * Si l'utilisateur annule la boîte de dialogue, l'application se ferme.
	 */

	@Override
	public int demanderNombreJoueurs() {
		int nombreJoueurs = 0;
		int maxJoueurs = Math.min(PirateNom.values().length, Couleur.values().length);
		// Créer une boîte de dialogue pour demander le nombre de joueurs
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Nombre de Joueurs");
		dialog.setHeaderText("Entrez le nombre de joueurs :");
		dialog.setContentText("Nombre de joueurs :");

		// Boucle pour demander le nombre de joueurs jusqu'à ce qu'une valeur valide
		// soit entrée
		boolean valide = false;
		while (!valide) {
			// Afficher la boîte de dialogue et attendre la réponse de l'utilisateur
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				try {
					nombreJoueurs = Integer.parseInt(result.get());
					if (nombreJoueurs >= 2 && nombreJoueurs <= maxJoueurs) {
						valide = true; // La valeur est valide, sortir de la boucle
					} else {
						System.err.println("Erreur : Nombre de joueurs invalide. Veuillez entrer un nombre entre 2 et "
								+ maxJoueurs + ".");
					}
				} catch (NumberFormatException e) {
					System.err.println("Erreur : Entrée invalide pour le nombre de joueurs.");
				}
			} else {
				// Si l'utilisateur annule la boîte de dialogue, fermer l'application
				Platform.exit();
			}
		}

		return nombreJoueurs;
	}
	@Override
	public PirateNom choisirPirate() {
	    // Filtrer les options disponibles pour enlever celles déjà choisies
	    List<PirateNom> optionsDisponibles = new ArrayList<>();
	    for (PirateNom pirate : PirateNom.values()) {
	        if (!piratesDejaChoisis.contains(pirate)) {
	            optionsDisponibles.add(pirate);
	        }
	    }

	    // Créer une boîte de dialogue pour choisir le pirate
	    ChoiceDialog<PirateNom> dialog = new ChoiceDialog<>(optionsDisponibles.get(0), optionsDisponibles);
	    dialog.setTitle("Choix du Pirate");
	    dialog.setHeaderText("Choisissez le pirate :");
	    dialog.setContentText("Pirate :");

	    // Afficher la boîte de dialogue et attendre la réponse de l'utilisateur
	    Optional<PirateNom> result = dialog.showAndWait();
	    if (result.isPresent()) {
	        PirateNom pirateChoisi = result.get();
	        // Mettre à jour la liste des pirates déjà choisis
	        piratesDejaChoisis.add(pirateChoisi);
	        return pirateChoisi;
	    } else {
	        // Si l'utilisateur annule la boîte de dialogue, ne rien faire
	        return null; // Retourner null pour indiquer une annulation
	    }
	}

	
	@Override
	public Couleur choisirCouleur() {
	    // Filtrer les options disponibles pour enlever celles déjà choisies
	    List<Couleur> optionsDisponibles = new ArrayList<>();
	    for (Couleur couleur : Couleur.values()) {
	        if (!couleursDejaChoisies.contains(couleur)) {
	            optionsDisponibles.add(couleur);
	        }
	    }

	    // Créer une liste personnalisée d'options pour le ChoiceDialog
	    List<CouleurOption> couleurOptions = new ArrayList<>();
	    for (Couleur couleur : optionsDisponibles) {
	        couleurOptions.add(new CouleurOption(couleur));
	    }

	    // Créer une boîte de dialogue pour choisir la couleur
	    ChoiceDialog<CouleurOption> dialog = new ChoiceDialog<>(couleurOptions.get(0), couleurOptions);
	    dialog.setTitle("Choix de la Couleur");
	    dialog.setHeaderText("Choisissez une couleur :");
	    dialog.setContentText("Couleur :");

	    // Afficher la boîte de dialogue et attendre la réponse de l'utilisateur
	    Optional<CouleurOption> result = dialog.showAndWait();
	    if (result.isPresent()) {
	        Couleur couleurChoisie = result.get().getCouleur();
	        // Mettre à jour la liste des couleurs déjà choisies si nécessaire
	        couleursDejaChoisies.add(couleurChoisie);
	        return couleurChoisie;
	    } else {
	        // Si l'utilisateur annule la boîte de dialogue, ne rien faire
	        return null;
	    }
	}

	// Classe pour représenter une option de couleur avec un nom convivial
	class CouleurOption {
	    private Couleur couleur;

	    public CouleurOption(Couleur couleur) {
	        this.couleur = couleur;
	    }

	    public Couleur getCouleur() {
	        return couleur;
	    }

	    @Override
	    public String toString() {
	        return couleur.getNom();
	    }
	}
	// Méthode utilitaire pour afficher une popup avec un titre et un message
	private void afficherPopup(String titre, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titre);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	@Override
	public void afficherIvresse(int valRecul) {
	    afficherPopup("Attention à l'ivresse !","Trop de rhum ! Le pirate recule de " + valRecul + " case" + (valRecul > 1 ? "s." : "."));
	}

	@Override
	public void afficherChangementArme(Pirate pirate, Arme nouvelleArme) {
	    afficherPopup("Le pirate trouve une arme",pirate.getNom() + " trouve " + nouvelleArme.getNom() + " avec une force de "
	            + nouvelleArme.getForce() + " et décide de la prendre.");
	}

	@Override
	public void affichageDe(Pirate pirate, int lance) {
		// TODO Auto-generated method stub
		
	}






}

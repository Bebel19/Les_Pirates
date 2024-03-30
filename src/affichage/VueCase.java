package affichage;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VueCase extends StackPane {
    private int numero; // Le num�ro de la case sur le plateau
    private Label label; // Pour afficher du texte ou le num�ro de la case
    private Rectangle fond; // Le fond de la case, utile pour changer de couleur ou de style
    
    // Constructeur
    public VueCase(int numero) {
        this.numero = numero;
        initUI();
    }
    
    // Initialisation de l'interface utilisateur de la case
    private void initUI() {
        fond = new Rectangle(50, 50); // Taille de la case
        fond.setFill(Color.LIGHTGRAY); // Couleur de fond par d�faut
        
        label = new Label(String.valueOf(numero)); // Afficher le num�ro de la case
        this.getChildren().addAll(fond, label);
        
        // Styles et interactions ici
        this.setOnMouseClicked(event -> handleClick()); // G�rer le clic sur la case
    }
    
    // M�thode pour g�rer les clics sur la case
    private void handleClick() {
        // Ici, vous pouvez ajouter ce qui se passe lorsqu'une case est cliqu�e
        // Par exemple, afficher des informations, changer l'�tat, etc.
        System.out.println("Case " + numero + " cliqu�e.");
    }
    
    // M�thodes suppl�mentaires pour changer l'�tat ou l'apparence de la case
    public void setCouleurFond(Color couleur) {
        fond.setFill(couleur);
    }
    
    public void setTexte(String texte) {
        label.setText(texte);
    }
    
    // Ici, vous pouvez ajouter d'autres m�thodes selon les besoins sp�cifiques de votre jeu,
    // comme modifier l'�tat de la case, ajouter des effets sp�ciaux, etc.
}

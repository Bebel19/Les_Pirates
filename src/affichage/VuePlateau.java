package affichage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class VuePlateau extends GridPane {
    private static final int NOMBRE_CASES = 30; // Nombre total de cases sur le plateau
    private VueCase[] cases; // Tableau pour stocker les cases du plateau
    
    // Constructeur
    public VuePlateau() {
        cases = new VueCase[NOMBRE_CASES];
        initUI();
    }
    
    // Initialisation de l'interface utilisateur du plateau
    private void initUI() {
        this.setPadding(new Insets(10)); // Marge int�rieure
        this.setHgap(10); // Espacement horizontal entre les cases
        this.setVgap(10); // Espacement vertical entre les cases
        
        for (int i = 0; i < NOMBRE_CASES; i++) {
            VueCase vc = new VueCase(i + 1); // Cr�er une nouvelle case avec son num�ro
            cases[i] = vc;
            
            // Calculer la position de la case sur le GridPane
            int col = i % 6; // Exemple: 6 cases par ligne
            int row = i / 6; // Changement de ligne apr�s chaque 6 cases
            
            this.add(vc, col, row); // Ajouter la case au GridPane
        }
        
        this.setAlignment(Pos.CENTER); // Centrer le plateau dans son conteneur parent
    }
    
    // M�thodes suppl�mentaires pour manipuler le plateau pourraient �tre ajout�es ici
    // Par exemple, mettre � jour l'�tat du plateau, ajouter des animations, etc.
}

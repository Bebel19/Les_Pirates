package entites;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import utils.Arme;

public class Plateau {
    private static final int NOMBRE_CASES = 30; // le nombre de cases du plateau est fixé à 30
    private Map<Integer, Case> cases; // Utilisation d'une Map pour stocker les cases

    public Plateau() {
    	cases = new HashMap<>();
        // initialisation des cases...
        genererPlateau();
    }

    public static int getNbCases() {
        return NOMBRE_CASES;
    }

    public Case getCase(int numero) {
        // retourner la case correspondant au numéro
    	return cases.get(numero);
    }
    
    public Collection<Case> getCases() {
        return cases.values();
    }
    
    public int calculPosition(int nouvellePosition ) {
    	int destinationFinale;
        // Si la nouvelle position dépasse le nombre de cases sur le plateau,
        // le pirate retourne à la case départ (indice 0 du tableau listeCases)
        if (nouvellePosition > Plateau.getNbCases()) {
            // La case de départ est à l'indice 0
            destinationFinale = nouvellePosition-NOMBRE_CASES;
        } else {
            // Sinon, déplacer le pirate à la nouvelle position
        	destinationFinale = nouvellePosition;
        }
    	
    	return destinationFinale;
    }
    
    private void genererPlateau() {
        Random random = new Random();
        cases.put(0, null); 

        for (int i = 1; i < NOMBRE_CASES - 1; i++) {
            int test = random.nextInt(3) + 1;

            switch (test) {
                case 1:
                    cases.put(i, new CaseRhum(i));
                    break;
                case 2:
                    cases.put(i, new CaseArme(i, Arme.obtenirArmeAleatoire()));
                    break;
                default:
                    cases.put(i, null);
                    break;
            }
        }

        cases.put(NOMBRE_CASES - 1, new CaseWin(NOMBRE_CASES - 1)); // La derni�re case est une case gagnante
    }

    
}

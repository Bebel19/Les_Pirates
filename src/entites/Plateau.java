package entites;

import java.util.Random;

import utils.Arme;
import utils.Effet;

public class Plateau {
    private static final int NOMBRE_CASES = 30; // le nombre de cases du plateau est fixé à 30
    private Case[] listeCases; // tableau pour stocker les cases

    public Plateau() {
        this.listeCases = new Case[NOMBRE_CASES]; // initialisation du tableau des cases
        // initialisation des cases...
        genererPlateau();
    }

    public static int getNbCases() {
        return NOMBRE_CASES;
    }

    public Case getCase(int numero) {
        // retourner la case correspondant au numéro
        return listeCases[numero];
    }
    
    public Case[] getListeCases() {
    	return listeCases;
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
        this.listeCases[0] = null;
        this.listeCases[NOMBRE_CASES - 1] = new CaseWin(NOMBRE_CASES);

        for (int i = 1; i < (NOMBRE_CASES - 1); i++) {
            int test = random.nextInt(3) + 1;

            switch (test) {
                case 1:
                    this.listeCases[i] = new CaseRhum(i + 1);
                    break;
                case 2:
                    this.listeCases[i] = new CaseArme(i + 1,Arme.obtenirArmeAleatoire());
                    break;
                case 3:
                    this.listeCases[i] = null;
                    break;
                default:
                    break;
            }
        }
    }

    
}

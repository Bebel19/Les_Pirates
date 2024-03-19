package entites;

import java.util.Random;

import utils.Effet;

public class Plateau {
    private static final int NOMBRE_CASES = 30; // le nombre de cases du plateau est fixé à 30
    private Case[] listeCases; // tableau pour stocker les cases

    public Plateau() {
        this.listeCases = new Case[NOMBRE_CASES]; // initialisation du tableau des cases
        // initialisation des cases...
        genererPlateau();
    }

    public int getNbCases() {
        return NOMBRE_CASES;
    }

    public Case getCase(int numero) {
        // retourner la case correspondant au numéro
        return listeCases[numero];
    }
    
    private void genererPlateau() {
    	
    	Random random = new Random();
        this.listeCases[0] = new Case(1, Effet.START );
        this.listeCases[NOMBRE_CASES-1] = new Case(30, Effet.WIN );
        
        
        for (int i=1; i< (NOMBRE_CASES-1);i++) {
        	int test = (random.nextInt(3) + 1);
        	
        	switch (test) {
			case 1:
				this.listeCases[i] = new Case(i+1, Effet.RHUM );
				break;
			case 2:
				this.listeCases[i] = new Case(i+1, Effet.ARME );
				break;
			case 3:
				this.listeCases[i] = new Case(i+1, Effet.NEUTRE );
				break;
			default:
				break;
			}
        }
    }
    
}

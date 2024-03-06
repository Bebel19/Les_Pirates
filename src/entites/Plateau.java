package entites;

public class Plateau {
    private static final int NOMBRE_CASES = 30; // le nombre de cases du plateau est fixé à 30
    private Case[] listeCases; // tableau pour stocker les cases

    public Plateau() {
        this.listeCases = new Case[NOMBRE_CASES]; // initialisation du tableau des cases
        // initialisation des cases...
    }

    public int getNbCases() {
        return NOMBRE_CASES;
    }

    public Case getCase(int numero) {
        // retourner la case correspondant au numéro
        return null;
    }
    
    
}

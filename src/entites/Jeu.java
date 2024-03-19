package entites;

import java.util.Random;

public class Jeu {
    private int nbJoueurs;
    private Pirate[] listePirates; // tableau pour stocker les pirates
    private Plateau plateau = new Plateau(); // initialisation du plateau de jeu
    private Random random; // Ajout de l'objet Random

    public Jeu() {
    	
        this.listePirates = new Pirate[nbJoueurs]; // initialisation du tableau des pirates
        this.nbJoueurs = 2;
    }
    public Jeu(int nbJoueurs) {
        this.listePirates = new Pirate[nbJoueurs]; // initialisation du tableau des pirates
        this.nbJoueurs = nbJoueurs;
    }

    public void start() {
        //TODO démarrage du jeu
    }

    public int lanceDe() {
    	
        return (1 + random.nextInt(5));
    }

    public void deplacerPirate(Pirate pirate, int valeurDe) {
        // Calculer la nouvelle position en tenant compte de la position actuelle du pirate
        int nouvellePosition = pirate.getPosition() + valeurDe;
        
        pirate.setPosition(plateau.calculPosition(nouvellePosition));
        
    }



    public void appliquerEffetCase(Case casePlateau) {
        // appliquer l'effet de la case sur le pirate
    }

    
}
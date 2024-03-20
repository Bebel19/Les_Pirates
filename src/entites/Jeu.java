package entites;

import java.util.Random;

import affichage.AffichageTerminal;

public class Jeu {
    private int nbJoueurs;
    private Pirate[] listePirates; // tableau pour stocker les pirates
    private Plateau plateau = new Plateau(); // initialisation du plateau de jeu
    private Random random; // Ajout de l'objet Random
    private De de;
    private AffichageTerminal aff;
    

    public Jeu() {
    	
        this.listePirates = new Pirate[nbJoueurs]; 
        this.nbJoueurs = 2;
        this.de = new De(); 
        this.aff = new AffichageTerminal();
    }
    public Jeu(int nbJoueurs) {
        this.listePirates = new Pirate[nbJoueurs]; 
        this.nbJoueurs = nbJoueurs;
        this.de = new De();
        this.aff = new AffichageTerminal();
    }

    public void start() {
        //TODO démarrage du jeu
    }


    public void deplacerPirate(Pirate pirate) {
    	int valeurDe = de.lancerDe();
    	aff.afficherResultatDe(valeurDe);
        // Calculer la nouvelle position en tenant compte de la position actuelle du pirate
        int nouvellePosition = pirate.getPosition() + valeurDe;
        
        pirate.setPosition(plateau.calculPosition(nouvellePosition));
        
    }



    public void appliquerEffetCase(Case casePlateau) {
        // appliquer l'effet de la case sur le pirate
    }

    
}
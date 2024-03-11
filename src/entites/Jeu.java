package entites;

public class Jeu {
    private int nbJoueurs = 2;
    private Pirate[] listePirates; // tableau pour stocker les pirates
    private Plateau plateau; // le plateau de jeu

    public Jeu() {
        this.listePirates = new Pirate[nbJoueurs]; // initialisation du tableau des pirates
        this.plateau = new Plateau(); // initialisation du plateau de jeu
    }
    public Jeu(int nbJoueurs) {
        this.listePirates = new Pirate[nbJoueurs]; // initialisation du tableau des pirates
        this.plateau = new Plateau(); // initialisation du plateau de jeu
        this.nbJoueurs = nbJoueurs;
    }

    public void start() {
        // démarrage du jeu
    }

    public int lanceDe() {
        // lancer de dé et retourner le résultat
        return 0;
    }

    public void deplacerPirate(Pirate pirate, int valeur) {
        // déplacer le pirate sur le plateau
    }

    public void appliquerEffetCase(Case casePlateau) {
        // appliquer l'effet de la case sur le pirate
    }

    
}
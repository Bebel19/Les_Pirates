package entites;

import utils.Couleur;

public class Pirate {
    private int pv = 5; // points de vie initiaux
    private String nom;
    private Couleur couleur; // Enumération pour les couleurs
    private Case caseActuelle;
    private Arme arme;
    
	public Pirate(String nom, Couleur couleur) {
		this.nom = nom;
		this.couleur = couleur;	
	}
    
    public int getPv() {
        return pv;
    }

    public String getNom() {
        return nom;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Case getCase() {
        return caseActuelle;
    }

    public Arme getArme() {
        return arme;
    }
    
    public void perdrePv(int pvPerdu) {
    	pv -= pvPerdu;
    }
    

}
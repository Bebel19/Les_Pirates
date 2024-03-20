package entites;

import utils.Arme;
import utils.Couleur;

public class Pirate {
    private int pv = 5; // points de vie initiaux
    private String nom;
    private Couleur couleur; // Enumération pour les couleurs
    private int position = 1;
    private Arme arme;
    
	public Pirate(String nom, Couleur couleur) {
		this.nom = nom;
		this.couleur = couleur;	
		this.arme = Arme.POING;
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

    public int getPosition() {
        return position;
    }
    
    public void setPosition(int destination) {
    	position = destination;
    }
    public Arme getArme() {
        return arme;
    }
    
    public void perdrePv(int pvPerdu) {
    	pv -= pvPerdu;
    }
    

}
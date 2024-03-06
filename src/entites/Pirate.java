package entites;

import utils.Couleur;

public class Pirate {
    private int PV = 5; // points de vie initiaux
    private String nom;
    private Couleur couleur; // Enumération pour les couleurs
    private Case caseActuelle;

    public int getPV() {
        return PV;
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
        // retourner l'arme du pirate
        return null;
    }

}
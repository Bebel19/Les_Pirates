package utils;

import java.util.Random;

public enum Arme {
    POING("Poing", 1),
    SABRE("Sabre", 3),
    PISTOLET("Pistolet", 5),
    MOUSQUET("Mousquet", 7);

    private final String nom;
    private final int force;

    // Constructeur privé pour l'énumération
    Arme(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    // Méthode pour obtenir le nom de l'arme
    public String getNom() {
        return nom;
    }

    // Méthode pour obtenir la force de l'arme
    public int getForce() {
        return force;
    }
    
    // Méthode statique pour obtenir une arme aléatoire
    public static Arme obtenirArmeAleatoire() {
        Random random = new Random();
        Arme[] armes = Arme.values();
        return armes[random.nextInt(armes.length)];
    }
}

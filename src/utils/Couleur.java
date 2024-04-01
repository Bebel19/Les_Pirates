package utils;

public enum Couleur {
    ROUGE("\u001B[31m", "ROUGE"),
    BLEU("\u001B[34m", "BLEU"),
    NOIR("\u001B[30m", "NOIR"),
    VERT("\u001B[32m", "VERT"),
    ROSE("\u001B[35m", "ROSE"),
    VIOLET("\u001B[35m", "VIOLET"),
    JAUNE("\u001B[33m", "JAUNE"),
    ORANGE("\u001B[33m", "ORANGE"),
    BLANC("\u001B[37m", "BLANC"),
    GRIS("\u001B[90m", "GRIS");

    private final String code;
    private final String nom;

    Couleur(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return code + nom + "\u001B[0m";
    }
}

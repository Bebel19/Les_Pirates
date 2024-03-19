package entites;

import utils.Effet;

public class Case {
    private int numero;
    private Effet effet; // Enumération pour les effets spéciaux

    public Case(int numero, Effet effet ){
        this.numero = numero;
        this.effet = effet;
    }
    
    public Effet getEffet() {
        // obtenir l'effet de la case
        return effet;
    }

    public int getNumero() {
        // obtenir le numéro de la case
        return numero;
    }

}

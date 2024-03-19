package entites;

import utils.Effet;

public class Case {
    private int numero;
    private Effet effet;

    public Case(int numero, Effet effet ){
        this.numero = numero;
        this.effet = effet;
    }
    
    public Effet getEffet() {
        return effet;
    }

    public int getNumero() {
        return numero;
    }

}

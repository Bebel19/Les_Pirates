package entites;

import utils.Effet;

public class CaseArme extends Case {
    private Arme arme; // Attribut spécifique pour la case Arme

    public CaseArme(int numero, Arme arme) {
        super(numero, Effet.ARME);
        this.arme = arme;
    }

    @Override
    public void appliquerEffet(Pirate pirate) {
        // Logique spécifique pour attribuer l'arme au pirate
    }
    
    public Arme getArme() {
        return arme;
    }
}
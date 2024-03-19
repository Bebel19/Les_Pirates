package entites;

import utils.Effet;

public class CaseRhum extends Case {

    public CaseRhum(int numero) {
        super(numero, Effet.RHUM);
    }

    @Override
    public void appliquerEffet(Pirate pirate) {
        // Logique spécifique pour appliquer l'effet Rhum au pirate
    }
}
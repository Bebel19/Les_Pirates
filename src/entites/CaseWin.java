package entites;

import utils.Effet;

public class CaseWin extends Case {

    public CaseWin(int numero) {
        super(numero, Effet.WIN);
    }

    @Override
    public void appliquerEffet(Pirate pirate) {
        // Logique spécifique pour appliquer l'effet Rhum au pirate
    }
}
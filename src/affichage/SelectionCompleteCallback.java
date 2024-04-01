package affichage;

import entites.Pirate;
import java.util.List;

public interface SelectionCompleteCallback {
    void onSelectionComplete(List<Pirate> selectedPirates);
}

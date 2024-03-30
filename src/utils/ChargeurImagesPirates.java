package utils;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class ChargeurImagesPirates {
    private Map<PirateNom, Image> imagesPirates = new HashMap<>();

    public ChargeurImagesPirates() {
        chargerImagesPirates();
    }

    private void chargerImagesPirates() {
        // Itérer sur toutes les valeurs de l'énumération PiratesNom
        for (PirateNom pirateNom : PirateNom.values()) {
            // Construire le chemin de l'image en convertissant le nom du pirate en minuscules
            String cheminImage = "../images/" + pirateNom.name().toLowerCase() + ".webp";
            
            // Charger l'image et la stocker dans la map
            Image image = new Image(cheminImage);
            imagesPirates.put(pirateNom, image);
        }
    }

    public Image getImagePirate(PirateNom pirateNom) {
        return imagesPirates.get(pirateNom);
    }
}

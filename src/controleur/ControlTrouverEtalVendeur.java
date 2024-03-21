package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlTrouverEtalVendeur {
    private Village village;

    public ControlTrouverEtalVendeur(Village village) {
        this.village = village;
    }

    /**
     * Trouve l'étal occupé par le vendeur donné.
     * @param nomVendeur Le nom du vendeur dont on cherche à trouver l'étal.
     * @return L'étal du vendeur ou null si aucun étal n'est trouvé pour ce vendeur.
     */
    public Etal trouverEtalVendeur(String nomVendeur) {
        return village.trouverEtalVendeur(nomVendeur);
    }
}
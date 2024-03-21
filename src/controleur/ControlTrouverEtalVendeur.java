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
     * Trouve l'�tal occup� par le vendeur donn�.
     * @param nomVendeur Le nom du vendeur dont on cherche � trouver l'�tal.
     * @return L'�tal du vendeur ou null si aucun �tal n'est trouv� pour ce vendeur.
     */
    public Etal trouverEtalVendeur(String nomVendeur) {
        return village.trouverEtalVendeur(nomVendeur);
    }
}
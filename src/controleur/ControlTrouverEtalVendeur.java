package controleur;

import villagegaulois.Village;
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
        // Itère sur tous les étals du village pour trouver celui occupé par le vendeur.
        for (Etal etal : village.getEtals()) {
            if (etal.isEtalOccupe() && etal.getVendeur().getNom().equals(nomVendeur)) {
                return etal;
            }
        }
        // Retourne null si aucun étal correspondant au vendeur n'est trouvé.
        return null;
    }
}

package controleur;

import villagegaulois.Village;
import personnages.Gaulois;


public class ControlPrendreEtal {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;

    public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite, Village village) {
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.village = village;
    }

    public boolean resteEtals() {
        return village.rechercherEtalVide();
    }

    public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
        if (verifierIdentite(nomVendeur) && resteEtals()) {
            // Trouver l'objet Gaulois correspondant au nomVendeur
            Gaulois vendeur = village.trouverHabitant(nomVendeur);
            if (vendeur != null) {
                return village.installerVendeur(vendeur, produit, nbProduit);
            }
        }
        return -1; // Retourne -1 si l'identité n'est pas vérifiée ou s'il n'y a plus d'étals disponibles
    }


    public boolean verifierIdentite(String nomVendeur) {
        return controlVerifierIdentite.verifierIdentite(nomVendeur);
    }
}

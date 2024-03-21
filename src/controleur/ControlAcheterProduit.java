package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
    private Village village;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlVerifierIdentite controlVerifierIdentite;

    public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
                                 ControlTrouverEtalVendeur controlTrouverEtalVendeur,
                                 Village village) {
        this.village = village;
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public boolean verifierIdentite(String nomAcheteur) {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
    }

    public String[] listerVendeursProduit(String produit) {
        return village.rechercherVendeursProduit(produit);
    }

    public String acheterProduit(String nomAcheteur, String nomVendeur, String produit, int quantite) {
        if (!verifierIdentite(nomAcheteur)) {
            return "Je suis d�sol� " + nomAcheteur + " mais il faut �tre un habitant de notre village pour commercer ici.\n";
        }
        
        var etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (etal == null || !etal.getProduit().equals(produit)) {
            return "D�sol�, personne ne vend ce produit au march�.\n";
        }
        
        return etal.acheterProduit(quantite, nomAcheteur);
    }
}

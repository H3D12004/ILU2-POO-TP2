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
            return "Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.";
        }
        
        var etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (etal == null || !etal.getProduit().equals(produit)) {
            return "Désolé, personne ne vend ce produit au marché.";
        }
        
        return etal.acheterProduit(quantite, nomAcheteur);
    }
}

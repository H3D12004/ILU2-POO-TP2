package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

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

    public Gaulois[] listerVendeursProduit(String produit) {
        return village.rechercherVendeursProduit(produit);
    }

    public int acheterProduit(String nomAcheteur, String nomVendeur, int quantite) {
        if (!controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
            System.out.println("Je suis désolée " + nomAcheteur + ", mais il faut être un habitant de notre village pour commercer ici.");
            return 0;
        }

        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (etal == null) {
            System.out.println("Désolé, " + nomVendeur + " ne vend pas de produits sur le marché actuellement.");
            return 0;
        }

        int quantiteAchetee = etal.acheterProduit(quantite, nomVendeur);
        return quantiteAchetee;
    }
}

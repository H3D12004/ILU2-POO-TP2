package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public String[] libererEtal(String nomVendeur) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (etal != null) {
            // Supposons que l'Etal a une méthode pour obtenir ces informations avant de le libérer
            String[] donneesEtal = etal.etatEtal();
            etal.libererEtal(); // Libère l'étal
            return donneesEtal;
        }
        return null; // Retourne null si aucun étal n'est trouvé pour ce vendeur
    }
}

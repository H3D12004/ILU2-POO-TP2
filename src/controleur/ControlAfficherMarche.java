package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
    private Village village;

    public ControlAfficherMarche(Village village) {
        this.village = village;
    }

    public String[] donnerInfosMarche() {
        return village.donnerEtatMarche();
    }
    
    public String afficherMarche() {
        String[] infosMarche = village.donnerEtatMarche();
        
        if (infosMarche == null || infosMarche.length == 0) {
            return "Le marché est actuellement vide.";
        }
        
        StringBuilder marcheStringBuilder = new StringBuilder();
        
        
        for (int i = 0; i < infosMarche.length; i += 3) {
            String nomVendeur = infosMarche[i];
            String produit = infosMarche[i + 2];
            String quantite = infosMarche[i + 1];
            
            marcheStringBuilder.append("Le marchand ").append(nomVendeur)
                                .append(" : ").append(quantite).append(" ")
                                .append(produit) 
                                .append(".\n");
        }
        
        return marcheStringBuilder.toString();
    }
}

package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
    private ControlLibererEtal controlLibererEtal;

    public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
        this.controlLibererEtal = controlLibererEtal;
    }

    public void libererEtal(String nomVendeur) {
        String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
        if (donneesEtal != null) {
            System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".\n");
            System.out.println("Au revoir " + donneesEtal[1] + ", passez une bonne journée.\n");
        } else {
            System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
        }
    }
}

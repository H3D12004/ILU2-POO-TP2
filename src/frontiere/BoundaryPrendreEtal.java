package frontiere;

import java.util.Scanner;
import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
    private ControlPrendreEtal controlPrendreEtal;
    private Scanner scan = new Scanner(System.in);

    public BoundaryPrendreEtal(ControlPrendreEtal controlPrendreEtal) {
        this.controlPrendreEtal = controlPrendreEtal;
    }

    public void prendreEtal(String nomVendeur) {
        System.out.println("Quel produit souhaitez-vous vendre ?\n");
        String produit = scan.nextLine();
        System.out.println("Combien souhaitez-vous en vendre ?\n");
        int nbProduit = scan.nextInt(); 
        scan.nextLine();

        if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
            int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
            if (numeroEtal >= 0) {
                System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + numeroEtal + "\n");
            } else {
                System.out.println("Il n'y a plus d'�tal disponible ou vous n'�tes pas un habitant du village.\n");
            }
        } else {
            System.out.println("Je suis d�sol� " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.\n");
        }
    }
}

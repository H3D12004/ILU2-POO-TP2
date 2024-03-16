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
        System.out.println("Quel produit souhaitez-vous vendre ?");
        String produit = scan.nextLine();
        System.out.println("Combien souhaitez-vous en vendre ?");
        int nbProduit = scan.nextInt(); // Pour éviter le problème avec nextInt suivi de nextLine
        scan.nextLine(); // Consomme la ligne de fin après le nombre

        if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
            int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
            if (numeroEtal >= 0) {
                System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
            } else {
                System.out.println("Il n'y a plus d'étal disponible ou vous n'êtes pas un habitant du village.");
            }
        } else {
            System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
        }
    }
}

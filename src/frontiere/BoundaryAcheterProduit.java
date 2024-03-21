package frontiere;

import java.util.Scanner;
import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
    private Scanner scan = new Scanner(System.in);
    private ControlAcheterProduit controlAcheterProduit;

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        System.out.println("Quel produit voulez-vous acheter ?\n");
        String produit = scan.nextLine();
        Gaulois[] vendeurs = controlAcheterProduit.listerVendeursProduit(produit);

        if (vendeurs.length == 0) {
            System.out.println("Désolé, personne ne vend ce produit au marché.\n");
            return;
        }

        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
        for (int i = 0; i < vendeurs.length; i++) {
            System.out.println((i + 1) + " - " + vendeurs[i]);
        }

        int choixVendeur = scan.nextInt() - 1;
        scan.nextLine();

        System.out.println("Combien de " + produit + " voulez-vous acheter ?\n");
        int quantite = scan.nextInt();
        scan.nextLine();

        int resultat = controlAcheterProduit.acheterProduit(nomAcheteur, vendeurs[choixVendeur], produit, quantite);
        System.out.println(resultat);
    }
}

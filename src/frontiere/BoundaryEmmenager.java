package frontiere;

import java.util.Scanner;
import controleur.ControlEmmenager;

public class BoundaryEmmenager {
    private ControlEmmenager controlEmmenager;
    private Scanner scan = new Scanner(System.in);

    public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
        this.controlEmmenager = controlEmmenager;
    }

    public void emmenager(String nomVisiteur) {
        if (controlEmmenager.isHabitant(nomVisiteur)) {
            System.out.println("Mais vous êtes déjà un habitant du village !\n");
        } else {
            System.out.println("êtes-vous :\n1 - un druide.\n2 - un gaulois.\n");
            int choixUtilisateur = scan.nextInt();
            switch (choixUtilisateur) {
                case 1:
                    emmenagerDruide(nomVisiteur);
                    break;
                case 2:
                    emmenagerGaulois(nomVisiteur);
                    break;
                default:
                    System.out.println("Vous devez choisir le chiffre 1 ou 2 !\n");
                    break;
            }
        }
    }

    private void emmenagerDruide(String nomVisiteur) {
    	int force = -1;
    	System.out.println("Bienvenue druide " + nomVisiteur + "\n");

    	while (force < 0) {
            System.out.println("Quelle est votre force ?\n");
            force = scan.nextInt();
			
		}
    	
    	int effetPotionMin = 1;
    	int effetPotionMax = 0;
    			
    	while (effetPotionMin > effetPotionMax) {
    		System.out.println("Quelle est la force de potion la plus faible que vous produisez ?\n");
            effetPotionMin = scan.nextInt();
            System.out.println("Quelle est la force de potion la plus forte que vous produisez ?\n");
            effetPotionMax = scan.nextInt();			
		}
    	
    	controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
        System.out.println("Le druide " + nomVisiteur + " a emménagé dans le village.\n");
    }

    private void emmenagerGaulois(String nomVisiteur) {
    	
    	int force = -1;
    	System.out.println("Bienvenue villageois " + nomVisiteur + "\n");

    	while (force < 0) {
    		System.out.println("Quelle est votre force ?\n");
    		force = scan.nextInt();
		}
    	
    	controlEmmenager.ajouterGaulois(nomVisiteur, force);
        System.out.println("Le gaulois " + nomVisiteur + " a emménagé dans le village.\n");

    }
}

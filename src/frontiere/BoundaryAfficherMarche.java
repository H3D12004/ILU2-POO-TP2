package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
    private ControlAfficherMarche controlAfficherMarche;

    public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
        this.controlAfficherMarche = controlAfficherMarche;
    }

    public void afficherMarche() {
        System.out.println("Vous trouverez au marché :\n");
        // Directement imprimer la String formatée retournée par controlAfficherMarche.afficherMarche()
        System.out.println(controlAfficherMarche.afficherMarche());
    }
}

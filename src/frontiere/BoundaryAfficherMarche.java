package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
    private ControlAfficherMarche controlAfficherMarche;

    public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
        this.controlAfficherMarche = controlAfficherMarche;
    }

    public void afficherMarche() {
        System.out.println("Vous trouverez au marché :\n");
        System.out.println(controlAfficherMarche.afficherMarche());
    }
}

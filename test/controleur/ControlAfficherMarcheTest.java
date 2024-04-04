package controleur;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
    private Village village;
    private ControlAfficherMarche controlAfficherMarche;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 10, 2);
        controlAfficherMarche = new ControlAfficherMarche(village);
    }

    @Test
    void testAfficherMarche() {
        Gaulois asterix = new Gaulois("Asterix", 5);
        Gaulois obelix = new Gaulois("Obelix", 5);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Poisson", 10);
        village.ajouterHabitant(obelix);
        village.installerVendeur(obelix, "Menhir", 5);

        String[] expected = new String[]{"Asterix", "10", "Poisson", "Obelix", "5", "Menhir"};
        assertArrayEquals(expected, controlAfficherMarche.donnerInfosMarche(), "L'état du marché doit correspondre aux vendeurs installés.");
    }
}

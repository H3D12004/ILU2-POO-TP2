package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
    private Village village;
    private ControlLibererEtal controlLibererEtal;
    private ControlPrendreEtal controlPrendreEtal;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 10, 2);
        ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
        controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
    }

    @Test
    void testLibererEtal() {
        Gaulois asterix = new Gaulois("Asterix", 5);
        village.ajouterHabitant(asterix);
        controlPrendreEtal.prendreEtal("Asterix", "Poisson", 10);

        String[] etalInfos = controlLibererEtal.libererEtal("Asterix");
        assertNotNull(etalInfos, "Les informations de l'étal doivent être retournées après libération.");
        assertEquals("Asterix", etalInfos[1], "Le nom du vendeur doit être Asterix.");

        assertNull(controlLibererEtal.libererEtal("Asterix"), "L'étal doit être déjà libéré, donc retourne null.");
    }
}

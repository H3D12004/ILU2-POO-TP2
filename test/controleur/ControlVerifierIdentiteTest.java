package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 10, 5);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
    }

    @Test
    void testVerifierIdentiteExistant() {
        Gaulois asterix = new Gaulois("Asterix", 5);
        village.ajouterHabitant(asterix);
        assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"), "Asterix devrait être reconnu comme habitant.");
    }

    @Test
    void testVerifierIdentiteInexistant() {
        assertFalse(controlVerifierIdentite.verifierIdentite("Cesar"), "Cesar ne devrait pas être reconnu comme habitant.");
    }
}

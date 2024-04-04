package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
    private Village village;
    private ControlPrendreEtal controlPrendreEtal;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 10, 3);
        controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
    }

    @Test
    void testPrendreEtal() {
        Gaulois asterix = new Gaulois("Asterix", 5);
        village.ajouterHabitant(asterix);
        int etalNum = controlPrendreEtal.prendreEtal("Asterix", "Potion", 10);
        assertTrue(etalNum >= 0, "Asterix devrait réussir à prendre un étal.");

        etalNum = controlPrendreEtal.prendreEtal("Obelix", "Sanglier", 5);
        assertEquals(-1, etalNum, "Obelix ne devrait pas réussir à prendre un étal car il n'est pas un habitant du village.");
    }
}

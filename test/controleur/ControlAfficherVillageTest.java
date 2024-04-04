package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
    private Village village;
    private ControlAfficherVillage controlAfficherVillage;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 5, 5);
        Chef chef = new Chef("Abraracourcix", 10, village);
        village.setChef(chef);
        controlAfficherVillage = new ControlAfficherVillage(village);
    }

    @Test
    void testDonnerNomVillage() {
        assertEquals("Village Gaulois", controlAfficherVillage.donnerNomVillage(), "Le nom du village devrait être Village Gaulois.");
    }

    @Test
    void testDonnerNomsVillageois() {
        // Ajout d'un habitant pour tester
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterGaulois("Asterix", 5);
        String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();
        assertEquals("Abraracourcix", nomsVillageois[0], "Le chef devrait être le premier nom listé.");
        assertEquals("Asterix", nomsVillageois[1], "Asterix devrait être listé comme habitant.");
    }

    @Test
    void testDonnerNbEtals() {
        assertEquals(5, controlAfficherVillage.donnerNbEtals(), "Le nombre d'étals devrait être 5.");
    }
}

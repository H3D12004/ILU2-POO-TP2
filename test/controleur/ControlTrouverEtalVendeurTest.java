package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
    private Village village;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 10, 5);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
    }

    @Test
    void testTrouverEtalVendeurExistant() {
        Gaulois obelix = new Gaulois("Obelix", 5);
        village.ajouterHabitant(obelix);
        village.installerVendeur(obelix, "Menhirs", 10);
        assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Obelix"), "Devrait trouver l'étal d'Obelix.");
    }

    @Test
    void testTrouverEtalVendeurInexistant() {
        assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Intrus"), "Ne devrait pas trouver d'étal pour Intrus.");
    }
}

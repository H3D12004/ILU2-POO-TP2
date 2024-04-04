package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
    private Village village;
    private ControlAcheterProduit controlAcheterProduit;
    private Gaulois asterix;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 10, 2);
        ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
        ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
        
        asterix = new Gaulois("Asterix", 5);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Potion", 10);
    }

    @Test
    void testVerifierIdentite() {
        assertTrue(controlAcheterProduit.verifierIdentite("Asterix"), "Asterix devrait être reconnu comme habitant du village.");
    }

    @Test
    void testListerVendeursProduit() {
        Gaulois[] vendeurs = controlAcheterProduit.listerVendeursProduit("Potion");
        assertEquals(1, vendeurs.length, "Il devrait y avoir un vendeur de Potion.");
        assertEquals("Asterix", vendeurs[0].getNom(), "Le vendeur de Potion devrait être Asterix.");
    }

    @Test
    void testAcheterProduit() {
        int quantiteAchetee = controlAcheterProduit.acheterProduit("Asterix", 5);
        assertEquals(5, quantiteAchetee, "La quantité achetée devrait être égale à la quantité demandée.");

        quantiteAchetee = controlAcheterProduit.acheterProduit("Asterix", 6);
        assertEquals(5, quantiteAchetee, "La quantité achetée ne devrait pas excéder le stock disponible.");

        // Tester avec un vendeur inexistant
        quantiteAchetee = controlAcheterProduit.acheterProduit("Obelix", 1);
        assertEquals(0, quantiteAchetee, "Aucune quantité ne devrait être achetée d'un vendeur inexistant.");
    }
}

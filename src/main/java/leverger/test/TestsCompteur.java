package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import leverger.modele.CompteurFruitEtCorbeau;

public class TestsCompteur {
	
    @Test
    public void la1ereCaseDoitDiminuerDe1() {
    	CompteurFruitEtCorbeau compteurFruitEtCorbeau = new CompteurFruitEtCorbeau();
    	compteurFruitEtCorbeau.decrementerFruit(0);
    	assertEquals(9, compteurFruitEtCorbeau.getCompteur(0));
    	assertEquals(10, compteurFruitEtCorbeau.getCompteur(1));
    	assertEquals(10, compteurFruitEtCorbeau.getCompteur(2));
    	assertEquals(10, compteurFruitEtCorbeau.getCompteur(3));
    	assertEquals(0, compteurFruitEtCorbeau.getCompteur(4));
    }
    
    @Test
    public void la5emeCaseDoitAugmenterDe1() {
    	CompteurFruitEtCorbeau compteurFruitEtCorbeau = new CompteurFruitEtCorbeau();
    	compteurFruitEtCorbeau.incrementerCorbeau();
    	assertEquals(10, compteurFruitEtCorbeau.getCompteur(0));
    	assertEquals(10, compteurFruitEtCorbeau.getCompteur(1));
    	assertEquals(10, compteurFruitEtCorbeau.getCompteur(2));
    	assertEquals(10, compteurFruitEtCorbeau.getCompteur(3));
    	assertEquals(1, compteurFruitEtCorbeau.getCompteur(4));
    }
    
    @Test
    public void doitRetournerFauxCarIlResteDesFruits() {
    	int i;
    	CompteurFruitEtCorbeau compteurFruitEtCorbeau = new CompteurFruitEtCorbeau();
        for (i = 0; i < 10; i++) {
        	compteurFruitEtCorbeau.decrementerFruit(0);
        }
        assertFalse(compteurFruitEtCorbeau.testPlusDeFruits());
    }
    
    @Test
    public void doitRetournerVraiCarIlNeRestePasDeFruit() {
    	int i;
    	int j;
    	CompteurFruitEtCorbeau compteurFruitEtCorbeau = new CompteurFruitEtCorbeau();
    	for (i = 0; i < 4; i++) {
    		for (j = 0; j < 10; j++) {
    			compteurFruitEtCorbeau.decrementerFruit(i);
    		}
    	}
    	assertTrue(compteurFruitEtCorbeau.testPlusDeFruits());
    }
    
    @Test
    public void doitRetournerFauxCarLePuzzleNEstPasRempli() {
    	int i;
    	CompteurFruitEtCorbeau compteurFruitEtCorbeau = new CompteurFruitEtCorbeau();
        for (i = 0; i < 8; i++) {
        	compteurFruitEtCorbeau.incrementerCorbeau();
        }
        assertFalse(compteurFruitEtCorbeau.testPuzzlePlein());
    }
    
    @Test
    public void doitRetournerVraiCarLePuzzleEstRempli() {
    	int i;
    	CompteurFruitEtCorbeau compteurFruitEtCorbeau = new CompteurFruitEtCorbeau();
        for (i = 0; i < 9; i++) {
        	compteurFruitEtCorbeau.incrementerCorbeau();
        }
        assertTrue(compteurFruitEtCorbeau.testPuzzlePlein());
    }

}

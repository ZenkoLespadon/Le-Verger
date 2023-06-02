package leverger.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import leverger.modele.Tour;
public class TestsTour {
	
    @Test
    void compteurDoitEtreEgalA1() {
        Tour tour1 = new Tour();
        assertEquals(1,tour1.getCompteurint());
            }
    

    @Test
    void compteurDoitEtreEgalA2() {
        Tour tour2 = new Tour();
        tour2.incrementer();
        assertEquals(2,tour2.getCompteurint());
    }
    

    @Test
    void compteurDoitEtreEgalA6() {
        Tour tour6 = new Tour();
        int i = 1;
        while(i <= 5){
            i = i+1;
            tour6.incrementer();
        }
        assertEquals(6,tour6.getCompteurint());
    }
}
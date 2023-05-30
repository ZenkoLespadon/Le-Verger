package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import leverger.modèle.Dé;
import leverger.modèle.Face;

class TestsDé {

	@Test
	void testFacesDé() {
		Dé dé = new Dé();
		List<Face> faces = new ArrayList<Face>();
		faces.add(Face.ROUGE);
		faces.add(Face.JAUNE);
		faces.add(Face.BLEUE);
		faces.add(Face.VERTE);
		assertEquals(faces, dé.faces);
		
			}
	 @Test
	 void testLancerDé() {
		 Dé dé = new Dé();
	     //TODO
	    }
}


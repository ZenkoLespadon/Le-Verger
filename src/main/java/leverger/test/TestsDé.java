package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import leverger.contenu.Dé;
import leverger.contenu.Face;

class TestsDé {

	@Test
	void TestFacesDé() {
		Dé dé = new Dé();
		List<Face> faces = new ArrayList<Face>();
		faces.add(Face.ROUGE);
		faces.add(Face.JAUNE);
		faces.add(Face.BLEUE);
		faces.add(Face.VERTE);
		assertEquals(faces, dé.faces);
		
			}
}

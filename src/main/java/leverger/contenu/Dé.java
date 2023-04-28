package leverger.contenu;

import java.util.ArrayList;
import java.util.List;

public class Dé {
	public List<Face> faces = new ArrayList<Face>();

	public Dé() {
		faces = new ArrayList<Face>();
		faces.add(Face.ROUGE);
		faces.add(Face.JAUNE);
		faces.add(Face.BLEUE);
		faces.add(Face.VERTE);
	}
}

package leverger.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Dé {
	public List<Face> faces = new ArrayList<Face>();
	
	public Dé() {
		faces = new ArrayList<Face>();
		faces.add(Face.ROUGE);
		faces.add(Face.JAUNE);
		faces.add(Face.BLEUE);
		faces.add(Face.VERTE);
		faces.add(Face.CORBEAU);
		
	}
	
	 public Face lancerDé(){
	        Random random = new Random();
	        int nbAleatoire = random.nextInt(this.faces.size());
	        return faces.get(nbAleatoire);
	        
	    }

}

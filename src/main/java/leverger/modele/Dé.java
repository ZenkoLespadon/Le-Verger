package leverger.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Dé {
	private List<Face> faces = new ArrayList<>();
	Random random = new Random();
	
	public Dé() {
		faces = new ArrayList<>();
		faces.add(Face.ROUGE);
		faces.add(Face.JAUNE);
		faces.add(Face.BLEUE);
		faces.add(Face.VERTE);
		faces.add(Face.CORBEAU);
		
	}
	
	 public Face lancerDé(){
	        int nbAleatoire = random.nextInt(this.faces.size());
	        return faces.get(nbAleatoire);
	        
	    }
	 
	 public List<Face> getFaces() {
		 return this.faces;
	 }

}

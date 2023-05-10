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
	
	 public Face lancerDé(){
	        int nbMin = 0;
	        int nbMax = this.faces.size();
	        int nbAleatoire = nbMin + (int)(Math.random() * ((nbMax - nbMin)));
	        return faces.get(nbAleatoire);
	        
	    }
	 
	 
	 
	 

}

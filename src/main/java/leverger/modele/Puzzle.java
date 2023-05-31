package leverger.modele;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle {
	ArrayList<Boolean> pieces;
	
	public Puzzle() {
		int i;
		this.pieces = new ArrayList<Boolean>();
		for (i=0; i < 9; i++) {
			this.pieces.add(false);
		}
	}
	
	public void mettrePiece(Integer numero) {
		this.pieces.set(numero, true);
	}
	
	public boolean contientUnePiece(int numero) {
		return this.pieces.get(numero);
	}
	
	public void Piocherpiece() {
		int indicePiece;
		int nbAleatoire = 0;
		boolean disponible = false;
		Random random = new Random();
		
		while (!disponible) {
	        nbAleatoire = random.nextInt(this.pieces.size());
	        disponible = !this.pieces.get(nbAleatoire);
		}
		this.mettrePiece(nbAleatoire);
	}
	
}

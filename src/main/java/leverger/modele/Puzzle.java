package leverger.modele;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle {
	private ArrayList<Boolean> pieces;
	Random random = new Random();
	
	public Puzzle() {
		int i;
		this.pieces = new ArrayList<>();
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
	
	public void piocherPiece() {
		int nbAleatoire = 0;
		boolean disponible = false;
		
		while (!disponible) {
	        nbAleatoire = random.nextInt(this.pieces.size());
	        disponible = !this.pieces.get(nbAleatoire);
		}
		this.mettrePiece(nbAleatoire);
	}
	
}

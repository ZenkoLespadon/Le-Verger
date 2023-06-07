package leverger.modele;

public class CompteurFruitEtCorbeau {
	private int[] compteur = {10, 10, 10, 10, 0};
	
	public CompteurFruitEtCorbeau() {
	}
	
	public int getCompteur(int indice) {
		return this.compteur[indice];
	}
	
	public void decrementerFruit(int numeroFruit) {
		compteur[numeroFruit]--;
	}
	
	public void incrementerCorbeau() {
		compteur[4]++;
	}
	
	public boolean testPlusDeFruits() {
		int i=0;
		boolean victoire = true;
		while ((i < 4) && victoire) {
			if (this.compteur[i] != 0) {
				victoire = false;
			}
			i++;
		}
		return victoire;
	}
	
	public boolean testPuzzlePlein() {
		return this.compteur[4] == 9;
	}
}

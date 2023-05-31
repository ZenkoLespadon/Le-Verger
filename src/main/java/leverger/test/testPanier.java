package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import leverger.modèle.Arbre;
import leverger.modèle.Fruit;
import leverger.modèle.Panier;

public class testPanier {
	
	@Test
	void lePanierDoitEtreVide() {
		Panier panierPrune = new Panier();
		List<Fruit> pommes = new ArrayList<Fruit>();
		int i;
		assertEquals(pommes, panierPrune.fruits);
	}
	
	@Test
	void leFruitDoitEtreAjoute() {
		Panier panierPrune = new Panier();
		List<Fruit> prunes = new ArrayList<Fruit>();
		int i;
		prunes.add(Fruit.PRUNE);
		panierPrune.ajouterFruit(Fruit.PRUNE);
		assertEquals(prunes, panierPrune.fruits);
	}
	
	@Test
	void TroisFruitsDoiventEtreAjoute() {
		Panier panierPoire = new Panier();
		List<Fruit> poires = new ArrayList<Fruit>();
		int i;
		for (i=0; i<3; i++) {
			poires.add(Fruit.CERISE);
		}
		for (i=0; i<3; i++) {
			panierPoire.ajouterFruit(Fruit.CERISE);
		}
		assertEquals(poires, panierPoire.fruits);
	}
}

package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import leverger.modele.Fruit;
import leverger.modele.Panier;

public class TestsPanier {
	
	
	@Test
	void lePanierDoitEtreVide() {
		Panier panierPrune = new Panier();
		List<Fruit> pommes = new ArrayList<>();
		assertEquals(pommes, panierPrune.getFruits());
	}
	
	@Test
	void leFruitDoitEtreAjoute() {
		Panier panierPrune = new Panier();
		List<Fruit> prunes = new ArrayList<>();
		prunes.add(Fruit.PRUNE);
		panierPrune.ajouterFruit(Fruit.PRUNE);
		assertEquals(prunes, panierPrune.getFruits());
	}
	
	@Test
	void troisFruitsDoiventEtreAjoute() {
		Panier panierPoire = new Panier();
		List<Fruit> poires = new ArrayList<>();
		int i;
		for (i=0; i<3; i++) {
			poires.add(Fruit.CERISE);
		}
		for (i=0; i<3; i++) {
			panierPoire.ajouterFruit(Fruit.CERISE);
		}
		assertEquals(poires, panierPoire.getFruits());
	}
}

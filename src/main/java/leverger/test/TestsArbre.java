package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import leverger.modèle.Arbre;
import leverger.modèle.Fruit;


class TestsArbre {
	
	@Test
	void assertVrai() {
		Assertions.assertTrue(true);
	}
	
	@Test
	void creerFruit() {
		Fruit prune = Fruit.PRUNE;
	}

	@Test
	void lePommierDoitAvoir10Fruits() {
		Fruit pomme = Fruit.POMME;
		Arbre pommier = new Arbre(pomme);
		List<Fruit> pommes = new ArrayList<Fruit>();
		int i;
		for (i=0; i<10; i++) {
			pommes.add(pomme);
		}
		assertEquals(pommes, pommier.fruits);
	}
	
	@Test
	void leFruitDoitEtreRetirerdeLaListe() {
		Arbre cerisier = new Arbre(Fruit.CERISE);
		List<Fruit> cerises = new ArrayList<Fruit>();
		int i;
		for (i=0; i<9; i++) {
			cerises.add(Fruit.CERISE);
		}
		cerisier.enleverFruit(Fruit.CERISE);
		assertEquals(cerises, cerisier.fruits);
		
	}
	
}
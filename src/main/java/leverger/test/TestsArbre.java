package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import leverger.modele.Arbre;
import leverger.modele.Fruit;


class TestsArbre {

	@Test
	void lePommierDoitAvoir10Pommes() {
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
	void leFruitDoitEtreRetire() {
		Arbre cerisier = new Arbre(Fruit.CERISE);
		List<Fruit> cerises = new ArrayList<Fruit>();
		int i;
		for (i=0; i<9; i++) {
			cerises.add(Fruit.CERISE);
		}
		cerisier.enleverFruit(Fruit.CERISE);
		assertEquals(cerises, cerisier.fruits);
	}
	
	@Test
	void QuatreFruitsDoiventEtreRetire() {
		Arbre cerisier = new Arbre(Fruit.CERISE);
		List<Fruit> cerises = new ArrayList<Fruit>();
		int i;
		for (i=0; i<6; i++) {
			cerises.add(Fruit.CERISE);
		}
		for (i=0; i<4; i++) {
			cerisier.enleverFruit(Fruit.CERISE);
		}
		assertEquals(cerises, cerisier.fruits);
	}
	
}
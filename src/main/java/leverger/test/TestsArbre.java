package leverger.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import leverger.contenu.Arbre;
import leverger.contenu.Fruit;

class TestsArbre {

	@Test
	void LePommierDoitAvoir10Fruits() {
		Fruit pomme = Fruit.POMME;
		Arbre pommier = new Arbre(pomme);
		List<Fruit> pommes = new ArrayList<Fruit>();
		int i;
		for (i=0; i<10; i++) {
			pommes.add(pomme);
		}
		assertEquals(pommes, pommier.fruits);
	}
}
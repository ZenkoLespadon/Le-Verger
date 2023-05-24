package leverger.contenu;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Arbre  {
	public List<Fruit> fruits;
	public Image image;
	
	public Arbre(Fruit fruit) {
		this.fruits = new ArrayList<Fruit>();
		int i;
		for (i=0; i<10; i++) {
			fruits.add(fruit);
		}
		this.image = new Image("file:img/Arbre.png");
	}
	
	public Fruit getFruit() {
		return this.fruits.get(0);
	}
	
	public int getNbFruit() {
		return this.fruits.size();
	}
	
	
}

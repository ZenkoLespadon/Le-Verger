package leverger.modèle;

import java.util.ArrayList;

import java.util.List;

import javafx.scene.image.Image;

public class Arbre  {
	public ArrayList<Fruit> fruits;
	public Image image;
	
	public Arbre(Fruit fruit) {
		this.fruits = new ArrayList<Fruit>();
		int i;
		for (i=0; i<10; i++) {
			this.fruits.add(fruit);
		}
		this.image = new Image("file:img/Arbre.png");
	}
	
	public Fruit getFruit() {
		return this.fruits.get(0);
	}
	
	public int getNbFruit() {
		return this.fruits.size();
	}
	
	public ArrayList<Fruit> getFruits(){
		return this.fruits;
	}
	
	public void enleverFruit(Fruit fruit) {
		this.fruits.remove(fruit);
	}
	
}

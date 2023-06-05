package leverger.modele;

import java.util.ArrayList;
import java.util.List;

public class Arbre  {
	private ArrayList<Fruit> fruits;
	
	public Arbre(Fruit fruit) {
		this.fruits = new ArrayList<>();
		int i;
		for (i=0; i<10; i++) {
			this.fruits.add(fruit);
		}
	}
	
	public Fruit getFruit() {
		return this.fruits.get(0);
	}
	
	public int getNbFruit() {
		return this.fruits.size();
	}
	
	public List<Fruit> getFruits(){
		return this.fruits;
	}
	
	public void enleverFruit(Fruit fruit) {
		this.fruits.remove(fruit);
	}

}

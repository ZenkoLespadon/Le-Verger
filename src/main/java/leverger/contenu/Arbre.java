package leverger.contenu;

import java.util.ArrayList;
import java.util.List;

public class Arbre  {
	public List<Fruit> fruits = new ArrayList<Fruit>();
	
	public Arbre(Fruit fruit) {
		fruits = new ArrayList<Fruit>();
		int i;
		for (i=0; i<10; i++) {
			fruits.add(fruit);
		}
	}
}

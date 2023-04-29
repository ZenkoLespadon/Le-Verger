package leverger.contenu;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Arbre  {
	public List<Fruit> fruits;
	public Image image;
	
	public Arbre(Fruit fruit) {
		fruits = new ArrayList<Fruit>();
		int i;
		for (i=0; i<10; i++) {
			fruits.add(fruit);
		}
		image = new Image("file:img/Arbre.png");
	}
}

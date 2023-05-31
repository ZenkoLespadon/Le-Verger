package leverger.modèle;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Panier {
    public ArrayList<Fruit> fruits;


    public Panier() {
        this.fruits = new ArrayList<Fruit>();
        }
    
    public void ajouterFruit(Fruit fruit) {
    	this.fruits.add(fruit);
    }
    
    public Fruit getFruit(int position) {
    	return this.fruits.get(position);
    }

} 

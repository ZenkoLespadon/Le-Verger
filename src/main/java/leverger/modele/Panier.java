package leverger.modele;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private ArrayList<Fruit> fruits;


    public Panier() {
        this.fruits = new ArrayList<>();
        }
    
    public List<Fruit> getFruits(){
    	return this.fruits;
    }
    
    public void ajouterFruit(Fruit fruit) {
    	this.fruits.add(fruit);
    }
    
    public Fruit getFruit(int position) {
    	return this.fruits.get(position);
    }
    
    public int getTaille() {
    	return this.fruits.size();
    	}
} 

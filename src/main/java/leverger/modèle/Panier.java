package leverger.modèle;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Panier {
    public ArrayList<Fruit> fruits;
    public Image haut;
    public Image bas;


    public Panier() {
        this.fruits = new ArrayList<Fruit>();
        this.haut = new Image("file:img/HautDuPanier.png");
        this.bas = new Image("file:img/BasDuPanier.png");
        }
    
    public void ajouterFruit(Fruit fruit) {
    	this.fruits.add(fruit);
    }

} 

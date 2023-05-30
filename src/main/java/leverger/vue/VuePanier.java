package leverger.vue;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import leverger.modèle.Fruit;
import leverger.modèle.Panier;

public class VuePanier {
	
	public Panier panier;
	public StackPane conteneur;
	
    public VuePanier(Panier panier) {
    	this.panier = panier;
        this.conteneur = new StackPane();
        genererVue();
    }
    
    public StackPane getConteneur() {
    	return this.conteneur;
    }
    
    public void genererVue() {
		
    	ImageView vueHautDuPanier = new ImageView(panier.haut);
    	vueHautDuPanier.setFitWidth(375);
    	vueHautDuPanier.setFitHeight(400);

    	ImageView vueBasDuPanier = new ImageView(panier.bas);
    	vueBasDuPanier.setFitWidth(375);
    	vueBasDuPanier.setFitHeight(400);
    	
		int i;
		int j=0;
		int k=0;
	
		GridPane mesFruits = new GridPane();
		mesFruits.setPadding(new Insets (60,0,0,75));
	
	
        this.conteneur.getChildren().add(vueHautDuPanier);
        
        ajouterFruit(panier.fruits);
        this.conteneur.getChildren().add(vueBasDuPanier);

		this.conteneur.getChildren().add(mesFruits);
	}
    
    public void ajouterFruit(ArrayList<Fruit> fruits){
    	int nbFruit = fruits.size();
    	GridPane gridFruits1 = new GridPane();
    	GridPane gridFruits2 = new GridPane();
    	
    	int k = 0;
            
    	for (int i = 0; i < 5; i++) {
    		k++;
    		if (k > nbFruit) {
    			break;
    		}
    		ImageView vueFruit = new ImageView(fruits.get(0).image);
            vueFruit.setFitWidth(47);
            vueFruit.setFitHeight(47);
    		gridFruits1.add(vueFruit, i, 0);
        }
    	gridFruits1.setPadding(new Insets(170, 0, 0, 80));
    	
    	for (int j = 0; j < 5 && k < nbFruit; j++) {
    		k++;
    		ImageView vueFruit = new ImageView(fruits.get(10-k).image);
            vueFruit.setFitWidth(47);
            vueFruit.setFitHeight(47);
    		gridFruits2.add(vueFruit, j, 0);
        }
    	gridFruits2.setPadding(new Insets(170, 0, 0, 105));
    	this.conteneur.getChildren().add(gridFruits1);
    	this.conteneur.getChildren().add(gridFruits2);
    }
	
}

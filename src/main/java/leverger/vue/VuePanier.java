package leverger.vue;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import leverger.modele.Fruit;
import leverger.modele.Panier;

public class VuePanier {
	
	public Panier panier;
	public StackPane conteneur;
	public VueFruit vueFruit;
	public Image imageDuHaut;
	public Image imageDuBas;
	
    public VuePanier(Panier panier, VueFruit vueFruit) {
    	this.panier = panier;
        this.imageDuHaut = new Image("file:img/HautDuPanier.png");
        this.imageDuBas = new Image("file:img/BasDuPanier.png");
        this.conteneur = new StackPane();
        this.vueFruit = vueFruit;
        genererVue();
    }
    
    public StackPane getConteneur() {

    	return this.conteneur;
    }
    
    public void genererVue() {
    	
    	
		int i;
		int j=0;
		int k=0;
	
		GridPane mesFruits = new GridPane();
		mesFruits.setPadding(new Insets (60,0,0,75));
	
	    ImageView vueHautDuPanier = new ImageView(this.imageDuHaut);
	    vueHautDuPanier.setFitWidth(375);
	    vueHautDuPanier.setFitHeight(400);

	    ImageView vueBasDuPanier = new ImageView(this.imageDuBas);
	    vueBasDuPanier.setFitWidth(375);
	    vueBasDuPanier.setFitHeight(400);

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
    		ImageView imageVueFruit = vueFruit.genererVue();
    		imageVueFruit.setFitWidth(47);
    		imageVueFruit.setFitHeight(47);
    		gridFruits1.add(imageVueFruit, i, 0);
        }
    	gridFruits1.setPadding(new Insets(170, 0, 0, 80));
    	
    	for (int j = 0; j < 5 && k < nbFruit; j++) {
    		k++;
    		ImageView imageVueFruit = vueFruit.genererVue();;
    		imageVueFruit.setFitWidth(47);
    		imageVueFruit.setFitHeight(47);
    		gridFruits2.add(imageVueFruit, j, 0);
        }
    	gridFruits2.setPadding(new Insets(170, 0, 0, 105));
    	this.conteneur.getChildren().add(gridFruits1);
    	this.conteneur.getChildren().add(gridFruits2);
    }
	
}

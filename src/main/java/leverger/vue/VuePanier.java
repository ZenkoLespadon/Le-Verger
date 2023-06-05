package leverger.vue;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import leverger.modele.Fruit;
import leverger.modele.Panier;

public class VuePanier {
	
	private Panier panier;
	private StackPane conteneur;
	private VueFruit vueFruit;
	private Image imageDuHaut;
	private Image imageDuBas;
	
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
    
    public Panier getPanier() {
    	return this.panier;
    }
    
    public void genererVue() {
	
		GridPane mesFruits = new GridPane();
		mesFruits.setPadding(new Insets (60,0,0,0));
	
	    ImageView vueHautDuPanier = new ImageView(this.imageDuHaut);
	    vueHautDuPanier.setFitWidth(375);
	    vueHautDuPanier.setFitHeight(400);

	    ImageView vueBasDuPanier = new ImageView(this.imageDuBas);
	    vueBasDuPanier.setFitWidth(375);
	    vueBasDuPanier.setFitHeight(400);

	    this.conteneur.getChildren().add(vueHautDuPanier);
	    
	    ajouterFruit(panier.getFruits());
	    
	    this.conteneur.getChildren().add(vueBasDuPanier);

		this.conteneur.getChildren().add(mesFruits);
	}
    
    public void ajouterFruit(List<Fruit> fruits){
    	int i;
    	int nbFruit = fruits.size();
    	
    	GridPane gridFruits = new GridPane();
    	gridFruits.setPadding(new Insets(170, 0, 0, 60));
    	for (i=0; i < nbFruit; i++) {
    		ImageView imageVueFruit = vueFruit.genererVue();
    		imageVueFruit.setFitWidth(47);
    		imageVueFruit.setFitHeight(47);
    		GridPane.setMargin(imageVueFruit, new Insets(0, -25, 0, 0));
    		gridFruits.add(imageVueFruit, i, 0);
    	}
    	
    	this.conteneur.getChildren().add(gridFruits);
    	
    	
    }
	
}

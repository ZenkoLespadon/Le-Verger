package leverger.vue;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import leverger.modele.Panier;

public class VuePanier {
	
	private Panier panier;
	private StackPane conteneur;
	private VueFruit vueFruit;
	private Image imageDuHaut;
	private Image imageDuBas;
	private GridPane gridFruits;
	
    public VuePanier(Panier panier, VueFruit vueFruit) {
    	this.panier = panier;
        this.imageDuHaut = new Image("file:img/HautDuPanier.png");
        this.imageDuBas = new Image("file:img/BasDuPanier.png");
        this.conteneur = new StackPane();
        this.gridFruits = new GridPane();
        this.vueFruit = vueFruit;
        genererVue();
    }
    
    public StackPane getConteneur() {
    	return this.conteneur;
    }
    
    public Panier getPanier() {
    	return this.panier;
    }
    
    public VueFruit getVueFruit() {
    	return this.vueFruit;
    }
    
    public void genererVue() {
	
	    ImageView vueHautDuPanier = new ImageView(this.imageDuHaut);
	    vueHautDuPanier.setFitWidth(375);
	    vueHautDuPanier.setFitHeight(400);

	    ImageView vueBasDuPanier = new ImageView(this.imageDuBas);
	    vueBasDuPanier.setFitWidth(375);
	    vueBasDuPanier.setFitHeight(400);

	    this.conteneur.getChildren().add(vueHautDuPanier);
	    
	    this.conteneur.getChildren().add(gridFruits);
	    
	    this.conteneur.getChildren().add(vueBasDuPanier);
	    
	    
	    this.gridFruits.setPadding(new Insets(170, 0, 0, 60));
	    
	}
    
    public void ajouterFruit(VueFruit vueFruit){
    	int indiceFruit = this.panier.getFruits().size();
		ImageView imageVueFruit = vueFruit.genererVue();
		imageVueFruit.setFitWidth(47);
		imageVueFruit.setFitHeight(47);
		GridPane.setMargin(imageVueFruit, new Insets(0, -25, 0, 0));
		this.gridFruits.add(imageVueFruit, indiceFruit, 0);
    }
}

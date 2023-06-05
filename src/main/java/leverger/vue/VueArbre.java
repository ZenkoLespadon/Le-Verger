package leverger.vue;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import leverger.modele.Arbre;

public class VueArbre{
	
	private Arbre arbre;
	private Image image;
	private StackPane conteneur;
	private VueFruit vueFruit;

    public VueArbre(Arbre arbre, VueFruit vueFruit) {
    	this.arbre = arbre;
    	this.image = new Image("file:img/Arbre.png");
        this.conteneur = new StackPane();
        this.vueFruit = vueFruit;
        
        genererVue();
    }
	
    public StackPane getConteneur() {
    	return this.conteneur;
    }
    
    public Arbre getArbre() {
    	return this.arbre;
    }
    
	public void genererVue() {
		
		int nbFruit = this.arbre.getNbFruit();
		
		ImageView imageview = new ImageView(this.image);
		imageview.setFitWidth(400);
		imageview.setFitHeight(425);
		
		int i;
		int j=0;
		int k=0;
	
		this.conteneur.getChildren().add(imageview);
	
		GridPane mesFruits = new GridPane();
		mesFruits.setPadding(new Insets (60,0,0,75));
		
		
	
	
		for (i = 0; i < nbFruit; i++) {
			if (i == 5) {
				k++;
				j=0;
			}
			
			ImageView imageVueFruit = vueFruit.genererVue();
			imageVueFruit.setFitWidth(50);
			imageVueFruit.setFitHeight(50);
			mesFruits.add(imageVueFruit, j, k);
			j++;
		}

		this.conteneur.getChildren().add(mesFruits);
	}
}

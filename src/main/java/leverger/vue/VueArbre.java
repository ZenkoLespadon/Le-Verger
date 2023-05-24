package leverger.vue;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import leverger.contenu.Arbre;

public class VueArbre{
	
	public Arbre arbre;
	public StackPane conteneur;

    public VueArbre(Arbre arbre) {
    	this.arbre = arbre;
        this.conteneur = new StackPane();
        genererVue(10);
    }
	
	public void genererVue(int nbFruit) {
		
		ImageView vueArbre = new ImageView(this.arbre.image);
		vueArbre.setFitWidth(400);
		vueArbre.setFitHeight(425);
		
		int i;
		int j=0;
		int k=0;
	
		this.conteneur.getChildren().add(vueArbre);
	
		GridPane mesFruits = new GridPane();
		mesFruits.setPadding(new Insets (60,0,0,75));
	
	
		for (i = 0; i < nbFruit; i++) {
			if (i == 5) {
				k++;
				j=0;
			}
			ImageView vueFruit = new ImageView(this.arbre.fruits.get(0).image);
			vueFruit.setFitWidth(50);
			vueFruit.setFitHeight(50);
			mesFruits.add(vueFruit, j, k);
			j++;
		}

		this.conteneur.getChildren().add(mesFruits);
	}
}

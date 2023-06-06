package leverger.controleur;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import leverger.modele.CompteurFruitEtCorbeau;
import leverger.modele.Fruit;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VuePanier;
import leverger.vue.VueTour;

public class ControleurFruit {
	VueArbre vueArbre;
	VuePanier vuePanier;
	VueDé vueDé;
	ImageView imageVueFruit;
	CompteurFruitEtCorbeau compteurFruitEtCorbeau;
	StackPane root;
	VueTour vueTour;
    
    public ControleurFruit(VueArbre vueArbre, VuePanier vuePanier, VueDé vueDé, ImageView imageVueFruit, CompteurFruitEtCorbeau compteurFruitEtCorbeau, StackPane root, VueTour vueTour) {
    	this.vueArbre = vueArbre;
    	this.vuePanier = vuePanier;
    	this.imageVueFruit = imageVueFruit;
    	this.vueDé = vueDé;
    	this.compteurFruitEtCorbeau = compteurFruitEtCorbeau;
    	this.root = root;
    	this.vueTour = vueTour;
    }
    
    
    public void initialiserEventHandler() {
        imageVueFruit.setOnMouseClicked(event -> {
            bougerFruit();
        });
    }
    
	private void bougerFruit() {
		Fruit fruit = vueArbre.getArbre().getFruit();
		if (this.vueArbre.getNbFruitCliquable() > 0) {
			bougerFruits(fruit);
			this.vueArbre.decrementerNbFruitCliquable();
		} else if (this.vueDé.getNbFruitPanier() > 0){
			bougerFruits(fruit);
			this.vueDé.decrementerNbFruitPanier();
		}
		
		
	}

	private void bougerFruits(Fruit fruit) {
		int indiceFruit = -1;
	    switch (fruit.getNom()) {
        case "Cerise":
            indiceFruit = 0;
            break;
        case "Poire":
            indiceFruit = 1;
            break;
        case "Prune":
            indiceFruit = 2;
            break;
        case "Pomme":
            indiceFruit = 3;
            break;
	    }
	    
	    if (indiceFruit != -1) {
	        compteurFruitEtCorbeau.decrementerFruit(indiceFruit);
	    }
	    
		vueArbre.getArbre().enleverFruit(fruit);
		vueArbre.enleverFruit();
		vuePanier.ajouterFruit(vuePanier.getVueFruit());
		vuePanier.getPanier().ajouterFruit(fruit);
		
		if (this.compteurFruitEtCorbeau.testPlusDeFruits()) {
			messageVictoire("Vous avez gagné en ", root, vueTour, vueDé);
		}
		
	}
	
	private void messageVictoire(String debutLabel, StackPane root, VueTour vueTour, VueDé vueDé) {
		Label compteur = new Label(debutLabel + vueTour.getCompteur() + " tours");
		vueDé.getPaneDé().setVisible(false);
		vueTour.cacherCompteur();
		compteur.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;"); 
		root.getChildren().add(compteur);
	}
}

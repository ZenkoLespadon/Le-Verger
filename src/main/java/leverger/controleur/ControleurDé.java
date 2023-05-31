package leverger.controleur;

import java.util.Arrays;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import leverger.modèle.Face;
import leverger.modèle.Fruit;
import leverger.vue.VueTour;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VuePanier;

public class ControleurDé {
	public VueDé vueDé;
	public VueTour vueTour;
	int[] nbFruits = {10, 10, 10, 10};
	public StackPane root;
	public List<VueArbre> vuesArbre;
	public List<VuePanier> vuesPanier;
	
	public ControleurDé(StackPane root, VueDé vueDé, VueTour vueTour, List<VueArbre> vuesArbre, List<VuePanier> vuesPanier){
		this.vueDé = vueDé;
		this.vueTour = vueTour;
		this.root = root;
		this.vuesArbre = vuesArbre;
		this.vuesPanier = vuesPanier;
	}
	
	public void initialiserEventHandler() {
		vueDé.paneDé.setOnMouseClicked(click -> {
			Face faceTiree = vueDé.dé.lancerDé();
			vueDé.setCouleurDuCercle(faceTiree.couleur);
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(250), attente -> {
		        int[] nbFruitsVide = {0, 0, 0, 0};
		        vueTour.incrementerTour();
			    switch(faceTiree.nom) {
			        case "Rouge": 
			        	if (nbFruits[0] > 0) {
			        		nbFruits[0]--;
			        		bougerFruits(vuesArbre.get(0), vuesPanier.get(0));
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, vueTour, vueDé);
				    		}
			        	}
			            break;
			        case "Jaune": 
			        	if (nbFruits[1] > 0) {
			        		nbFruits[1]--;
			        		bougerFruits(vuesArbre.get(1), vuesPanier.get(1));
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, vueTour, vueDé);
				    		}
			            break;
			        	}
			        case "Bleue": 
			        	if (nbFruits[2] > 0) {
			        		nbFruits[2]--;
			        		bougerFruits(vuesArbre.get(2), vuesPanier.get(2));
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, vueTour, vueDé);
				    		}
			            break;
			        	}
			        default: 
			        	if (nbFruits[3] > 0) {
			        		nbFruits[3]--;
			        		bougerFruits(vuesArbre.get(3), vuesPanier.get(3));
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, vueTour, vueDé);
				    		}
			            break;
			        	}
			    }
			    
			}));
			timeline.play();

		});
	}
	
	public void bougerFruits(VueArbre vueArbre, VuePanier vuePanier) {
		Fruit fruit = vueArbre.arbre.getFruit();
		vueArbre.arbre.enleverFruit(fruit);
		vueArbre.genererVue();
		vuePanier.panier.ajouterFruit(fruit);
		vuePanier.genererVue();
	}


	public void messageVictoire(StackPane root, VueTour vueTour, VueDé vueDé) {
		StackPane paneLabel = new StackPane();
		Label compteur = new Label("Vous avez gagné en " + vueTour.getCompteur() + " tours");
		vueDé.paneDé.setVisible(false);
		vueTour.cacherCompteur();
		compteur.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;"); 
		root.getChildren().add(compteur);
	}
	
	
}

package leverger.controleur;

import java.util.Arrays;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import leverger.contenu.Face;
import leverger.contenu.Fruit;
import leverger.contenu.Tour;
import leverger.vue.LesVuesDesFruits;
import leverger.vue.VueDé;
import leverger.vue.VuesDesFruits;

public class ControleurDé {
	public VueDé vueDé;
	public Tour tour;
	public int[] nbFruits;
	public StackPane root;
	public LesVuesDesFruits lesvuesdesfruits;
	
	public ControleurDé(VueDé vueDé, Tour tour, LesVuesDesFruits lesvuesdesfruits){
		this.vueDé = vueDé;
		this.tour = tour;
		this.root = root;
		this.lesvuesdesfruits = lesvuesdesfruits;
	}
	
	public void initialiserEventHandler() {
		vueDé.paneDé.setOnMouseClicked(click -> {
			Face faceTiree = vueDé.dé.lancerDé();
			vueDé.cercle.setFill(faceTiree.couleur);
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(250), attente -> {
		        int[] nbFruitsVide = {0, 0, 0, 0};
		    	tour.incrementer();
			    switch(faceTiree.nom) {
			        case "Rouge": 
			        	if (nbFruits[0] > 0) {
			        		nbFruits[0]--;
			        		bougerFruits(lesvuesdesfruits.cerises);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé);
				    		}
			        	}
			            break;
			        case "Jaune": 
			        	if (nbFruits[1] > 0) {
			        		nbFruits[1]--;
			        		bougerFruits(lesvuesdesfruits.poires);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé);
				    		}
			            break;
			        	}
			        case "Bleue": 
			        	if (nbFruits[2] > 0) {
			        		nbFruits[2]--;
			        		bougerFruits(lesvuesdesfruits.prunes);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé);
				    		}
			            break;
			        	}
			        case "Verte": 
			        	if (nbFruits[3] > 0) {
			        		nbFruits[3]--;
			        		bougerFruits(lesvuesdesfruits.pommes);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé);
				    		}
			            break;
			        	}
			    }
			    
			}));
			timeline.play();

		});
	}
	
	public void bougerFruits(VuesDesFruits vuesdesfruits) {
		int nbFruit = vuesdesfruits.vueArbre.arbre.getNbFruit();
		Fruit fruit = vuesdesfruits.vueArbre.arbre.getFruit();
		vuesdesfruits.vueArbre.genererVue(nbFruit);
		vuesdesfruits.vuePanier.panier.ajouterFruit(fruit);
		vuesdesfruits.vuePanier.genererVue(nbFruit);
	}


	public void messageVictoire(StackPane root, Tour tour, VueDé vueDé) {
		StackPane paneLabel = new StackPane();
		Label label = new Label("Vous avez gagné en " + tour.getCompteur() + " tours");
		vueDé.paneDé.setVisible(false);
		tour.cacherLabel();
		label.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;"); 
		paneLabel.getChildren().add(label);
		root.getChildren().add(paneLabel);
	}
	
	
}

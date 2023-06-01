package leverger.controleur;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import leverger.modele.Face;
import leverger.modele.Fruit;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VuePanier;
import leverger.vue.VuePuzzle;
import leverger.vue.VueTour;

public class ControleurDé {
	public VueDé vueDé;
	public VueTour vueTour;
	int[] compteurFruitEtPiece = {10, 10, 10, 10, 0};
	public StackPane root;
	public List<VueArbre> vuesArbre;
	public List<VuePanier> vuesPanier;
	public VuePuzzle vuePuzzle;
	
	public ControleurDé(StackPane root, VueDé vueDé, VueTour vueTour, List<VueArbre> vuesArbre, List<VuePanier> vuesPanier, VuePuzzle vuePuzzle){
		this.vueDé = vueDé;
		this.vueTour = vueTour;
		this.root = root;
		this.vuesArbre = vuesArbre;
		this.vuesPanier = vuesPanier;
		this.vuePuzzle = vuePuzzle;
	}
	
	public void initialiserEventHandler() {
		vueDé.paneDé.setOnMouseClicked(click -> {
			Face faceTiree = vueDé.dé.lancerDé();
			vueDé.setFaceDuCercle(faceTiree);
			vueTour.incrementerTour();
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(250), attente -> {
			    switch(faceTiree.nom) {
			        case "Rouge": 
			        	if (compteurFruitEtPiece[0] > 0) {
			        		compteurFruitEtPiece[0]--;
			        		bougerFruits(vuesArbre.get(0), vuesPanier.get(0));
				    		if (victoireJoueur(compteurFruitEtPiece)) {
				    			messageVictoire("Vous avez gagné en ", root, vueTour, vueDé);
				    		}
			        	}
			            break;
			        case "Jaune": 
			        	if (compteurFruitEtPiece[1] > 0) {
			        		compteurFruitEtPiece[1]--;
			        		bougerFruits(vuesArbre.get(1), vuesPanier.get(1));
				    		if (victoireJoueur(compteurFruitEtPiece)) {
				    			messageVictoire("Vous avez gagné en ", root, vueTour, vueDé);
				    		}
			        	}
			        	break;
			        case "Bleue": 
			        	if (compteurFruitEtPiece[2] > 0) {
			        		compteurFruitEtPiece[2]--;
			        		bougerFruits(vuesArbre.get(2), vuesPanier.get(2));
				    		if (victoireJoueur(compteurFruitEtPiece)) {
				    			messageVictoire("Vous avez gagné en ", root, vueTour, vueDé);
				    		}
			        	}
			        	break;
			        case "Verte": 
			        	if (compteurFruitEtPiece[3] > 0) {
			        		compteurFruitEtPiece[3]--;
			        		bougerFruits(vuesArbre.get(3), vuesPanier.get(3));
				    		if (victoireJoueur(compteurFruitEtPiece)) {
				    			messageVictoire("Vous avez gagné en ", root, vueTour, vueDé);
				    		}
			        	}
			        	break;
				    default :
				    	compteurFruitEtPiece[4]++;
				    	vuePuzzle.getPuzzle().piocherPiece();
				    	vuePuzzle.genererVue();
			    		if (compteurFruitEtPiece[4] == 9) {
			    			messageVictoire("Le corbeau a gagné en ", root, vueTour, vueDé);
			    		}
				    	break;
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
	
	public boolean victoireJoueur(int[] compteurFruitEtPiece) {
		int i=0;
		boolean victoire = true;
		while ((i < 4) && victoire) {
			if (compteurFruitEtPiece[i] != 0) {
				victoire = false;
			}
			i++;
		}
		return victoire;
	}


	public void messageVictoire(String debutLabel, StackPane root, VueTour vueTour, VueDé vueDé) {
		StackPane paneLabel = new StackPane();
		Label compteur = new Label(debutLabel + vueTour.getCompteur() + " tours");
		vueDé.paneDé.setVisible(false);
		vueTour.cacherCompteur();
		compteur.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;"); 
		root.getChildren().add(compteur);
	}
	
	
}

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
	private VueDé vueDé;
	private VueTour vueTour;
	private int[] compteurFruitEtPiece = {10, 10, 10, 10, 0};
	private StackPane root;
	private List<VueArbre> vuesArbre;
	private List<VuePanier> vuesPanier;
	private VuePuzzle vuePuzzle;
	
	public ControleurDé(StackPane root, VueDé vueDé, VueTour vueTour, List<VueArbre> vuesArbre, List<VuePanier> vuesPanier, VuePuzzle vuePuzzle){
		this.vueDé = vueDé;
		this.vueTour = vueTour;
		this.root = root;
		this.vuesArbre = vuesArbre;
		this.vuesPanier = vuesPanier;
		this.vuePuzzle = vuePuzzle;
	}
	
	public void initialiserEventHandler() {
		vueDé.getPaneDé().setOnMouseClicked(click -> {
			Face faceTiree = vueDé.getDé().lancerDé();
			vueDé.setFaceDuCercle(faceTiree);
			vueTour.incrementerTour();
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(250), attente -> {
			    switch(faceTiree.getNom()) {
			        case "Rouge": 
			        	jouerTourFruit(0);
			            break;
			        case "Jaune": 
			        	jouerTourFruit(1);
			        	break;
			        case "Bleue": 
			        	jouerTourFruit(2);
			        	break;
			        case "Verte": 
			        	jouerTourFruit(3);
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

	private void jouerTourFruit(int indiceFruit) {
		if (compteurFruitEtPiece[indiceFruit] > 0) {
			compteurFruitEtPiece[indiceFruit]--;
			bougerFruits(vuesArbre.get(indiceFruit), vuesPanier.get(indiceFruit));
			if (victoireJoueur(compteurFruitEtPiece)) {
				messageVictoire("Vous avez gagné en ", root, vueTour, vueDé);
			}
		}
	}
	
	private void bougerFruits(VueArbre vueArbre, VuePanier vuePanier) {
		Fruit fruit = vueArbre.getArbre().getFruit();
		vueArbre.getArbre().enleverFruit(fruit);
		vueArbre.genererVue();
		vuePanier.getPanier().ajouterFruit(fruit);
		vuePanier.genererVue();
	}
	
	private boolean victoireJoueur(int[] compteurFruitEtPiece) {
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


	private void messageVictoire(String debutLabel, StackPane root, VueTour vueTour, VueDé vueDé) {
		Label compteur = new Label(debutLabel + vueTour.getCompteur() + " tours");
		vueDé.getPaneDé().setVisible(false);
		vueTour.cacherCompteur();
		compteur.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;"); 
		root.getChildren().add(compteur);
	}
	
	
}

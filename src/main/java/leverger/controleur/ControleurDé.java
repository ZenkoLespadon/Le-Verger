package leverger.controleur;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import leverger.modele.CompteurFruitEtCorbeau;
import leverger.modele.Face;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VuePanier;
import leverger.vue.VuePuzzle;
import leverger.vue.VueTour;

public class ControleurDé {
	private CompteurFruitEtCorbeau compteurFruitEtCorbeau;
	private VueDé vueDé;
	private VueTour vueTour;
	private StackPane root;
	private List<VueArbre> vuesArbre;
	private List<VuePanier> vuesPanier;
	private VuePuzzle vuePuzzle;
	
	public ControleurDé(StackPane root, VueDé vueDé, VueTour vueTour, List<VueArbre> vuesArbre, List<VuePanier> vuesPanier, VuePuzzle vuePuzzle, CompteurFruitEtCorbeau compteurFruitEtCorbeau){
		this.vueDé = vueDé;
		this.vueTour = vueTour;
		this.root = root;
		this.vuesArbre = vuesArbre;
		this.vuesPanier = vuesPanier;
		this.vuePuzzle = vuePuzzle;
		this.compteurFruitEtCorbeau = compteurFruitEtCorbeau;
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
			        case "Corbeau" :
					jouerTourCorbeau();
				    	break;
				    default :
				    	vueDé.incrementerNbFruitPanierDe2();
				    	}
			    
			}));
			timeline.play();

		});
	}

	private void jouerTourCorbeau() {
		compteurFruitEtCorbeau.incrementerCorbeau();
		vuePuzzle.getPuzzle().piocherPiece();
		vuePuzzle.genererVue();
		if (compteurFruitEtCorbeau.testPuzzlePlein()) {
			messageVictoire("Le corbeau a gagné en ", root, vueTour, vueDé);
		}
	}

	private void jouerTourFruit(int indiceFruit) {
		vuesArbre.get(indiceFruit).incrementerNbFruitCliquable();
	}

	private void messageVictoire(String debutLabel, StackPane root, VueTour vueTour, VueDé vueDé) {
		Label compteur = new Label(debutLabel + vueTour.getCompteur() + " tours");
		vueDé.getPaneDé().setVisible(false);
		vueTour.cacherCompteur();
		compteur.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;"); 
		root.getChildren().add(compteur);
	}
	
}

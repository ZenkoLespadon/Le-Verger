package leverger.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import leverger.contenu.Arbre;
import leverger.contenu.Dé;
import leverger.contenu.Fruit;
import leverger.contenu.Panier;
import leverger.contenu.Tour;
import leverger.controleur.ControleurDé;
import leverger.vue.LesVuesDesFruits;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VuePanier;
import leverger.vue.VuesDesFruits;

public class Console extends Application {
	
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		GridPane verger = new GridPane();
		verger.setVisible(true);
		
		
		Arbre cerisier = new Arbre(Fruit.CERISE);
		Arbre poirier = new Arbre(Fruit.POIRE);
		Arbre prunier = new Arbre(Fruit.PRUNE);
		Arbre pommier = new Arbre(Fruit.POMME);
		
		int[] nbFruits = {10, 10, 10, 10};
		
		Panier panierCerises = new Panier();
		Panier panierPoires = new Panier();
		Panier panierPrunes = new Panier();
		Panier panierPommes = new Panier();
		
		VuePanier vuePanierCerises = new VuePanier(panierCerises);
		VuePanier vuePanierPoires = new VuePanier(panierPoires);
		VuePanier vuePanierPrunes = new VuePanier(panierPrunes);
		VuePanier vuePanierPommes = new VuePanier(panierPommes);
		
		vuePanierCerises.genererVue(nbFruits[0]);
		vuePanierPoires.genererVue(nbFruits[1]);
		vuePanierPrunes.genererVue(nbFruits[2]);
		vuePanierPommes.genererVue(nbFruits[3]);
		
		verger.add(vuePanierCerises.conteneur, 0, 1);
		verger.add(vuePanierPoires.conteneur, 1, 1);
		verger.add(vuePanierPrunes.conteneur, 2, 1);
		verger.add(vuePanierPommes.conteneur, 3, 1);

		
		VueArbre vueCerisier = new VueArbre(cerisier);
		VueArbre vuePoirier = new VueArbre(poirier);
		VueArbre vuePrunier = new VueArbre(prunier);
		VueArbre vuePommier = new VueArbre(pommier);
		
		
		
		
		ImageView backgrounds = new ImageView(new Image("file:img/Background.png"));
		backgrounds.setFitWidth(1600);
		backgrounds.setFitHeight(900);
		
		Label labelTour = new Label("Tour 1");
		labelTour.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: rgb(51, 102, 0);");
		
		
		VuesDesFruits vuesdescerises = new VuesDesFruits(vuePanierCerises, vueCerisier);
		VuesDesFruits vuesdespoires = new VuesDesFruits(vuePanierPoires, vuePoirier);
		VuesDesFruits vuesdesprunes = new VuesDesFruits(vuePanierPrunes, vuePrunier);
		VuesDesFruits vuesdespommes = new VuesDesFruits(vuePanierPommes, vuePommier);
		
		LesVuesDesFruits lesvuesdesfruits = new LesVuesDesFruits(vuesdescerises, vuesdespoires, vuesdesprunes, vuesdespommes);
		
		Dé dé = new Dé();		
		VueDé vueDé = new VueDé(dé, Color.BLACK);
		vueDé.paneDé.setPadding(new Insets(0, 0, 50, 0));
		
		Tour tour = new Tour();
		
		ControleurDé controleurdé = new ControleurDé(vueDé, tour, lesvuesdesfruits);
		controleurdé.initialiserEventHandler();
		
		/*
		vueDé.paneDé.setOnMouseClicked(click -> {
			Face faceTiree = dé.lancerDé();
			vueDé.cercle.setFill(faceTiree.couleur);
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(250), attente -> {
		        int[] nbFruitsVide = {0, 0, 0, 0};
		    	tour[0]++;
		    	labelTour.setText("Tour " + Integer.toString(tour[0]));
			    switch(faceTiree.nom) {
			        case "Rouge": 
			        	if (nbFruits[0] > 0) {
			        		nbFruits[0]--;
			        		enleverFruit(nbFruits[0], Fruit.CERISE, panierCerises, vuePanierCerises, vueCerisier);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			        	}
			            break;
			        case "Jaune": 
			        	if (nbFruits[1] > 0) {
			        		nbFruits[1]--;
			        		enleverFruit(nbFruits[1], Fruit.POIRE, panierPoires, vuePanierPoires, vuePoirier);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			            break;
			        	}
			        case "Bleue": 
			        	if (nbFruits[2] > 0) {
			        		nbFruits[2]--;
			        		enleverFruit(nbFruits[2], Fruit.PRUNE, panierPrunes, vuePanierPrunes, vuePrunier);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			            break;
			        	}
			        case "Verte": 
			        	if (nbFruits[3] > 0) {
			        		nbFruits[3]--;
			        		enleverFruit(nbFruits[3], Fruit.POMME, panierPommes, vuePanierPommes, vuePommier);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			            break;
			        	}
			    }
			    
			}));
			timeline.play();

		});
		*/
		
		verger.add(vueCerisier.conteneur, 0, 0);
		verger.add(vuePoirier.conteneur, 1, 0);
		verger.add(vuePrunier.conteneur, 2, 0);
		verger.add(vuePommier.conteneur, 3, 0);
		
		root.getChildren().add(backgrounds);
		root.getChildren().add(verger);
		root.getChildren().add(vueDé.paneDé);
		root.getChildren().add(labelTour);
		
		root.setMargin(labelTour, new Insets(800, 0, 0, 1400));
		

		
		Scene scene = new Scene(root, 1600, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
		//CHANGEMENT
	}

    public static void main(String[] args) {
        launch(args);
    }
}

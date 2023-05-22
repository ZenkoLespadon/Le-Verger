package leverger.application;

import java.util.Arrays;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import leverger.contenu.Arbre;
import leverger.contenu.Dé;
import leverger.contenu.Face;
import leverger.contenu.Fruit;
import leverger.contenu.VueDé;

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
		int[] tour = {1};
		
		Dé dé = new Dé();		
		VueDé vueDé = new VueDé(dé, Color.BLACK);

		
		StackPane conteneurCerisier = new StackPane();
		vueArbre(conteneurCerisier, cerisier, nbFruits[0]);
			
		StackPane conteneurPoirier = new StackPane();
		vueArbre(conteneurPoirier, poirier, nbFruits[1]);
		
		StackPane conteneurPrunier = new StackPane();
		vueArbre(conteneurPrunier, prunier, nbFruits[2]);
			
		StackPane conteneurPommier = new StackPane();
		vueArbre(conteneurPommier, pommier, nbFruits[3]);
		
		
		
		
		ImageView backgrounds = new ImageView(new Image("file:img/Background.png"));
		backgrounds.setFitWidth(1600);
		backgrounds.setFitHeight(900);
		
		Label labelTour = new Label("Tour 1");
		labelTour.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: rgb(51, 102, 0);");
		

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
			        		vueArbre(conteneurCerisier, cerisier, nbFruits[0]);
			        		vueFruits(verger, 0, cerisier.fruits.get(0).image, 10 - nbFruits[0]);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			        	}
			            break;
			        case "Jaune": 
			        	if (nbFruits[1] > 0) {
			        		nbFruits[1]--;
			        		vueArbre(conteneurPoirier, poirier, nbFruits[1]);
			        		vueFruits(verger, 1, poirier.fruits.get(0).image, 10 - nbFruits[1]);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			            break;
			        	}
			        case "Bleue": 
			        	if (nbFruits[2] > 0) {
			        		nbFruits[2]--;
			        		vueArbre(conteneurPrunier, prunier, nbFruits[2]);
			        		vueFruits(verger, 2, prunier.fruits.get(0).image, 10 - nbFruits[2]);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			            break;
			        	}
			        case "Verte": 
			        	if (nbFruits[3] > 0) {
			        		nbFruits[3]--;
			        		vueArbre(conteneurPommier, pommier, nbFruits[3]);
			        		vueFruits(verger, 3, pommier.fruits.get(0).image, 10 - nbFruits[3]);
				    		if (Arrays.equals(nbFruits, nbFruitsVide)) {
				    			messageVictoire(root, tour, vueDé, labelTour);
				    		}
			            break;
			        	}
			    }
			    
			}));
			timeline.play();

		});
		
		
		
		verger.add(conteneurCerisier, 0, 0);
		verger.add(conteneurPoirier, 1, 0);
		verger.add(conteneurPrunier, 2, 0);
		verger.add(conteneurPommier, 3, 0);
		
		//root.add(vueCerise, 0, 1);//
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


	public void messageVictoire(StackPane root, int[] tour, VueDé vueDé, Label labelTour) {
		StackPane paneLabel = new StackPane();
		Label label = new Label("Vous avez gagné en " + tour[0] + " tours");
		vueDé.paneDé.setVisible(false);
		labelTour.setVisible(false);
		label.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: black;"); 
		paneLabel.getChildren().add(label);
		root.getChildren().add(paneLabel);
	}
	
	
	private void vueArbre(StackPane conteneurArbre, Arbre arbre, int nbFruit) {
		
		ImageView vueArbre = new ImageView(arbre.image);
		int i;
		int j=0;
		int k=0;
		vueArbre.setFitWidth(400);
		vueArbre.setFitHeight(425);
	
		conteneurArbre.getChildren().add(vueArbre);
	
		GridPane mesFruits = new GridPane();
		mesFruits.setPadding(new Insets (60,0,0,75));
	
	
		for (i = 0; i < nbFruit; i++) {
			if (i == 5) {
				k++;
				j=0;
			}
			ImageView vueFruit = new ImageView(arbre.fruits.get(i).image);
			vueFruit.setFitWidth(50);
			vueFruit.setFitHeight(50);
			mesFruits.add(vueFruit, j, k);
			j++;
		}

		conteneurArbre.getChildren().add(mesFruits);
	}
	
	private void vueFruits(GridPane verger, int nbArbre, Image imageFruit, int nbFruit) {
		
		int i;
		int j=0;
		int k=0;

	
		GridPane mesFruits = new GridPane();
		mesFruits.setPadding(new Insets (200,0,0,75));
	
	
		for (i = 0; i < nbFruit; i++) {
			if (i == 5) {
				k++;
				j=0;
			}
			ImageView vueFruit = new ImageView(imageFruit);
			vueFruit.setFitWidth(50);
			vueFruit.setFitHeight(50);
			mesFruits.add(vueFruit, j, k);
			j++;
		}

		verger.add(mesFruits, nbArbre, 1);
	}


    public static void main(String[] args) {
        launch(args);
    }
}

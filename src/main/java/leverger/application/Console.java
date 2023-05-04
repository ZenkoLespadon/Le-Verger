package leverger.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import leverger.contenu.Arbre;
import leverger.contenu.Fruit;

public class Console extends Application {
	
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		GridPane verger = new GridPane();
		verger.setVisible(true);
		
		
		Arbre pommier = new Arbre(Fruit.POMME);
		Arbre prunier = new Arbre(Fruit.PRUNE);
		Arbre poirier = new Arbre(Fruit.POIRE);
		Arbre cerisier = new Arbre(Fruit.CERISE);
		
		ImageView vuePommier = new ImageView(pommier.image);
		vuePommier.setFitWidth(400);
		vuePommier.setFitHeight(425);
		
		ImageView vuePrunier = new ImageView(prunier.image);
		vuePrunier.setFitWidth(400);
		vuePrunier.setFitHeight(425);
		
		ImageView vuePoirier = new ImageView(poirier.image);
		vuePoirier.setFitWidth(400);
		vuePoirier.setFitHeight(425);
		
		ImageView vueCerisier = new ImageView(cerisier.image);
		vueCerisier.setFitWidth(400);
		vueCerisier.setFitHeight(425);
		
		
		StackPane conteneurPommier = new StackPane();
		conteneurPommier.getChildren().add(vuePommier);
		imgPomme(conteneurPommier);
		
		StackPane conteneurCerisier = new StackPane();
		conteneurCerisier.getChildren().add(vueCerisier);
		imgCerise(conteneurCerisier);
	
		StackPane conteneurPoirier = new StackPane();
		conteneurPoirier.getChildren().add(vuePoirier);
		imgPoire(conteneurPoirier);
		
		StackPane conteneurPrune = new StackPane();
		conteneurPrune.getChildren().add(vuePrunier);
		imgPrune(conteneurPrune);
		
		ImageView backgrounds = new ImageView(new Image("file:img/Background.png"));
		backgrounds.setFitWidth(1600);
		backgrounds.setFitHeight(900);
		
		
		verger.add(conteneurPommier, 0, 1);
		verger.add(conteneurPrune, 1, 1);
		verger.add(conteneurPoirier, 2, 1);
		verger.add(conteneurCerisier, 3, 1);
		//root.add(vueCerise, 0, 1);//
		root.getChildren().add(backgrounds);
		root.getChildren().add(verger);
		Scene scene = new Scene(root, 1600, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
		//CHANGEMENT
	}


	private void imgPomme(StackPane conteneurPommier) {
		
		GridPane mesPommes = new GridPane();
		mesPommes.setPadding(new Insets (60,0,0,75));
		
		
		for (int row = 0; row < 2; row++) {
		    for (int col = 0; col < 5; col++) {
		    	ImageView vuePomme = new ImageView(Fruit.POMME.image);
				vuePomme.setFitWidth(50);
				vuePomme.setFitHeight(50);
				mesPommes.add(vuePomme, col, row);
		    }
		}

		conteneurPommier.getChildren().add(mesPommes);
	}
	
private void imgCerise(StackPane conteneurCerisier) {
		
		GridPane mesCerises = new GridPane();
		mesCerises.setPadding(new Insets (60,0,0,75));
		
		
		for (int row = 0; row < 2; row++) {
		    for (int col = 0; col < 5; col++) {
		    	ImageView vueCerise = new ImageView(Fruit.CERISE.image);
		    	vueCerise.setFitWidth(50);
		    	vueCerise.setFitHeight(50);
		    	mesCerises.add(vueCerise, col, row);
		    }
		}

		conteneurCerisier.getChildren().add(mesCerises);
	}

private void imgPoire(StackPane conteneurPoirier) {
	
	GridPane mesPoires = new GridPane();
	mesPoires.setPadding(new Insets (60,0,0,75));
	
	
	for (int row = 0; row < 2; row++) {
	    for (int col = 0; col < 5; col++) {
	    	ImageView vuePoire = new ImageView(Fruit.POIRE.image);
	    	vuePoire.setFitWidth(50);
	    	vuePoire.setFitHeight(50);
	    	mesPoires.add(vuePoire, col, row);
	    }
	}

	conteneurPoirier.getChildren().add(mesPoires);
}

private void imgPrune(StackPane conteneurPrunier) {
	
	GridPane mesPrunes = new GridPane();
	mesPrunes.setPadding(new Insets (60,0,0,75));
	
	
	for (int row = 0; row < 2; row++) {
	    for (int col = 0; col < 5; col++) {
	    	ImageView vuePrune = new ImageView(Fruit.PRUNE.image);
	    	vuePrune.setFitWidth(50);
	    	vuePrune.setFitHeight(50);
	    	mesPrunes.add(vuePrune, col, row);
	    }
	}

	conteneurPrunier.getChildren().add(mesPrunes);
}


    public static void main(String[] args) {
        launch(args);
    }
}

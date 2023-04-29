package leverger.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import leverger.contenu.Arbre;
import leverger.contenu.Fruit;

public class Console extends Application {
	
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		
		Arbre pommier = new Arbre(Fruit.POMME);
		Arbre prunier = new Arbre(Fruit.PRUNE);
		Arbre poirier = new Arbre(Fruit.POIRE);
		Arbre cerisier = new Arbre(Fruit.CERISE);
		
		ImageView vuePommier = new ImageView(pommier.image);
		vuePommier.setFitWidth(375);
		vuePommier.setFitHeight(400);
		
		ImageView vuePrunier = new ImageView(prunier.image);
		vuePrunier.setFitWidth(375);
		vuePrunier.setFitHeight(400);
		
		ImageView vuePoirier = new ImageView(poirier.image);
		vuePoirier.setFitWidth(375);
		vuePoirier.setFitHeight(400);
		
		ImageView vueCerisier = new ImageView(cerisier.image);
		vueCerisier.setFitWidth(375);
		vueCerisier.setFitHeight(400);
		
		StackPane conteneurPommier = new StackPane();
		conteneurPommier.getChildren().add(vuePommier);
		
		ImageView vuePomme = new ImageView(Fruit.POMME.image);
		vuePomme.setFitWidth(50);
		vuePomme.setFitHeight(50);
		
		ImageView vueCerise = new ImageView(Fruit.CERISE.image);
		vueCerise.setFitWidth(40);
		vueCerise.setFitHeight(40);
		
		GridPane mesPommes = new GridPane();
		mesPommes.setPadding(new Insets (60,0,0,75));
		mesPommes.add(vuePomme, 0, 0);
		conteneurPommier.getChildren().add(mesPommes);
		
		
		root.add(conteneurPommier, 0, 0);
		root.add(vuePrunier, 1, 0);
		root.add(vuePoirier, 2, 0);
		root.add(vueCerisier, 3, 0);
		root.add(vueCerise, 0, 1);
		Scene scene = new Scene(root, 1500, 750);
		primaryStage.setScene(scene);
		primaryStage.show();
		//CHANGEMENT
	}


    public static void main(String[] args) {
        launch(args);
    }
}

package leverger.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import leverger.controleur.ControleurDé;
import leverger.modele.Arbre;
import leverger.modele.Dé;
import leverger.modele.Fruit;
import leverger.modele.Panier;
import leverger.modele.Puzzle;
import leverger.modele.Tour;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VueFruit;
import leverger.vue.VuePanier;
import leverger.vue.VuePuzzle;
import leverger.vue.VueTour;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		
		StackPane root = new StackPane();
		GridPane hautDuVerger = new GridPane();
		
		GridPane basDuVerger = new GridPane();
		basDuVerger.setPadding(new Insets(450, 0, 0, 50));
		
		
		VueFruit vueCerise = new VueFruit(Fruit.CERISE, new Image("file:img/Cerise.png"));
		VueFruit vuePoire = new VueFruit(Fruit.POIRE, new Image("file:img/Poire.png"));
		VueFruit vuePrune = new VueFruit(Fruit.PRUNE, new Image("file:img/Prune.png"));
		VueFruit vuePomme = new VueFruit(Fruit.POMME, new Image("file:img/Pomme.png"));
		
		Arbre cerisier = new Arbre(Fruit.CERISE);
		Arbre poirier = new Arbre(Fruit.POIRE);
		Arbre prunier = new Arbre(Fruit.PRUNE);
		Arbre pommier = new Arbre(Fruit.POMME);
		
		VueArbre vueCerisier = new VueArbre(cerisier, vueCerise);
		VueArbre vuePoirier = new VueArbre(poirier, vuePoire);
		VueArbre vuePrunier = new VueArbre(prunier, vuePrune);
		VueArbre vuePommier = new VueArbre(pommier, vuePomme);
		
		hautDuVerger.add(vueCerisier.getConteneur(), 0, 0);
		hautDuVerger.add(vuePoirier.getConteneur(), 1, 0);
		hautDuVerger.add(vuePrunier.getConteneur(), 2, 0);
		hautDuVerger.add(vuePommier.getConteneur(), 3, 0);
		
		Panier panierCerises = new Panier();
		Panier panierPoires = new Panier();
		Panier panierPrunes = new Panier();
		Panier panierPommes = new Panier();
		
		VuePanier vuePanierCerises = new VuePanier(panierCerises, vueCerise);
		VuePanier vuePanierPoires = new VuePanier(panierPoires, vuePoire);
		VuePanier vuePanierPrunes = new VuePanier(panierPrunes, vuePrune);
		VuePanier vuePanierPommes = new VuePanier(panierPommes, vuePomme);
		
		List<VueArbre> vuesArbre = new ArrayList<VueArbre>();
		vuesArbre.addAll(Arrays.asList(vueCerisier, vuePoirier, vuePrunier, vuePommier));
		
		List<VuePanier> vuesPanier = new ArrayList<VuePanier>();
		vuesPanier.addAll(Arrays.asList(vuePanierCerises, vuePanierPoires, vuePanierPrunes, vuePanierPommes));
		
		Puzzle puzzle = new Puzzle();
		VuePuzzle vuePuzzle = new VuePuzzle(puzzle);
	
		
		basDuVerger.add(vuePanierCerises.getConteneur(), 0, 0);
		basDuVerger.add(vuePanierPoires.getConteneur(), 1, 0);
		basDuVerger.add(vuePuzzle.getConteneur(), 2, 0);
		basDuVerger.add(vuePanierPrunes.getConteneur(), 3, 0);
		basDuVerger.add(vuePanierPommes.getConteneur(), 4, 0);
		
		Dé dé = new Dé();		
		VueDé vueDé = new VueDé(dé, Color.WHITE);
		
		Tour tour = new Tour();
		VueTour vueTour = new VueTour(tour);
		
		ControleurDé controleurdé = new ControleurDé(root, vueDé, vueTour, vuesArbre, vuesPanier, vuePuzzle);
		controleurdé.initialiserEventHandler();
		
		ImageView backgrounds = new ImageView(new Image("file:img/Background.png"));
		backgrounds.setFitWidth(1600);
		backgrounds.setFitHeight(900);
		
		root.getChildren().add(backgrounds);
		root.getChildren().add(hautDuVerger);
		root.getChildren().add(basDuVerger);
		root.getChildren().add(vuePuzzle.getConteneur());
		root.getChildren().add(vueDé.getPaneDé());
		root.getChildren().add(vueTour.getLabel());
		
		root.setMargin(vueTour.getLabel(), new Insets(800, 0, 0, 1400));
		

		
		Scene scene = new Scene(root, 1600, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

    public static void main(String[] args) {
        launch(args);
    }
}

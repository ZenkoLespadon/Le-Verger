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
import leverger.modele.Tour;
import leverger.modèle.Arbre;
import leverger.modèle.Dé;
import leverger.modèle.Fruit;
import leverger.modèle.Panier;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VueFruit;
import leverger.vue.VuePanier;
import leverger.vue.VueTour;

public class Main extends Application {
	
	public void start(Stage primaryStage) {

		StackPane root = new StackPane();
		GridPane verger = new GridPane();
		
		VueFruit vueCerise = new VueFruit(Fruit.CERISE, new Image("file:img/Cerise.png"));
		VueFruit vuePoire = new VueFruit(Fruit.POIRE, new Image("file:img/Poire.png"));
		VueFruit vuePrune = new VueFruit(Fruit.PRUNE, new Image("file:img/Prune.png"));
		VueFruit vuePomme = new VueFruit(Fruit.POMME, new Image("file:img/Pomme.png"));
		
		
		
		Arbre cerisier = new Arbre(Fruit.CERISE);
		Arbre poirier = new Arbre(Fruit.POIRE);
		Arbre prunier = new Arbre(Fruit.PRUNE);
		Arbre pommier = new Arbre(Fruit.POMME);
		
		Panier panierCerises = new Panier();
		Panier panierPoires = new Panier();
		Panier panierPrunes = new Panier();
		Panier panierPommes = new Panier();
		
		VuePanier vuePanierCerises = new VuePanier(panierCerises, vueCerise);
		VuePanier vuePanierPoires = new VuePanier(panierPoires, vuePoire);
		VuePanier vuePanierPrunes = new VuePanier(panierPrunes, vuePrune);
		VuePanier vuePanierPommes = new VuePanier(panierPommes, vuePomme);
	
		
		verger.add(vuePanierCerises.getConteneur(), 0, 1);
		verger.add(vuePanierPoires.getConteneur(), 1, 1);
		verger.add(vuePanierPrunes.getConteneur(), 2, 1);
		verger.add(vuePanierPommes.getConteneur(), 3, 1);

		
		VueArbre vueCerisier = new VueArbre(cerisier, vueCerise);
		VueArbre vuePoirier = new VueArbre(poirier, vuePoire);
		VueArbre vuePrunier = new VueArbre(prunier, vuePrune);
		VueArbre vuePommier = new VueArbre(pommier, vuePomme);
		

		ImageView backgrounds = new ImageView(new Image("file:img/Background.png"));
		backgrounds.setFitWidth(1600);
		backgrounds.setFitHeight(900);
		
		List<VueArbre> vuesArbre = new ArrayList<VueArbre>();
		vuesArbre.addAll(Arrays.asList(vueCerisier, vuePoirier, vuePrunier, vuePommier));
		
		List<VuePanier> vuesPanier = new ArrayList<VuePanier>();
		vuesPanier.addAll(Arrays.asList(vuePanierCerises, vuePanierPoires, vuePanierPrunes, vuePanierPommes));
		
		
		Dé dé = new Dé();		
		VueDé vueDé = new VueDé(dé, Color.BLACK);
		
		Tour tour = new Tour();
		VueTour vueTour = new VueTour(tour);
		
		ControleurDé controleurdé = new ControleurDé(root, vueDé, vueTour, vuesArbre, vuesPanier);
		controleurdé.initialiserEventHandler();
		
		verger.add(vueCerisier.getConteneur(), 0, 0);
		verger.add(vuePoirier.getConteneur(), 1, 0);
		verger.add(vuePrunier.getConteneur(), 2, 0);
		verger.add(vuePommier.getConteneur(), 3, 0);
		
		root.getChildren().add(backgrounds);
		root.getChildren().add(verger);
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

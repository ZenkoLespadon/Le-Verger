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
import leverger.modèle.Arbre;
import leverger.modèle.Dé;
import leverger.modèle.Fruit;
import leverger.modèle.Panier;
import leverger.vue.VueTour;
import leverger.vue.VueArbre;
import leverger.vue.VueDé;
import leverger.vue.VuePanier;

public class Console extends Application {
	
	public void start(Stage primaryStage) {

		StackPane root = new StackPane();
		GridPane verger = new GridPane();
		
		
		
		Arbre cerisier = new Arbre(Fruit.CERISE);
		Arbre poirier = new Arbre(Fruit.POIRE);
		Arbre prunier = new Arbre(Fruit.PRUNE);
		Arbre pommier = new Arbre(Fruit.POMME);
		
		Panier panierCerises = new Panier();
		Panier panierPoires = new Panier();
		Panier panierPrunes = new Panier();
		Panier panierPommes = new Panier();
		
		VuePanier vuePanierCerises = new VuePanier(panierCerises);
		VuePanier vuePanierPoires = new VuePanier(panierPoires);
		VuePanier vuePanierPrunes = new VuePanier(panierPrunes);
		VuePanier vuePanierPommes = new VuePanier(panierPommes);
	
		
		verger.add(vuePanierCerises.getConteneur(), 0, 1);
		verger.add(vuePanierPoires.getConteneur(), 1, 1);
		verger.add(vuePanierPrunes.getConteneur(), 2, 1);
		verger.add(vuePanierPommes.getConteneur(), 3, 1);

		
		VueArbre vueCerisier = new VueArbre(cerisier);
		VueArbre vuePoirier = new VueArbre(poirier);
		VueArbre vuePrunier = new VueArbre(prunier);
		VueArbre vuePommier = new VueArbre(pommier);
		

		ImageView backgrounds = new ImageView(new Image("file:img/Background.png"));
		backgrounds.setFitWidth(1600);
		backgrounds.setFitHeight(900);
		
		List<VueArbre> vuesArbre = new ArrayList<VueArbre>();
		vuesArbre.addAll(Arrays.asList(vueCerisier, vuePoirier, vuePrunier, vuePommier));
		
		List<VuePanier> vuesPanier = new ArrayList<VuePanier>();
		vuesPanier.addAll(Arrays.asList(vuePanierCerises, vuePanierPoires, vuePanierPrunes, vuePanierPommes));
		
		
		Dé dé = new Dé();		
		VueDé vueDé = new VueDé(dé, Color.BLACK);
		
		VueTour tour = new VueTour();
		
		ControleurDé controleurdé = new ControleurDé(root, vueDé, tour, vuesArbre, vuesPanier);
		controleurdé.initialiserEventHandler();
		
		verger.add(vueCerisier.conteneur, 0, 0);
		verger.add(vuePoirier.conteneur, 1, 0);
		verger.add(vuePrunier.conteneur, 2, 0);
		verger.add(vuePommier.conteneur, 3, 0);
		
		root.getChildren().add(backgrounds);
		root.getChildren().add(verger);
		root.getChildren().add(vueDé.paneDé);
		root.getChildren().add(tour.label);
		
		root.setMargin(tour.getLabel(), new Insets(800, 0, 0, 1400));
		

		
		Scene scene = new Scene(root, 1600, 900);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

    public static void main(String[] args) {
        launch(args);
    }
}

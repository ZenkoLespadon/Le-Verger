package leverger.contenu;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VuePanier {
        public Panier panier;
        public StackPane panePanier;
        public ArrayList<Fruit> fruits;

        public VuePanier(Panier panier, ArrayList<Fruit> fruits){
            this.panier = panier;
            StackPane panePanier = new StackPane();
            this.panePanier = panePanier;

            ImageView vueHautDuPanier = new ImageView(panier.haut);
            vueHautDuPanier.setFitWidth(375);
            vueHautDuPanier.setFitHeight(400);

            ImageView vueBasDuPanier = new ImageView(panier.bas);
            vueBasDuPanier.setFitWidth(375);
            vueBasDuPanier.setFitHeight(400);
            
            
            panePanier.getChildren().add(vueHautDuPanier);
            int nbFruit = fruits.size();
            this.ajouterFruit(fruits, nbFruit);
            panePanier.getChildren().add(vueBasDuPanier);
            
            
        }
        
        public void ajouterFruit(ArrayList<Fruit> fruits, int nbFruit){
        	GridPane gridFruits1 = new GridPane();
        	GridPane gridFruits2 = new GridPane();
        	
        	int k = 0;
                
        	for (int i = 0; i < 5; i++) {
        		k++;
        		if (k > nbFruit) {
        			break;
        		}
        		ImageView vueFruit = new ImageView(fruits.get(0).image);
                vueFruit.setFitWidth(47);
                vueFruit.setFitHeight(47);
        		gridFruits1.add(vueFruit, i, 0);
            }
        	gridFruits1.setPadding(new Insets(170, 0, 0, 80));
        	
        	for (int j = 0; j < 5; j++) {
        		k++;
        		if (k > nbFruit) {
        			break;
        		}
        		ImageView vueFruit = new ImageView(fruits.get(0).image);
                vueFruit.setFitWidth(47);
                vueFruit.setFitHeight(47);
        		gridFruits2.add(vueFruit, j, 0);
            }
        	gridFruits2.setPadding(new Insets(170, 0, 0, 105));
        	this.panePanier.getChildren().add(gridFruits1);
        	this.panePanier.getChildren().add(gridFruits2);
        }

}
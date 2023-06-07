package leverger.vue;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import leverger.controleur.ControleurFruit;
import leverger.modele.Arbre;
import leverger.modele.CompteurFruitEtCorbeau;

public class VueArbre{
	
	private int nbFruitCliquable;
	private Arbre arbre;
	private Image image;
	private StackPane conteneur;
	private GridPane gridFruits;
	private VueFruit vueFruit;
	private VuePanier vuePanier;
	private VueDé vueDé;
	private CompteurFruitEtCorbeau compteurFruitEtCorbeau;
	private StackPane root;
	private VueTour vueTour;

    public VueArbre(Arbre arbre, VueFruit vueFruit, VuePanier vuePanier, VueDé vueDé, CompteurFruitEtCorbeau compteurFruitEtCorbeau, StackPane root, VueTour vueTour) {
    	this.nbFruitCliquable = 0;
    	this.arbre = arbre;
    	this.image = new Image("file:img/Arbre.png");
        this.conteneur = new StackPane();
        this.gridFruits = new GridPane();
        this.vueFruit = vueFruit;
        this.vuePanier = vuePanier;
        this.vueDé = vueDé;
        this.compteurFruitEtCorbeau = compteurFruitEtCorbeau;
        this.root = root;
        this.vueTour = vueTour;
        
        genererVue();
    }
	
    public StackPane getConteneur() {
    	return this.conteneur;
    }
    
    public Arbre getArbre() {
    	return this.arbre;
    }
    
    public VueFruit getVueFruit() {
    	return this.vueFruit;
    }
    
    public GridPane getGridFruits() {
    	return this.gridFruits;
    }
    
    
	public void genererVue() {
		
		ImageView imageview = new ImageView(this.image);
		imageview.setFitWidth(400);
		imageview.setFitHeight(425);
		
		int i;
		int j=0;
		int k=0;
	
		this.conteneur.getChildren().add(imageview);
	
		gridFruits.setPadding(new Insets (60,0,0,75));
		
		
	
	
		for (i = 0; i < 10; i++) {
			if (i == 5) {
				k++;
				j=0;
			}
			
			ImageView imageVueFruit = vueFruit.genererVue();
			
			
			imageVueFruit.setFitWidth(50);
			imageVueFruit.setFitHeight(50);
			
			ControleurFruit controleurFruit = new ControleurFruit(this, this.vuePanier, this.vueDé, imageVueFruit, compteurFruitEtCorbeau, root, vueTour);
			controleurFruit.initialiserEventHandler();
			
			gridFruits.add(imageVueFruit, j, k);
			
			j++;
		}

		this.conteneur.getChildren().add(gridFruits);
	}
	
	public void enleverFruit() {
		if ((gridFruits.getChildren().size()-1) >= 0) {
			gridFruits.getChildren().remove(gridFruits.getChildren().size()-1);
		}
	}
	
	public int getNbFruitCliquable() {
		return this.nbFruitCliquable;
	}
	
	public void incrementerNbFruitCliquable() {
		this.nbFruitCliquable = this.nbFruitCliquable + 1;
	}
	
	public void decrementerNbFruitCliquable() {
		this.nbFruitCliquable = this.nbFruitCliquable - 1;
	}
	
}

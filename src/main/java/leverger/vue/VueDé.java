package leverger.vue;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import leverger.modele.Dé;
import leverger.modele.Face;

public class VueDé {
	
	private int nbFruitPanier;
	private Dé dé;
	private StackPane paneDé;
	private Circle cercle;
	private Rectangle carre;
	
	
	public VueDé(Dé dé, Color couleur) {
		this.nbFruitPanier = 0;
		this.dé = dé;
        this.cercle = generationCercle(couleur);
		this.carre = generationCarre();
        this.paneDé = new StackPane();
        this.paneDé.getChildren().addAll(carre, cercle);
        this.paneDé.setPadding(new Insets(0, 0, 50, 0));
        this.paneDé.setMaxWidth(100);
        this.paneDé.setMaxHeight(100);
	}
	
	public Dé getDé() {
		return this.dé;
	}
	
	public StackPane getPaneDé() {
		return this.paneDé;
	}
	private Circle generationCercle(Color couleur) {
		cercle = new Circle(30, couleur);
		return cercle;
	}
	
	private Rectangle generationCarre() {
		carre = new Rectangle();
		carre.setWidth(120);
        carre.setHeight(120);
        carre.setStroke(Color.BLACK);
        carre.setStrokeWidth(5);
        carre.setFill(Color.WHITE);
        return carre;
	}
	
	public int getNbFruitPanier() {
		return this.nbFruitPanier;
	}
	
	public void decrementerNbFruitPanier() {
		this.nbFruitPanier = this.nbFruitPanier - 1;
	}
	
	public void incrementerNbFruitPanierDe2() {
		this.nbFruitPanier = this.nbFruitPanier + 2;
	}

	public void setFaceDuCercle(Face face) {
		
		if (face.getImage() != null) {
			supprimerImageViewSiElleExiste();
			ImageView imageView = new ImageView(face.getImage());
           	imageView.setFitWidth(90);
           	imageView.setFitHeight(90);
           	this.cercle.setFill(Color.WHITE);
           	this.paneDé.getChildren().add(imageView);		    
		} else {
			supprimerImageViewSiElleExiste();
		   	this.cercle.setFill(face.getCouleur());
		}
	}
	
    private void supprimerImageViewSiElleExiste() {
        boolean imageViewTrouvee = false;
        int i = 0;
        
        while (!imageViewTrouvee && i < this.paneDé.getChildren().size()) {
        	
            if (this.paneDé.getChildren().get(i) instanceof ImageView) {
                this.paneDé.getChildren().remove(i);
                imageViewTrouvee = true;
            } else {
                i++;
            }
        }
    }
}
	
	
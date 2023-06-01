package leverger.vue;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import leverger.modele.Dé;
import leverger.modele.Face;

public class VueDé {

	public Dé dé;
	public StackPane paneDé;
	public Circle cercle;
	public Polygon triangle;
	
	
	public VueDé(Dé dé, Color couleur) {
		this.dé = dé;
        this.cercle = generationCercle(couleur);
		this.triangle = generationTriangle();
        this.paneDé = new StackPane();
        this.paneDé.getChildren().addAll(triangle, cercle);
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
	public Circle generationCercle(Color couleur) {
		Circle cercle = new Circle(45, couleur);
		cercle.setTranslateY(30);
		return cercle;
	}
	
	public Polygon generationTriangle() {
		Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[] {
                100.0, 20.0,
                0.0, 200.0,
                200.0, 200.0
            });
        triangle.setStroke(Color.BLACK);
        triangle.setStrokeWidth(5);
        triangle.setFill(Color.WHITE);
        return triangle;
	}

	public void setFaceDuCercle(Face face) {
		
		
		if (face.getImage() != null) {
			ImageView imageView = new ImageView(face.getImage());
            imageView.setFitWidth(90);
            imageView.setFitHeight(90);
            imageView.setTranslateY(35);
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
        Node noeud;
        
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
	
	
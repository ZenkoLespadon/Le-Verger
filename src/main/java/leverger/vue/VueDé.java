package leverger.vue;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import leverger.contenu.Dé;

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
	//TODO CREER UN SETTER DE PANEDE POUR CHANGER LA COULEUR DU CERCLE 
	
	
}	
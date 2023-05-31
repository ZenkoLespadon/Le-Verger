package leverger.vue;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import leverger.modele.Puzzle;

public class VuePuzzle {
	public Puzzle puzzle;
	public StackPane conteneur;
	public Image image;
	
	public VuePuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
		this.conteneur = new StackPane();
		genererVue();
	}
	
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
	public StackPane getConteneur() {
		return this.conteneur;
	}
	
	public void genererVue() {
		int i;
		int j;
		int k = 0;
		
		GridPane gridPuzzle = new GridPane();
		gridPuzzle.setVgap(-1);

		ImageView corbeau = new ImageView(new Image("file:img/Puzzle.png"));
		corbeau.setFitWidth(300);
		corbeau.setFitHeight(250);

		this.conteneur.setMaxWidth(300);
		this.conteneur.setMaxHeight(250);
		this.conteneur.setMinWidth(300);
		this.conteneur.setMinHeight(250);

        gridPuzzle.setMinWidth(300);
        gridPuzzle.setMinHeight(250);
       
        
        for (i=0; i<3; i++) {
        	for (j=0; j<3; j++) {
        		if (this.puzzle.contientUnePiece(k)) {
        			ajouterRectangle(gridPuzzle, i, j, Color.TRANSPARENT);
        		}
        		else {
        			ajouterRectangle(gridPuzzle, i, j, Color.GREY);
        		}
        		k++;
        	}
        }
        this.conteneur.getChildren().add(corbeau);
        this.conteneur.getChildren().add(gridPuzzle);
	}
	
    private void ajouterRectangle(GridPane gridPane, int colonne, int ligne, Color couleur) {
        Rectangle rectangle = new Rectangle(gridPane.getMinWidth()/3, gridPane.getMinHeight()/3+1, couleur);
        gridPane.add(rectangle, colonne, ligne);
    } 
}

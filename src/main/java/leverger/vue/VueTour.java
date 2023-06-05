package leverger.vue;

import javafx.scene.control.Label;
import leverger.modele.Tour;

public class VueTour {
	private Tour tour;
	private Label label;
	
	public VueTour(Tour tour) {
		this.tour = tour;
		this.label = new Label("Tour 1");
		this.label.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: rgb(51, 102, 0);");
	}
	
	public void incrementerTour() {
		this.tour.incrementer();
		this.label.setText("Tour " + tour.getCompteurstr());
	}
	
	public Label getLabel() {
		return this.label;
	}
	public void cacherCompteur() {
		label.setVisible(false);
	}
	
	public int getCompteur() {
		return this.tour.getCompteurint();
	}
}

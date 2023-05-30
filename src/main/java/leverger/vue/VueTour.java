package leverger.vue;

import javafx.scene.control.Label;

public class VueTour {
	public Integer compteur;
	public Label label;
	public Tour tour;
	
	public VueTour() {
		this.compteur = 1;
		this.label = new Label("Tour 1");
		this.label.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: rgb(51, 102, 0);");
	}
	
	public void incrementer() {
		this.compteur = compteur + 1;
		label.setText("Tour " + compteur.toString());
	}

	
	public Integer getCompteur() {
		return this.compteur;
	}
	
	public Label getLabel() {
		return this.label;
	}
	public void cacherCompteur() {
		label.setVisible(false);
	}
	
}

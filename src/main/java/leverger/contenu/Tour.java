package leverger.contenu;

import javafx.scene.control.Label;

public class Tour {
	public Integer compteur;
	public Label labelTour;
	
	public Tour() {
		this.compteur = 1;
		this.labelTour = new Label();
		this.labelTour = new Label("Tour 1");
		this.labelTour.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: rgb(51, 102, 0);");
	}
	
	public void incrementer() {
		this.compteur = compteur + 1;
		setLabelTour(compteur);
	}
	
	public void setLabelTour(int tour) {
		this.labelTour.setText("Tour" + compteur.toString());
	}
	
	public Integer getCompteur() {
		return this.compteur;
	}
	
	public void cacherLabel() {
		this.labelTour.setVisible(false);
	}
	
}

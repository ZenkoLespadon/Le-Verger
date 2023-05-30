package leverger.modèle;

import javafx.scene.image.Image;

public enum Fruit {
	CERISE("Cerise", "Rouge", new Image("file:img/Cerise.png")),POIRE("Poire", "Jaune", new Image("file:img/Poire.png")),PRUNE("Prune", "Bleue", new Image("file:img/Prune.png")),POMME("Pomme", "Verte", new Image("file:img/Pomme.png"));

	public final String nom;
	public final String couleur;
	public final Image image;

	Fruit(String nom, String couleur, Image image) {
		this.nom = nom;
		this.couleur = couleur;
		this.image = image;
	}

	public String getNom() {
		return this.nom;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
}
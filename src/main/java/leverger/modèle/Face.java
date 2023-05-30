package leverger.modèle;

import javafx.scene.paint.Color;

public enum Face {
	ROUGE(Color.RED, "Rouge"),JAUNE(Color.YELLOW, "Jaune"),BLEUE(Color.BLUE, "Bleue"),VERTE(Color.GREEN, "Verte");

	public final Color couleur;
	public final String nom;

	Face(Color couleur, String nom) {
		this.couleur = couleur;
		this.nom = nom;
	}

	public Color getCouleur() {
		return couleur;
	}
}

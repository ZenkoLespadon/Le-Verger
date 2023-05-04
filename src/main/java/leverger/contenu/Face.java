package leverger.contenu;

import javafx.scene.paint.Color;

public enum Face {
	ROUGE(Color.RED),JAUNE(Color.YELLOW),BLEUE(Color.BLUE),VERTE(Color.GREEN);

	public final Color couleur;

	Face(Color couleur) {
		this.couleur = couleur;
	}

	public Color getCouleur() {
		return couleur;
	}
}

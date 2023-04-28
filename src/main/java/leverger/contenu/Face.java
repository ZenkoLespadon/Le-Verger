package leverger.contenu;

public enum Face {
	ROUGE("Rouge"),JAUNE("Jaune"),BLEUE("Bleue"),VERTE("Verte");

	private final String couleur;

	Face(String couleur) {
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}
}

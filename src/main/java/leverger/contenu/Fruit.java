package leverger.contenu;

public enum Fruit {
	CERISE("Cerise", "Rouge"),POIRE("Poire", "Jaune"),PRUNE("Prune", "Bleue"),POMME("Pomme", "Verte");

	private final String nom;
	private final String couleur;

	Fruit(String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}

	public String getNom() {
		return this.nom;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
}
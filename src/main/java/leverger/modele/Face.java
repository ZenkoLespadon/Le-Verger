package leverger.modele;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public enum Face {
    ROUGE(Color.RED, "Rouge", null),
    JAUNE(Color.YELLOW, "Jaune", null),
    BLEUE(Color.BLUE, "Bleue", null),
    VERTE(Color.GREEN, "Verte", null),
    CORBEAU(null, "Noire", new Image("file:img/Corbeau.png"));

    private final Color couleur;
    private final String nom;
    private final Image image;

    Face(Color couleur, String nom, Image image) {
        this.couleur = couleur;
        this.nom = nom;
        this.image = image;
    }
    
    public String getNom() {
    	return this.nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public Image getImage() {
        return image;
    }
    
}

package leverger.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import leverger.modele.Fruit;

public class VueFruit {
	private Fruit fruit;
	private Image image;
	
	public VueFruit(Fruit fruit, Image image) {
		this.fruit = fruit;
		this.image = image;
	}
	
	public ImageView genererVue() {
		return new ImageView(image);
	}
	
	public Fruit getFruit() {
		return this.fruit;
	}
	
	public Image getImage() {
		return this.image;
	}
}

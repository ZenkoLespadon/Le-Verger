package leverger.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import leverger.modele.Fruit;

public class VueFruit {
	Fruit fruit;
	Image image;
	
	public VueFruit(Fruit fruit, Image image) {
		this.fruit = fruit;
		this.image = image;
	}
	
	public ImageView genererVue() {
		ImageView imageview = new ImageView(image);
		return imageview;
	}
}

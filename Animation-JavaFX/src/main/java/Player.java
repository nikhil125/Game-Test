import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Nikhil on 11/12/2016.
 */
public class Player {
	ImageView imageView;
	int width, height;

	Player(String path, int width, int height) {
		this.imageView = new ImageView(new Image(path));
		this.width = width;
		this.height = height;
	}

	public void render(int x, int y, GraphicsContext scene) {
		imageView.setViewport(new Rectangle2D(x, y, width, height));

//		context.setGlobalAlpha(life);
		scene.drawImage(imageView.getImage(), x, y);
	}
}

import javafx.geometry.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 11/27/2016.
 */
public class FireEmitter extends Emitter {
	List<Particle> emit(int x, int y) {
		List<Particle> result = new ArrayList<Particle>();
		for (int i = 0; i < 15; i++) {
			result.add(new Particle(x, y, new Point2D(Math.random() -.4, (Math.random()- .8)*5), 5, Color.rgb(240, 140, 24, .5), BlendMode.ADD, 1));
		}
		return result;
	}
}

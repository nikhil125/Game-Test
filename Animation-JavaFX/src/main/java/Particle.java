import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Paint;


/**
 * Created by Nikhil on 11/12/2016.
 */
public class Particle {
	private double x, y;

	private Point2D velocity;

	private double radius;
	private Paint color;
	private BlendMode blendMode;
	private double life = 1.0;
	private double decay;

	public Particle(double x, double y, Point2D velocity, double radius, Paint color, BlendMode blendMode, double expiration) {
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.radius = radius;
		this.color = color;
		this.blendMode = blendMode;
		this.decay = 0.016 / expiration;
	}

	public boolean isAlive() {
		return life > 0.0;
	}

	public void update() {
		x += velocity.getX();
		y += velocity.getY();

		life -= decay;
	}

	public void render(GraphicsContext context) {
		context.setGlobalAlpha(life);
		context.setGlobalBlendMode(blendMode);
		context.setFill(color);
		context.fillOval(x, y, radius, radius);
	}
}

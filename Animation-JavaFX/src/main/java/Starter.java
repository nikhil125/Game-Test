import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Nikhil on 11/12/2016.
 */
public class Starter extends Application {
	private int width = 600;
	private int height = 600;
	private int x, y = 0;
	private GraphicsContext context;
	private Particle particle;

	@Override
	public void init() throws Exception {
		super.init();

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		root.setPrefSize(width, height);

		Canvas main = new Canvas(width, height);
		context = main.getGraphicsContext2D();
		root.getChildren().addAll(main);
		Scene scene = new Scene(root, width, height);
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX");
		primaryStage.show();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				update();
			}
		};
		timer.start();
	}

	private void update() {
		context.setGlobalAlpha(1.0);
		context.setGlobalBlendMode(BlendMode.SRC_OVER);
//		context.setFill(Color.BLACK);
//		context.fillRect(0, 0, 600, 600);
		if (y > 600) {
			y = 0;
		}
		if(x > 600)
			x =  0;
//		particles.addAll(emitter.emit(x, y++));
//		particles.addAll(emitter.emit(x-20, y++ +10));
//		particles.addAll(emitter.emit(x+30, y++-20));
//		for (Iterator<Particle> iter = particles.iterator(); iter.hasNext(); ) {
//		Particle p = new Particle(x++, y++, new Point2D(x + 5, y + 5), 5, Color.rgb(240, 140, 24, .5), BlendMode.ADD, 2);
		Player player = new Player("/skeleton-2.png",16, 16);
//		p.update();
//		if (p.isAlive())
//			p.render(context);

		player.render(x++, y++ , context);
	}


	public static void main(String[] args) {
		launch(args);
	}

}

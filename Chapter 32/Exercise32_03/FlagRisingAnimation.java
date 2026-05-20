/**
 * Author: Sean Briggs
 * Date: 2026-05-20
 * 
 * Description: Use a thread to play an animation of a rising flag
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Add an image view and add it to pane
		ImageView imageView = new ImageView("image/us.gif");
		pane.getChildren().add(imageView);

		PathAnimationTask animationTask = new PathAnimationTask(Duration.millis(10000),
			5, new Line(100, 200, 100, 0), imageView);
		new Thread(animationTask).start(); // Create a thread to run the animation

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

class PathAnimationTask implements Runnable {
	private final Node node;
	private final Duration duration;
	private final Line path;
	private final int cycles;
	private double positionX;
	private double positionY;

	public PathAnimationTask(Duration duration, int cycles, Line path, Node node) {
		this.duration = duration;
		this.cycles = cycles;
		this.path = path;
		this.node = node;
	}

	@Override
	public void run() {
		try {
			final double pathLength = Math.sqrt(Math.pow(path.getStartX() - path.getEndX(), 2)
				+ Math.pow(path.getStartY() - path.getEndY(), 2));
			final long delayTime = (long)(duration.toMillis() / pathLength);
			final double incrementX = (path.getEndX() - path.getStartX()) / pathLength;
			final double incrementY = (path.getEndY() - path.getStartY()) / pathLength;
			Bounds bounds = node.getLayoutBounds();

			for (int i = 0; i < cycles; i++) {
				positionX = path.getStartX();
				positionY = path.getStartY();
				while (Math.abs(positionX - path.getEndX()) > 0.001 || Math.abs(positionY - path.getEndY()) > 0.001) {
					positionX += incrementX;
					positionY += incrementY;
					Platform.runLater(() -> {
						node.setLayoutX(positionX - bounds.getWidth() / 2);
						node.setLayoutY(positionY - bounds.getHeight() / 2);
					});
					Thread.sleep(delayTime);
				}
				Thread.sleep(200);
			}
		}
		catch (InterruptedException ex) {}
	}
}
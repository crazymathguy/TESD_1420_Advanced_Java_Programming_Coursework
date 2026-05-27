import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Side;
import javafx.geometry.Pos;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		TabPane tabPane = new TabPane();
		Tab tab1 = new Tab("Line");
		StackPane pane1 = new StackPane();
		pane1.getChildren().add(new Line(10, 10, 80, 80));
		tab1.setContent(pane1);
		Tab tab2 = new Tab("Rectangle");
		tab2.setContent(new Rectangle(10, 10, 200, 200));
		Tab tab3 = new Tab("Circle");
		tab3.setContent(new Circle(50, 50, 20));
		Tab tab4 = new Tab("Ellipse");
		tab4.setContent(new Ellipse(10, 10, 100, 80));
		tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
		tabPane.setSide(Side.TOP);

		HBox buttonRow = new HBox();
		buttonRow.setAlignment(Pos.CENTER);
		ToggleGroup group = new ToggleGroup();

		RadioButton topButton = new RadioButton("Top");
		topButton.setToggleGroup(group);
		topButton.setOnAction(event -> tabPane.setSide(Side.TOP));
		RadioButton leftButton = new RadioButton("Left");
		leftButton.setToggleGroup(group);
		leftButton.setOnAction(event -> tabPane.setSide(Side.LEFT));
		RadioButton bottomButton = new RadioButton("Bottom");
		bottomButton.setToggleGroup(group);
		bottomButton.setOnAction(event -> tabPane.setSide(Side.BOTTOM));
		RadioButton rightButton = new RadioButton("Right");
		rightButton.setToggleGroup(group);
		rightButton.setOnAction(event -> tabPane.setSide(Side.RIGHT));

		buttonRow.getChildren().addAll(topButton, leftButton, bottomButton, rightButton);

		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(tabPane);
		mainPane.setBottom(buttonRow);

		Scene scene = new Scene(mainPane, 300, 250);
		primaryStage.setTitle("DisplayFigure"); // Set the window title
		primaryStage.setScene(scene); // Place the scene in the window
		primaryStage.show(); // Display the window
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 * line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Exercise31_17 extends Application{
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Exercise31_17");
			primaryStage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		launch(args);
	}
}

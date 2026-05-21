import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise33_09Client extends Application {
	private TextArea taServer = new TextArea();
	private TextArea taClient = new TextArea();

	private BufferedReader fromServer;
	private PrintWriter toServer;
	private String host = "localhost";
 
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		taServer.setWrapText(true);
		taClient.setWrapText(true);
		taServer.setDisable(true);

		taClient.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				String message = "C: " + taClient.getText();
				toServer.println(message);
				taServer.appendText(message);
				taClient.clear();
			}
		});

		BorderPane pane1 = new BorderPane();
		pane1.setTop(new Label("History"));
		pane1.setCenter(new ScrollPane(taServer));
		BorderPane pane2 = new BorderPane();
		pane2.setTop(new Label("New Message"));
		pane2.setCenter(new ScrollPane(taClient));
		
		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(pane1, pane2);

		// Create a scene and place it in the stage
		Scene scene = new Scene(vBox, 200, 200);
		primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				Socket socket = new Socket(host, 8000);

				fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				toServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

				while (true) {
					String message = fromServer.readLine().trim();
					Platform.runLater(() -> taServer.appendText(message));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}).start();
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

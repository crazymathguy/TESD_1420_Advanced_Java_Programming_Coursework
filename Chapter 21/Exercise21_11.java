/**
 * Author: Sean Briggs
 * Date: 2026-05-18
 * 
 * Description: Use maps of boys and girls names to determine how popular names were
 */

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
	private Map<String, Integer>[] mapForBoy = new HashMap[10];
	private Map<String, Integer>[] mapForGirl = new HashMap[10];
	
	private Button btFindRanking = new Button("Find Ranking");
	private ComboBox<Integer> cboYear = new ComboBox<>();
	private ComboBox<String> cboGender = new ComboBox<>();
	private TextField tfName = new TextField();
	private Label lblResult = new Label();
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		try {
			fillArrays();
		} catch (Exception e) {
			e.printStackTrace();
		}

		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Select a year:"), 0, 0);
		gridPane.add(new Label("Boy or girl?"), 0, 1);
		gridPane.add(new Label("Enter a name:"), 0, 2);
		gridPane.add(cboYear, 1, 0);
		gridPane.add(cboGender, 1, 1);
		gridPane.add(tfName, 1, 2);
		gridPane.add(btFindRanking, 1, 3);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
	
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(gridPane);
		borderPane.setBottom(lblResult);
		BorderPane.setAlignment(lblResult, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 370, 160);
		primaryStage.setTitle("Exercise21_11"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		for (int year = 2001; year <= 2010; year++) {
			cboYear.getItems().add(year);
		}
		cboYear.setValue(2001);
				
		cboGender.getItems().addAll("Male", "Female");
		cboGender.setValue("Male");

		btFindRanking.setOnAction(e -> {
			int year = cboYear.getValue();
			String gender = cboGender.getValue();
			String name = tfName.getText();
			Integer rank = findRanking(year, gender, name);
			String message = " name " + name + " is ranked #" + rank + " in year " + year;
			if (rank != null) {
				message = (gender.equals("Male") ? "Boy" : "Girl") + message;
			} else {
				message = "Name not found";
			}
			lblResult.setText(message);
		});
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	private void fillArrays() throws Exception {
		for (int i = 0; i < 10; i++) {
			Map<String, Integer> boysMap = new HashMap<>();
			Map<String, Integer> girlsMap = new HashMap<>();
			String path = "https://liveexample.pearsoncmg.com/data/babynamesranking"+(i + 2001)+".txt";
			// Use URI to avoid deprecated URL constructor
			URL url = URI.create(path).toURL();
			
			try(Scanner s = new Scanner(url.openStream())) {
				while (s.hasNextLine()) {
					String[] words = s.nextLine().split("[\\s+\\p{P}]");
					boysMap.put(words[2], Integer.valueOf(words[0]));
					girlsMap.put(words[5], Integer.valueOf(words[0]));
				}
				mapForBoy[i] = boysMap;
				mapForGirl[i] = girlsMap;
			}
		}
	}

	private Integer findRanking(Integer year, String gender, String name) {
		if (gender.equals("Male")) {
			return mapForBoy[year - 2001].get(name);
		} else {
			return mapForGirl[year - 2001].get(name);
		}
	}
}

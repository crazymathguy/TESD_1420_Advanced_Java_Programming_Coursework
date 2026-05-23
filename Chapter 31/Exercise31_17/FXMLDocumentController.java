import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.application.Platform;

public class FXMLDocumentController {
	@FXML private TextField amountField;
	@FXML private TextField yearsField;
	@FXML private TextField rateField;
	@FXML private TextField futureField;

	@FXML
	private void handleCalculate(ActionEvent event) {
		System.out.println("You clicked me!");
		double investmentAmount = Double.parseDouble(amountField.getText());
		int years = Integer.parseInt(yearsField.getText());
		double interestRate = Double.parseDouble(rateField.getText()) / 100.0;
		double futureValue = investmentAmount * Math.pow(1 + interestRate, years);
		futureField.setText(String.format("$%.2f", futureValue));
	}

	@FXML
	private void handleExit(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
}
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MetricConverter extends Application {

    private ComboBox<String> unitType;
    private TextField inputField;
    private Label outputLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        // Create UI elements
        unitType = new ComboBox<>();
        unitType.getItems().addAll("Meters", "Kilometers", "Centimeters", "Millimeters");
        unitType.setValue("Meters");

        inputField = new TextField();

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> convert());

        outputLabel = new Label();

        // Create layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);

        layout.add(new Label("Unit Type:"), 0, 0);
        layout.add(unitType, 1, 0);
        layout.add(new Label("Input Value:"), 0, 1);
        layout.add(inputField, 1, 1);
        layout.add(convertButton, 2, 1);
        layout.add(new Label("Converted Value:"), 0, 2);
        layout.add(outputLabel, 1, 2);

        // Create scene
        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convert() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String selectedUnitType = unitType.getValue();

            // Convert to meters
            double meters = 0.0;
            switch (selectedUnitType) {
                case "Meters":
                    meters = inputValue;
                    break;
                case "Kilometers":
                    meters = inputValue * 1000;
                    break;
                case "Centimeters":
                    meters = inputValue / 100;
                    break;
                case "Millimeters":
                    meters = inputValue / 1000;
                    break;
            }

            // Convert from meters
            double convertedValue = 0.0;
            switch (selectedUnitType) {
                case "Meters":
                    convertedValue = meters;
                    break;
                case "Kilometers":
                    convertedValue = meters / 1000;
                    break;
                case "Centimeters":
                    convertedValue = meters * 100;
                    break;
                case "Millimeters":
                    convertedValue = meters * 1000;
                    break;
            }

            outputLabel.setText(String.format("%.2f", convertedValue));
        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package application;

/* 
Jeffrey Janvier
COP2805 - Homework #3_1
1/31/2022
This program calculates the Body Mass Index(BMI) of an adult. It lets the user enter the
height (in feet and inches) and the weight (in pounds), and then click the "Calculate BMI"
button to obtain the BMI value.
*/

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BMIcalculator extends Application {
	
	private TextField tfYourHeight_ft = new TextField();
	private TextField tfYourHeight_in = new TextField();
	private TextField tfYourWeight_lbs = new TextField();
	private TextField tfBMI = new TextField();
	private Button btCalculateBMI = new Button("Calculate BMI");
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create GUI
		GridPane gridPane = new GridPane();
		gridPane.setHgap(20);
		gridPane.setVgap(5);
		gridPane.add(new Label("Your height:"), 0,0);
		gridPane.add(tfYourHeight_ft, 1, 0);
		gridPane.add(new Label("ft."), 2, 0);
		gridPane.add(tfYourHeight_in, 1,1);
		gridPane.add(new Label("in."), 2, 1);
		gridPane.add(new Label("Your weight:"), 0,2);
		gridPane.add(tfYourWeight_lbs, 1,2);
		gridPane.add(new Label("lbs."), 2, 2);
		gridPane.add(new Label("BMI"), 0,3);
		gridPane.add(tfBMI, 1,3);
		gridPane.add(btCalculateBMI, 1,4);
		
		// Set properties for GUI
		gridPane.setAlignment(Pos.CENTER);
		tfYourHeight_ft.setAlignment(Pos.BOTTOM_RIGHT);
		tfYourHeight_in.setAlignment(Pos.BOTTOM_RIGHT);
		tfYourWeight_lbs.setAlignment(Pos.BOTTOM_RIGHT);
		tfBMI.setAlignment(Pos.BOTTOM_RIGHT);
		tfBMI.setEditable(false);
		GridPane.setHalignment(btCalculateBMI,HPos.LEFT);
		
		// Process events
		btCalculateBMI.setOnAction(e -> calculateBMI(gridPane));
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(gridPane, 375, 250);
		primaryStage.setTitle("BMI Calculator"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	private void calculateBMI(GridPane gridPane) {
		// Get the values from the text field
		double feet = Double.parseDouble(tfYourHeight_ft.getText());
		double inches = Double.parseDouble(tfYourHeight_in.getText());
		double pounds = Double.parseDouble(tfYourWeight_lbs.getText());
		
		// Calculates and display the BMI of the user
		feet *= 12; // Convert feet to inches
		inches += feet; // Adding the feet to inches
		double totalBMI = pounds / Math.pow(inches, 2) * 703;
		tfBMI.setText(String.format("%.2f", totalBMI));
		
		// Display to the user if they are underweight, healthy, overweight or obese
		if (totalBMI < 18.50) 
			gridPane.add(new Label("You are underweight"), 0, 5);
		else if(totalBMI >= 18.50 && totalBMI < 25.00)
			gridPane.add(new Label("You are healthy"), 0, 5);
		else if(totalBMI >= 25.00 && totalBMI < 30.00)
			gridPane.add(new Label("You are overweight"), 0, 5);
		else
			gridPane.add(new Label("You are obese"), 0, 5);
	}
	public static void main(String[] args) {
		launch(args);

	}

}

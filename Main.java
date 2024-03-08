/*
 * Program Name: M08FinalProject.java
 * Author: Julian Fuentes
 * Date Last Updated: 02 March 2024
 * Purpose: This program will run a burger ordering simulation for the user.
 */
package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application 
{
	private double totalPrice = 0.0;
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("Burger Shack");
		//This should title the application.
		
		VBox meatSelection = new VBox();
		meatSelection.setSpacing(10);
	    ToggleGroup meatGroup = new ToggleGroup();
	    RadioButton beefRadio = new RadioButton("Beef ($5.00)");
	    RadioButton chickenRadio = new RadioButton("Chicken ($5.00)");
	    beefRadio.setToggleGroup(meatGroup);
	    chickenRadio.setToggleGroup(meatGroup);
	    meatSelection.getChildren().addAll(new Label("Meat Selection"), 
	    		beefRadio, chickenRadio);
	    //This should cover the meat selection of the GUI.
	    
	    VBox friesSelection = new VBox();
        friesSelection.setSpacing(10);
        ToggleGroup friesGroup = new ToggleGroup();
        RadioButton halfOrderRadio = new RadioButton("Half-order (No Additional Cost)");
        RadioButton fullOrderRadio = new RadioButton("Full-order ($1.00)");
        RadioButton doubleOrderRadio = new RadioButton("Double-order ($2.00)");
        halfOrderRadio.setToggleGroup(friesGroup);
        fullOrderRadio.setToggleGroup(friesGroup);
        doubleOrderRadio.setToggleGroup(friesGroup);
        friesSelection.getChildren().addAll(new Label("Fries"), 
        		halfOrderRadio, fullOrderRadio, doubleOrderRadio);
        //This should cover the fries selection of the GUI.
        
        VBox condimentsSelection = new VBox();
        condimentsSelection.setSpacing(10);
        CheckBox ketchupCheck = new CheckBox("Ketchup ($0.50)");
        CheckBox mustardCheck = new CheckBox("Mustard ($0.50)");
        CheckBox tomatoesCheck = new CheckBox("Tomatoes ($0.50)");
        CheckBox lettuceCheck = new CheckBox("Lettuce ($0.50)");
        condimentsSelection.getChildren().addAll(new Label("Condiments"), 
        		ketchupCheck, mustardCheck, tomatoesCheck, lettuceCheck);
        //This should cover the condiments selection of the GUI.
        
        VBox drinkSelection = new VBox();
        drinkSelection.setSpacing(10);
        ToggleGroup drinkGroup = new ToggleGroup();
        RadioButton cokeRadio = new RadioButton("Coke ($1.50)");
        RadioButton spriteRadio = new RadioButton("Sprite ($1.50)");
        RadioButton lemonadeRadio = new RadioButton("Lemonade ($1.50)");
        RadioButton teaRadio = new RadioButton("Sweet Tea ($1.50)");
        cokeRadio.setToggleGroup(drinkGroup);
        spriteRadio.setToggleGroup(drinkGroup);
        lemonadeRadio.setToggleGroup(drinkGroup);
        teaRadio.setToggleGroup(drinkGroup);
        drinkSelection.getChildren().addAll(new Label("Drink Choice"), 
        		cokeRadio, spriteRadio, lemonadeRadio, teaRadio);
        //This should cover the drinks selection of the GUI.
        
        Label totalPriceLabel = new Label("Total Price: $0.00");
        //This should set the starting price at $0.00.
        
        Button clearButton = new Button("Clear");
        Button submitButton = new Button("Submit");
        HBox buttonsBox = new HBox(10);
        buttonsBox.getChildren().addAll(clearButton, submitButton);
        //This should set the buttons for the GUI.
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(20);
        grid.add(meatSelection, 0, 0);
        grid.add(friesSelection, 1, 0);
        grid.add(condimentsSelection, 2, 0);
        grid.add(drinkSelection, 3, 0);
        grid.add(totalPriceLabel, 0, 1, 4, 1);
        grid.add(buttonsBox, 0, 2, 4, 1);
        //This should create the layout for the GUI.
        
        clearButton.setOnAction(event-> 
        {
        	totalPrice = 0.0;
           	totalPriceLabel.setText("Total Price: $0.00");
        });
        //This should set the price to $0.00 if the clear button is pressed.
        
        submitButton.setOnAction(event-> 
        {
        	Stage thankYouStage = new Stage();
           	thankYouStage.setTitle("Thank You!");
           	VBox thankYouLayout = new VBox(10);
           	thankYouLayout.setPadding(new Insets(20));
           	thankYouLayout.getChildren().add(new Label("Thank you for your order!"));
           	Scene scene = new Scene(thankYouLayout, 200, 100);
           	thankYouStage.setScene(scene);
           	thankYouStage.show();
        });
        //This should show up if the submit button is pressed.
        
        beefRadio.setOnAction(event-> 
        {
        	if (beefRadio.isSelected()) 
            {
                totalPrice += 5.00;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });

        chickenRadio.setOnAction(event-> 
        {
            if (chickenRadio.isSelected()) 
            {
                totalPrice += 5.00;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });
        //This should cover the meat selection options.
        
        fullOrderRadio.setOnAction(event-> 
        {
            if (fullOrderRadio.isSelected()) 
            {
                totalPrice += 1.00;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });

        doubleOrderRadio.setOnAction(event-> 
        {
            if (doubleOrderRadio.isSelected()) 
            {
                totalPrice += 2.00;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });
        //This should cover the fries selection options.
        
        ketchupCheck.setOnAction(event-> 
        {
            if (ketchupCheck.isSelected()) 
            {
                totalPrice += 0.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });

        mustardCheck.setOnAction(event-> 
        {
            if (mustardCheck.isSelected()) 
            {
                totalPrice += 0.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });

        tomatoesCheck.setOnAction(event-> 
        {
            if (tomatoesCheck.isSelected()) 
            {
                totalPrice += 0.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });

        lettuceCheck.setOnAction(event-> 
        {
            if (lettuceCheck.isSelected()) 
            {
                totalPrice += 0.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });
        //The should cover the condiments options in the GUI.
        
        cokeRadio.setOnAction(event-> 
        {
            if (cokeRadio.isSelected()) 
            {
                totalPrice += 1.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });

        spriteRadio.setOnAction(event-> 
        {
            if (spriteRadio.isSelected()) 
            {
                totalPrice += 1.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });

        lemonadeRadio.setOnAction(event-> 
        {
            if (lemonadeRadio.isSelected()) 
            {
                totalPrice += 1.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });
 
        teaRadio.setOnAction(event-> 
        {
            if (teaRadio.isSelected()) 
            {
                totalPrice += 1.50;
                totalPriceLabel.setText("Total Price: $" 
                + String.format("%.2f", totalPrice));
            }
        });
        //This should cover the drinks options for the GUI.

        Scene scene = new Scene(grid, 700, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

	    
	}
	public static void main(String[] args) {
		launch(args);
	}
}

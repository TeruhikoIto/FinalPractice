import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class Calculator extends Application
{
	Label lblNo1 = new Label("Enter no 1:");
	Label lblNo2 = new Label("Enter no 2:");
	Label lblResult = new Label("Result:");
	TextField tfNo1 = new TextField();
	TextField tfNo2 = new TextField();
	TextField tfResult = new TextField();
	RadioButton btnAdd = new RadioButton("Add");
	RadioButton btnSubtract = new RadioButton("Subtract");
	RadioButton btnMultiply = new RadioButton("Multiply");
	RadioButton btnDivide = new RadioButton("Divide");
	
	@Override
	public void start(Stage primaryStage)
	{
		tfResult.setEditable(false);
		ToggleGroup group = new ToggleGroup();
		btnAdd.setToggleGroup(group);
		btnAdd.setSelected(true);
		btnSubtract.setToggleGroup(group);
		btnMultiply.setToggleGroup(group);
		btnDivide.setToggleGroup(group);
		Button btnCalculate = new Button("Calculate");
		tfNo1.setAlignment(Pos.CENTER_RIGHT);
		tfNo2.setAlignment(Pos.CENTER_RIGHT);
		tfResult.setAlignment(Pos.CENTER_RIGHT);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(30,30,30,30));
		gridpane.setHgap(25);
		gridpane.setVgap(15);
		gridpane.add(btnAdd, 0, 0);
		gridpane.add(btnSubtract, 0, 1);
		gridpane.add(btnMultiply, 0, 2);
		gridpane.add(btnDivide, 0, 3);
		gridpane.add(lblNo1, 1, 0);
		gridpane.add(lblNo2, 1, 1);
		gridpane.add(lblResult, 1, 3);
		gridpane.add(tfNo1, 2, 0);
		gridpane.add(tfNo2, 2, 1);
		gridpane.add(tfResult, 2, 3);
		gridpane.add(btnCalculate, 2, 2);
		GridPane.setHalignment(lblNo1, HPos.RIGHT);
		GridPane.setHalignment(lblNo2, HPos.RIGHT);
		GridPane.setHalignment(lblResult, HPos.RIGHT);
		GridPane.setHalignment(btnCalculate, HPos.CENTER);
		btnCalculate.setOnAction((e) -> calculatation());
		Scene scene = new Scene(gridpane);
		primaryStage.setTitle("CENTTENIAL JavaFX CALCULATOR");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	private void calculatation()
	{
		double tfno1 = 0;
		double tfno2 = 0;
		double result;
		try
		{
			tfno1 = Double.parseDouble(tfNo1.getText());
			tfno2 = Double.parseDouble(tfNo2.getText());
		}
		catch(NumberFormatException error)
		{
			System.out.println("Please enter numbers!!");
		}		
		if(btnAdd.isSelected())
		{
			result = tfno1 + tfno2;
			tfResult.setText(Double.toString(result));
		}
		else if(btnSubtract.isSelected())
		{
			result = tfno1 - tfno2;
			tfResult.setText(Double.toString(result));
		}
		else if(btnMultiply.isSelected())
		{
			result = tfno1 * tfno2;
			tfResult.setText(Double.toString(result));
		} 
		else if(btnDivide.isSelected())
		{
			result = tfno1 / tfno2;
			tfResult.setText(Double.toString(result));
		}			
	}
}

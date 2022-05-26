package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainViewController implements Initializable{

	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btnClear;
	@FXML
	private Button btnAddition;
	@FXML
	private Button btnSubtraction;
	@FXML
	private Button btnMultiplication;
	@FXML
	private Button btnDivision;
	@FXML
	private Button btnEquals;
	@FXML
	private TextField txtResult;
	
	@FXML
	public void onBtn0Action() {
		System.out.println("0");
	}
	
	@FXML
	public void onBtn1Action() {
		System.out.println("1");
	}
	
	@FXML
	public void onBtn2Action() {
		System.out.println("2");
	}
	
	@FXML
	public void onBtn3Action() {
		System.out.println("3");
	}
	
	@FXML
	public void onBtn4Action() {
		System.out.println("4");
	}
	
	@FXML
	public void onBtn5Action() {
		System.out.println("5");
	}
	
	@FXML
	public void onBtn6Action() {
		System.out.println("6");
	}
	
	@FXML
	public void onBtn7Action() {
		System.out.println("7");
	}
	
	@FXML
	public void onBtn8Action() {
		System.out.println("8");
	}
	
	@FXML
	public void onBtn9Action() {
		System.out.println("9");
	}
	
	@FXML
	public void onBtnClearAction() {
		System.out.println("Clear");
	}
	
	@FXML
	public void onBtnAdditionAction() {
		System.out.println("Addition");
	}
	
	@FXML
	public void onBtnSubtractionAction() {
		System.out.println("Subtration");
	}
	
	@FXML
	public void onBtnMultiplicationAction() {
		System.out.println("Multiplication");
	}
	
	@FXML
	public void onBtnDivisionAction() {
		System.out.println("Division");
	}
	
	@FXML
	public void onBtnEqualsAction() {
		System.out.println("Equals");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	
	
}

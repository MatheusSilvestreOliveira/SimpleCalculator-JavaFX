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
	private Button btnErase;
	@FXML
	private TextField txtResult;
	
	@FXML
	public void onBtn0Action() {
		addToTxtResult("0");
	}
	
	@FXML
	public void onBtn1Action() {
		addToTxtResult("1");
	}
	
	@FXML
	public void onBtn2Action() {
		addToTxtResult("2");
	}
	
	@FXML
	public void onBtn3Action() {
		addToTxtResult("3");
	}
	
	@FXML
	public void onBtn4Action() {
		addToTxtResult("4");
	}
	
	@FXML
	public void onBtn5Action() {
		addToTxtResult("5");
	}
	
	@FXML
	public void onBtn6Action() {
		addToTxtResult("6");
	}
	
	@FXML
	public void onBtn7Action() {
		addToTxtResult("7");
	}
	
	@FXML
	public void onBtn8Action() {
		addToTxtResult("8");
	}
	
	@FXML
	public void onBtn9Action() {
		addToTxtResult("9");
	}
	
	@FXML
	public void onBtnClearAction() {
		setTxtResultClear();
	}
	
	@FXML
	public void onBtnAdditionAction() {
		addToTxtResult("+");
	}
	
	@FXML
	public void onBtnSubtractionAction() {
		addToTxtResult("-");
	}
	
	@FXML
	public void onBtnMultiplicationAction() {
		addToTxtResult("*");
	}
	
	@FXML
	public void onBtnDivisionAction() {
		addToTxtResult("/");
	}
	
	@FXML
	public void onBtnEqualsAction() {
		System.out.println(getTxtResult());
	}
	
	@FXML
	public void onBtnEraseAction() {
		txtResult.setText(txtResult.getText().substring(0, txtResult.getText().length()-1));
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
	}

	private String getTxtResult() {
		return txtResult.getText();
	}
	
	private void addToTxtResult(String x) {
		txtResult.setText(txtResult.getText()+x);
	}
	
	private void setTxtResultClear() {
		txtResult.setText("");
	}
	
	
}

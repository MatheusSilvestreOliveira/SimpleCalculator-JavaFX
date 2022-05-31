package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.Calculation;
import services.MainViewService;
import util.Constraints;

public class MainViewController implements Initializable{

	private MainViewService service = new MainViewService();
	Locale locale = new Locale("en", "US");
	
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
	private Button btnDot;
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
	public void onBtnDotAction() {
		if(txtResult.getText().length() == 0) {
			addToTxtResult("0");
		}
		if(!service.alreadyHasDot(txtResult.getText())) {
			addToTxtResult(".");
		}
	}
	
	@FXML
	public void onBtnClearAction() {
		setTxtResultClear();
	}
	
	@FXML
	public void onBtnAdditionAction() {
		if(txtResult.getText().length() != 0) {
			if(service.lastIsDot(txtResult.getText())) {
				addToTxtResult("0");
			}
			if(!service.lastIsOperation(txtResult.getText())) {
				addToTxtResult("+");
			}
		}
	}
	
	@FXML
	public void onBtnSubtractionAction() {
		if(txtResult.getText().length() != 0) {
			if(service.lastIsDot(txtResult.getText())) {
				addToTxtResult("0");
			}
			if(!service.lastIsOperation(txtResult.getText())) {
				addToTxtResult("-");
			}
		}
		
	}
	
	@FXML
	public void onBtnMultiplicationAction() {
		if(txtResult.getText().length() != 0) {
			if(service.lastIsDot(txtResult.getText())) {
				addToTxtResult("0");
			}
			if(!service.lastIsOperation(txtResult.getText())) {
				addToTxtResult("*");
			}
		}
	}
	
	@FXML
	public void onBtnDivisionAction() {
		if(txtResult.getText().length() != 0) {
			if(service.lastIsDot(txtResult.getText())) {
				addToTxtResult("0");
			}
			if(!service.lastIsOperation(txtResult.getText())) {
				addToTxtResult("/");
			}
		}
	}
	
	@FXML
	public void onBtnEraseAction() {
		if(txtResult.getText().length() != 0) {
			txtResult.setText(txtResult.getText().substring(0, txtResult.getText().length()-1));
		}
	}
	
	@FXML
	public void onBtnEqualsAction() {
		Locale.setDefault(locale);
		
		if(service.lastIsDot(txtResult.getText())) {
			addToTxtResult("0");
		}
		if(service.lastIsOperation(txtResult.getText())) {
			onBtnEraseAction();
		}
		
		Calculation calc = new Calculation(txtResult.getText());
		System.out.println(calc.getAnswer());
		txtResult.setText(String.format("%,.2f", calc.getAnswer()));
		//txtResult.setText(Double.toString(calc.getAnswer()));
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldNumbersAndOperators(txtResult);
		Constraints.setTextFieldMaxLength(txtResult, 30);
		Constraints.setTextFieldNoSymbols(txtResult);
	}
	
	private void addToTxtResult(String txt) {
		txtResult.setText(txtResult.getText()+txt);
	}
	
	private void setTxtResultClear() {
		txtResult.setText("");
	}
}

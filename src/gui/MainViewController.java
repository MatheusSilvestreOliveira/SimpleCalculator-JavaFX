package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	private Button btnBracket;
	@FXML
	private Button btnNegOrPos;
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
	private Button btnPercent;
	@FXML
	private Button btnEquals;
	@FXML
	private Button btnChangeDec;
	@FXML
	private Button btnErase;
	@FXML
	private TextField txtResult;
	
	@FXML
	public void onBtn0Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("0");
	}
	
	@FXML
	public void onBtn1Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("1");
	}
	
	@FXML
	public void onBtn2Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("2");
	}
	
	@FXML
	public void onBtn3Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("3");
	}
	
	@FXML
	public void onBtn4Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("4");
	}
	
	@FXML
	public void onBtn5Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("5");
	}
	
	@FXML
	public void onBtn6Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("6");
	}
	
	@FXML
	public void onBtn7Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("7");
	}
	
	@FXML
	public void onBtn8Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
		addToTxtResult("8");
	}
	
	@FXML
	public void onBtn9Action() {
		if(service.lastIsClosedBracket(txtResult.getText())) {
			addToTxtResult("*");
		}
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
	public void onBtnBracketAction() {
		if(service.lastIsDot(txtResult.getText())) {
			addToTxtResult("0");
		}
		//equação vazia
		if(txtResult.getText().length() == 0) {
			addToTxtResult("(");
		} else {
			//ultimo é operador ou numero ou ( ou )
			if(service.lastIsOperation(txtResult.getText())) {
				addToTxtResult("(");
			} else {
				//ultimo digito é numero ou ( ou  )
				if(service.lastIsNumber(txtResult.getText())) {
					if(service.hasBracketOpen(txtResult.getText())) {
						addToTxtResult(")");
					} else {
						addToTxtResult("*");
						addToTxtResult("(");
					}
				} else {
					//ultimo é ( ou )
					if(service.hasBracketOpen(txtResult.getText())) {
						if(txtResult.getText().substring(txtResult.getText().length()-1).equals("(")) {
							addToTxtResult("(");
						} else {
							addToTxtResult(")");
						}
					} else {
						addToTxtResult("*");
						addToTxtResult("(");
					}
				}
			}		
		}		
	}
	
	@FXML
	public void onBtnNegOrPosAction() {
		String lastNumber = "";
		
		//o tamanho é diferente de 0
		if(!(txtResult.getText().length()==0)) {
			//ultimo é numero
			if(service.lastIsNumber(txtResult.getText()) || service.lastIsDot(txtResult.getText())) {
				lastNumber = service.returnLastNumber(txtResult.getText());
				for(int i = 1 ; i <= lastNumber.length() ; i++) {
					if(txtResult.getText().length() != 0) {
						txtResult.setText(txtResult.getText().substring(0, txtResult.getText().length()-1));
					}
				}
			}
		}
		
		//o tamanho é diferente de 0 pós possivel remoção
		if(!(txtResult.getText().length()==0)) {
			//ultimo é operador diferente de -
			if(service.lastIsOperation(txtResult.getText()) && !(txtResult.getText().substring(txtResult.getText().length()-1).equals("-"))) {
				addToTxtResult("(-");
			} else {
				//ultimo é o operador -
				if(txtResult.getText().substring(txtResult.getText().length()-1).equals("-")) {
					//existe ( antes do operador -
					if(txtResult.getText().substring(txtResult.getText().length()-2, txtResult.getText().length()-1).equals("(")) {
						onBtnEraseAction();
						onBtnEraseAction();
					}
				} else {
					if(service.lastIsClosedBracket(txtResult.getText())) {
						addToTxtResult("*");
					}
					addToTxtResult("(-");
				}
			}
		} else {
			addToTxtResult("(-");
		}
		
		if(!lastNumber.equals("")) {
			addToTxtResult(lastNumber);
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
			if(!service.lastIsOperation(txtResult.getText()) && !service.lastIsOpenBracket(txtResult.getText())) {
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
			if(!service.lastIsOperation(txtResult.getText()) && !service.lastIsOpenBracket(txtResult.getText())) {
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
			if(!service.lastIsOperation(txtResult.getText()) && !service.lastIsOpenBracket(txtResult.getText())) {
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
			if(!service.lastIsOperation(txtResult.getText()) && !service.lastIsOpenBracket(txtResult.getText())) {
				addToTxtResult("/");
			}
		}
	}
	
	@FXML
	public void onBtnPercentAction() {
		if(txtResult.getText().length() != 0) {
			if(service.lastIsDot(txtResult.getText())) {
				addToTxtResult("0");
			}
			if(!service.lastIsOperation(txtResult.getText()) && !service.lastIsOpenBracket(txtResult.getText())) {
				addToTxtResult("%");
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
	public void onBtnChangeDecAction() {
		if(txtResult.getText().equals(service.getPreviousAnswer())) {
			btnChangeDec.setText(service.changeDecimalFormat());
			txtResult.setText(service.returnAnswer());
		} else {
			btnChangeDec.setText(service.changeDecimalFormat());
		}		
	}
	
	@FXML
	public void onBtnEqualsAction() {
		Locale.setDefault(locale);
		service.resolveEqualAction(txtResult.getText());
		txtResult.setText(service.returnAnswer());
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

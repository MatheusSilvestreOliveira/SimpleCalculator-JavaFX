package util;

import javafx.scene.control.TextField;

public class Constraints {

	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
	
	public static void setTextFieldNumbersAndOperators(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if(newValue != null && hasLetters(newValue)) {
				txt.setText(oldValue);
			}
		});
	}
	
	public static void setTextFieldNoSymbols(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if(newValue != null && hasSymbols(newValue)) {
				txt.setText(oldValue);
			}
		});
	}

	private static boolean hasLetters(String txt) {
		for(int i=0 ; i<txt.length() ; i++) {
			if(txt.substring(i, i+1).matches("[a-zA-Z]")) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean hasSymbols(String txt) {
		String symbol = "'!@#$%¨&_=|´`[{]}~^,<>;:?";
		for(int i=0 ; i<txt.length() ; i++) {
			for(int y=0 ; y<symbol.length() ; y++) {
				if(txt.substring(i, i+1).equals(symbol.substring(y, y+1))) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
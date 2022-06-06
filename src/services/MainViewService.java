package services;

public class MainViewService {
	
	private String decimalFormatString;
	private double previousAnswer;
	
	public MainViewService() {
		decimalFormatString = "%.2f";
	}
	
	public boolean lastIsDot(String txt) {
		if(txt.length() == 0) {
			return false;
		}
		return txt.substring(txt.length()-1).equals(".");
	}
	
	public boolean lastIsOperation(String txt) {
		if(txt.length()==0) {
			return false;
		}
		return txt.substring(txt.length()-1).equals("+") ||
				txt.substring(txt.length()-1).equals("-") ||
				txt.substring(txt.length()-1).equals("*") ||
				txt.substring(txt.length()-1).equals("/");
	}
	
	public boolean alreadyHasDot(String txt) {
		boolean hasDot = false;
		for(int i=0 ; i<txt.length() ; i++) {
			if(txt.substring(i, i+1).equals(".")) {
				hasDot = true;
			} else {
				if(txt.substring(i, i+1).equals("+") || txt.substring(i, i+1).equals("-") || txt.substring(i, i+1).equals("*") || txt.substring(i, i+1).equals("/")) {
					hasDot = false;
				}
			}
		}
		return hasDot;
	}
	
	public boolean lastIsNumber(String txt) {
		if(txt.length()==0) {
			return false;
		}
		return txt.substring(txt.length()-1).matches("\\d");
	}
	
	public boolean lastIsOpenBracket(String txt) {
		if(txt.length()==0) {
			return false;
		}
		return txt.substring(txt.length()-1).equals("(");
	}
	
	public boolean lastIsClosedBracket(String txt) {
		if(txt.length()==0) {
			return false;
		}
		return txt.substring(txt.length()-1).equals(")");
	}
	
	public boolean hasBracketOpen(String txt) {
		int openBracketCtr = 0;
		int closedBracketCtr = 0;
		for(int i = 0 ; i < txt.length() ; i ++) {
			if(txt.substring(i, i+1).equals("(")) {
				openBracketCtr++;
			} else {
				if (txt.substring(i, i+1).equals(")")) {
					closedBracketCtr++;
				}
			}
		}
		
		if(openBracketCtr == closedBracketCtr) {
			return false;
		}
		return true;
	}
	
	public String returnLastNumber(String txt) {
		String x = "";
		for(int i = txt.length()-1 ; i >= 0 ; i--) {
			if(lastIsOperation(txt.substring(i, i+1)) || lastIsOpenBracket(txt.substring(i, i+1))) {
				x = txt.substring(i+1);
				return x;
			}
			if(i==0) {
				x = txt;
				return x;
			}
		}
		return x;
	}
	
	public String changeDecimalFormat() {
		if(decimalFormatString.equals("%.0f")){
			decimalFormatString = "%.1f";
		} else {
			if(decimalFormatString.equals("%.1f")) {
				decimalFormatString = "%.2f";
			} else {
				if(decimalFormatString.equals("%.2f")) {
					decimalFormatString = "%.4f";
				} else {
					if(decimalFormatString.equals("%.4f")) {
						decimalFormatString = "%.6f";
					} else {
						if(decimalFormatString.equals("%.6f")) {
							decimalFormatString = "%.0f";
						} else {
							decimalFormatString = "%.0f";
						}
					}
				}
			}
		}
		
		return decimalFormatString ;
	}
	
	public void resolveEqualAction(String txt) {
		if(lastIsDot(txt)) {
			txt+="0";
		}
		if(lastIsOperation(txt)) {
			if(txt.length() != 0) {
				txt.substring(0, txt.length()-1);
			}
		}
		while(hasBracketOpen(txt)) {
			txt+=")";
		}
		
		Calculation calc = new Calculation(txt);
		setPreviousAnswer(calc.getAnswer());
	}
	
	public String returnAnswer() {
		return String.format(decimalFormatString, previousAnswer);
	}
	
	private void setPreviousAnswer(double answer) {
		previousAnswer = answer;
	}
	
	public String getPreviousAnswer() {
		return String.format(decimalFormatString, previousAnswer);
	}
}

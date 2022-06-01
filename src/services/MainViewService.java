package services;

public class MainViewService {
		
	public MainViewService() {}
	
	public boolean lastIsDot(String txt) {
		if(txt.length() == 0) {
			return false;
		}
		return txt.substring(txt.length()-1).equals(".");
	}
	
	public boolean lastIsOperation(String txt) {
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
		return txt.substring(txt.length()-1).matches("\\d");
	}
	
	public boolean lastIsOpenBracket(String txt) {
		return txt.substring(txt.length()-1).equals("(");
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
}

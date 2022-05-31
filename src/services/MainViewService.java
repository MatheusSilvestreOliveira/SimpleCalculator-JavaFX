package services;

public class MainViewService {

	public MainViewService() {}
	
	public boolean lastIsDot(String txt) {
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
	
	
	
}

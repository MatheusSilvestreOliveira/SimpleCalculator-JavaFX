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
	
}

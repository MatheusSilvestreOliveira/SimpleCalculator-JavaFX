package services;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
		
	private String equation;
	private double answer;
	private String number;

	private String newEquation;
	private String localBracketAnswer;
	
	private List<Double> varList = new ArrayList<>();
	private List<String> opList = new ArrayList<>();
	
	public Calculation (String equation) {
		this.equation = equation;
		number = "";
		newEquation = "";
		localBracketAnswer = "";
		defineEquations();
		doCalculation();
	}
	
	private void defineEquations() {
		for( int i = 0 ; i < equation.length() ; i++) {
			if(equation.substring(i, i+1).equals("(")) {
				i = resolveBrackets(i);
				number += Double.parseDouble(localBracketAnswer);
				localBracketAnswer = "";
			} else {		
				if( equation.substring(i, i+1).equals("+")) {
					opList.add(equation.substring(i, i+1));
					varList.add(Double.parseDouble(number));
					number = "";
				} else {
					if(equation.substring(i, i+1).equals("-")) {						
						if(number.equals("")) {
							opList.add("*");
							varList.add(-1.0);
						} else {
							opList.add(equation.substring(i, i+1));
							varList.add(Double.parseDouble(number));
							number = "";
						}						
					} else {
						if(equation.substring(i, i+1).equals("*")) {
							opList.add(equation.substring(i, i+1));
							varList.add(Double.parseDouble(number));
							number = "";
						} else {
							if(equation.substring(i, i+1).equals("/")) {
								opList.add(equation.substring(i, i+1));
								varList.add(Double.parseDouble(number));
								number = "";
							} else {
								number += equation.substring(i, i+1);
							} // if /
						} // if *
					} // if -
				} // if +
			} // if ()
		} // for
		if(!number.equals("")) {
			varList.add(Double.parseDouble(number));
			number = "";
		}

	}
	
	private int resolveBrackets(int y) {
		int bracketCounter = 0;
		y++;
		while (!equation.substring(y, y+1).equals(")") || bracketCounter!=0){
			if(equation.substring(y, y+1).equals("(")) {
				bracketCounter++;
			}
			
			if(equation.substring(y, y+1).equals(")")) {
				bracketCounter--;
			}
			
			newEquation += equation.substring(y, y+1);
			y++;
		}
		Calculation newCalculation = new Calculation(newEquation);
		localBracketAnswer = Double.toString(newCalculation.getAnswer());
		newEquation = "";
		return y;
	}
	
	private void doCalculation() {
		
		for(int i = 0 ; i < opList.size() ; i++) {
			while ((i < opList.size()) && opList.size() != 0  && (opList.get(i).equals("*") || opList.get(i).equals("/"))) {
				if(opList.get(i).equals("*")) {
					varList.set(i, multiplication(varList.get(i), varList.get(i+1)));
					varList.remove(i+1);
					opList.remove(i);
				} else {
					if(opList.get(i).equals("/")) {
						varList.set(i, division(varList.get(i), varList.get(i+1)));
						varList.remove(i+1);
						opList.remove(i);
					}
				}
			}
		}
		
		for(int i = 0 ; i < opList.size() ; i++) {
			while ((i < opList.size()) && opList.size() != 0 && (opList.get(i).equals("+") || opList.get(i).equals("-"))) {
				if(opList.get(i).equals("+")) {
					varList.set(i, addition(varList.get(i), varList.get(i+1)));
					varList.remove(i+1);
					opList.remove(i);
				} else {
					if(opList.get(i).equals("-")) {
						varList.set(i, subtraction(varList.get(i), varList.get(i+1)));
						varList.remove(i+1);
						opList.remove(i);
					}
				}
			}
		}
		
		answer = varList.get(0);
	}
	
	private double multiplication(double n1, double n2) {
		return n1 * n2;
	}
	
	private double division(double n1, double n2) {
		return n1 / n2;
	}
	
	private double addition(double n1, double n2) {
		return n1 + n2;
	}
	
	private double subtraction(double n1, double n2) {
		return n1 - n2;
	}
	
	public double getAnswer() {
		return answer;
	}
	
}
	


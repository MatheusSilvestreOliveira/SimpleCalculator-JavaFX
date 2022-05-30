package services;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
	
	// TEST CODE, MUST BE IGNORE
	
	private String equation;
	private double answer;

	private List<Double> varList = new ArrayList<>();
	private List<String> opList = new ArrayList<>();
	
	public Calculation (String equation) {
		this.equation = equation;
		defineEquations();
		doCalculation();
	}
	
	private void defineEquations() {
		
		for( int i = 0 ; i < equation.length() ; i++) {
			if( equation.substring(i, i+1).equals("+")) {
				opList.add(equation.substring(i, i+1));
			} else {
				if(equation.substring(i, i+1).equals("-")) {
					opList.add(equation.substring(i, i+1));
				} else {
					if(equation.substring(i, i+1).equals("*")) {
						opList.add(equation.substring(i, i+1));
					} else {
						if(equation.substring(i, i+1).equals("/")) {
							opList.add(equation.substring(i, i+1));
						} else {
							varList.add(Double.parseDouble(equation.substring(i, i+1)));
						}
					}
				}
			}
		}
		
	}
	
	private void doCalculation() {
		
		System.out.println(varList.toString());
		System.out.println(opList.toString());
		
		for(int i = 0 ; i < opList.size() ; i++) {
			while (opList.size() != 0  && (opList.get(i).equals("*") || opList.get(i).equals("/"))) {
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
				System.out.println(varList.toString());
				System.out.println(opList.toString());
			}
		}
		
		for(int i = 0 ; i < opList.size() ; i++) {
			while (opList.size() != 0 && (opList.get(i).equals("+") || opList.get(i).equals("-"))) {
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
				System.out.println(varList.toString());
				System.out.println(opList.toString());
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
	


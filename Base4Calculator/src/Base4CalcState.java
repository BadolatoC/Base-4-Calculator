//Christopher Badolato
//Project #1

public class Base4CalcState {
	private int value, number, leftValue, rightValue; // value of current calculation
	private boolean calculate;
	private String operation; 
	
	Base4CalcState() { 
		value = number = rightValue = leftValue = 0;
		calculate = false;
		operation = "";
	}
	int getLeftValue(){return leftValue;}
	int getRightValue(){return rightValue;}
	String getOperation(){return operation;}
	
	// invoked when the "Clear" button is pressed--is there any other time it should be invoked?
	void clear() { 
		value = number = rightValue = leftValue = 0; 
		operation = "";
		calculate = false;
	}
	//builds a number to calculate using numbers input
	void onNumberPress(String num){
		
		int temp = Integer.parseInt(num);
		number*=10;
		number += temp;
		if(calculate)
			rightValue = number;
		else
			leftValue = number;		
	}
	int currentValue() { return value; }
	
	//handles operation presses
	void onOperationPress(String op){
				
		operation = op;
		//number = convertToBase10(4, number);
		
		if(!calculate){
			number = 0;
			calculate = true;
		}
			
		
	}
	//
	void equal(){		
		if(rightValue!=0){		
			leftValue = convertToBase10(4, leftValue);
			rightValue = convertToBase10(4, rightValue);
			
			if(operation == "+")
				value=leftValue+rightValue;
			else if(operation == "-")
				value=leftValue-rightValue;
			else if(operation == "*")
				value=leftValue*rightValue;
			else if(operation == "/")
				value=leftValue/rightValue;
			
			leftValue = convertFromBase10(4, leftValue);
			rightValue = convertFromBase10(4, rightValue);
			value = convertFromBase10(4, value);	
		}
		
		leftValue = value;
		rightValue = number = 0;
	}
	//converts from base 10 to any base to be used after calculations are done
	int convertFromBase10(int newBase, int val){
		int num = val;
		String temp = "";
		
		while(num > newBase){
			temp = (num % newBase) + temp;
			num /= newBase;
		}
		
		temp = num + temp;
		return Integer.parseInt(temp);
			
	}
	//converts any base to Base 10 in order to be calculated
	int convertToBase10(int currBase, int val){
		int inBase10 = 0;
		String temp = Integer.toString(val);
		for(int i = 0; i < temp.length(); i++){
			String count = "" +  temp.charAt(temp.length()-1-i);
			int x = Integer.parseInt(count);
			int exponent = (int) Math.pow(currBase, i);
			inBase10 += (x*exponent);
		}
		
		return inBase10;
	}
}

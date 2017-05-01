//Christopher Badolato
//Project #1

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.TextField;
import java.awt.event.*;

public class Base4Panel extends JPanel {
	private Base4CalcState calc; // this object will actually do the calculating work
	JButton zero, 
	one, 
	two, 
	three, 
	plus, 
	minus, 
	multiply, 
	divide, 
	clear,
	equal;
//	random;
	TextField  leftDisplay, rightDisplay, operatorDisplay, answerDisplay;

	Base4Panel() {
		this.setLayout(new FlowLayout());
	
		calc = new Base4CalcState();
		zero = new JButton("0"); 
		one = new JButton("1");
		two = new JButton("2"); 
		three = new JButton("3"); 
		plus = new JButton("+"); 
		minus = new JButton("-"); 
		multiply = new JButton("x"); 
		divide = new JButton("/");
		equal = new JButton("=");
		clear = new JButton("Clear");
//		random = new JButton("rand");
		leftDisplay = new TextField("0", 20);
		rightDisplay = new TextField("0", 20);
		operatorDisplay = new TextField("", 1);
		answerDisplay = new TextField("0", 20);
		
		add(plus);
		add(minus);
		add(multiply);
		add(divide);
		add(equal);
		add(three);
		add(two);
		add(one);
		add(zero);
		add(clear);
//		add(BorderLayout.SOUTH, random);
		add(leftDisplay);
		add(operatorDisplay);
		add(rightDisplay);
		add(answerDisplay);
		
		
		// do you need any other layout elements? 

		// you may decide you want to improve the appearance of the layout, 
		// which is fine. But defer that until you get the calculator working. 
		// (You can spend HOURS messing with layout, which is not the point of this exercise!)

		zero.addActionListener(new ZeroListener());
		one.addActionListener(new OneListener());
		two.addActionListener(new TwoListener());
		three.addActionListener(new ThreeListener());
		plus.addActionListener(new PlusListener());
		minus.addActionListener(new MinusListener());
		multiply.addActionListener(new MultiplyListener());
		divide.addActionListener(new DivideListener());
		clear.addActionListener(new ClearListener());
		equal.addActionListener(new EqualListener());
	//	random.addActionListener(new RandomListener());
		

	}

	// you need to deal with event handling. before you go too crazy writing code, 
	// think about when the calc object needs to be involved, and when it doesn't 

	//Listeners all of which send the button click to the calc and update the display
	class ZeroListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onNumberPress("0");
			update();
		}
	}
	class OneListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onNumberPress("1");
			update();
		}
	}
	class TwoListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onNumberPress("2");
			update();
		}
	}
	class ThreeListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onNumberPress("3");
			update();
		}
	}
	class PlusListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onOperationPress("+");
			update();			
		}
	}
	class MinusListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onOperationPress("-");
			update();
		}
	}
	class DivideListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onOperationPress("/");
			update();
		}
	}
	class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.onOperationPress("*");
			update();
		}
	}
	class EqualListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			update();
			calc.equal();
		//	String temp = Integer.toString(calc.currentValue());
			update();
		//	answerDisplay.setText(temp);
		}
	}
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			calc.clear();
			update();			
		}
	}
/*	class RandomListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			int temp = calc.convertFromBase10(4, 28);
			display.setText(Integer.toString(temp));
			
		}
	}
	*/
	//updates the display boxes
	void update(){
		String temp = Integer.toString(calc.getLeftValue());
		leftDisplay.setText(temp);
		temp = Integer.toString(calc.getRightValue());
		rightDisplay.setText(temp);
		operatorDisplay.setText(calc.getOperation());
		temp = Integer.toString(calc.currentValue());
		answerDisplay.setText(temp);
	}
		
}

/* Program: HW3 / Class:MainClass.java 
 * Date Created: May 4, 2018 / Modified:
 * Author: Zachary Chandler
 * Description: 
 */

package homework3;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createGUI();
			}
		});
		/*
		*SwingUtilities.invokeLater(() -> createGUI());
		*this is using lambda notation, does the same thing as above. crazy right?
		*/
	}
	
	static int frameWidth = 1000;
	static int frameHeight = 1000; //these are used nowhere else, just here in case they become handy
	public static void createGUI() {
		
		
		//button experimentation stuff
		
		
		JFrame frame = new JFrame("its time for fibbonachos and fractal aches");
		frame.setSize(frameWidth,frameHeight);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//what goes in the frame
		Viewer v = new Viewer();
		frame.add(v);
		
		//connect view to model
		DrawingModel model = new DrawingModel();
		model.addView(v);

		//demonstration of fibonacci squares, proper spirals, and generating the next square in a series
		FibonacciSquare one = new FibonacciSquare(400, 400, Color.BLACK, 1, 1);
		model.addShape(one);
		FibonacciSquare two = one.nextFibonacciSquare(one);
		model.addShape(two);
		FibonacciSquare three = two.nextFibonacciSquare(two);
		model.addShape(three);
		FibonacciSquare four = three.nextFibonacciSquare(three);
		model.addShape(four);
		FibonacciSquare five = four.nextFibonacciSquare(four);
		model.addShape(five);
		FibonacciSquare six = five.nextFibonacciSquare(five);
		model.addShape(six);
		FibonacciSquare seven = six.nextFibonacciSquare(six);
		model.addShape(seven);
		FibonacciSquare eight = seven.nextFibonacciSquare(seven);
		eight.color = Color.BLUE; //this is just to demonstrate that any Color may be picked
		model.addShape(eight);
		FibonacciSquare nine = eight.nextFibonacciSquare(eight);
		model.addShape(nine);
		FibonacciSquare ten = nine.nextFibonacciSquare(nine);
		model.addShape(ten);
		
		//demonstration of HShape and multiple colors
		HShape first = new HShape(40, 40, Color.gray, 40);
		model.addShape(first);
		HShape second = new HShape(300, 700, Color.MAGENTA, 300);
		model.addShape(second);
		// this makes a full screen button, need some other pane to make this in I guess
		JButton buttonTest = new JButton("Test Button, thank you");
		buttonTest.setBounds(10, 10, 300, 100);
		frame.add(buttonTest);
		buttonTest.setOpaque(true);
		
		
		
		frame.setVisible(true);
	}

}

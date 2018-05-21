/* Program: HW3 / Class:fibonacciSquare.java 
 * Date Created: May 3, 2018 / Modified:
 * Author: Zachary Chandler
 * Description: 
 */

package homework3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class FibonacciSquare extends AbstractShape implements Shape {
	private static final int SCALE_FACTOR = 10;  //found this used in a few places, needs to be in one spot
	public int n, quadrant; //n represents which index of the fibb sequence we are in, quadrant will be needed to draw the right arc
	
	public FibonacciSquare(int x, int y, Color c, int quadrant, int n) {
		//the fib number is stored as an index and calculated as needed
		//the draw method has a *10 to scale it to visible pixel sizes
		super(x, y, c);
		this.quadrant = quadrant; // quadrant will be changed to an angle rating in the draw method
		this.n = n; 
		children = new Shape[1];
	}

	public boolean createChild() {
		return true;
	}
	
	public Shape deepCopy() { //currently any copy is a deep copy due to only having int and enum fields
		return new FibonacciSquare(this.x, this.y, this.color, this.quadrant, this.n);
	}
	
	public FibonacciSquare nextFibonacciSquare(FibonacciSquare sqr) {
		int quad;
		int nextFibX = 0, nextFibY = 0; //these will be the offsets for proper plavement
		int currentSize = recursiveFibonacci(sqr.n) * SCALE_FACTOR;
		int nextSize = recursiveFibonacci(sqr.n + 1) * SCALE_FACTOR; //position vector is in pixels, but the size of a square side is a function of the fib index
		
		if(sqr.quadrant == 4) quad = 1;
		else quad = sqr.quadrant + 1;
		//shuffling quadrants counter clockwise
		
		
		if(quad == 1) {
			nextFibX = currentSize - nextSize;
			nextFibY = -nextSize;
		}
		if(quad == 2) {
			nextFibX = -nextSize;
		}
		if(quad == 3) {
			nextFibY = currentSize;
		}
		if(quad == 4) {
			nextFibX = currentSize;
			nextFibY = currentSize - nextSize;

			// we are assuming a counter clockwise movement and making adjustments based on where the new square lands
			//due to the way the 'stylus' works moving into the 2nd and 3rd quadrants is easy
			//but moving into the 1st and 4th requires an additional offset
			//this would be sorta reversed if we were to move in a clockwise fashion
		}
		
		return new FibonacciSquare(sqr.x + nextFibX, sqr.y + nextFibY, sqr.color, quad, sqr.n + 1);
		
	}
	
	
	public void draw(Graphics g) {
		//calculations for drawing have been moved to the draw method
		//this is to maintain a base object whose fields are very clear
		int angle = (this.quadrant - 1) * 90;
		int squareLength = recursiveFibonacci(this.n) * SCALE_FACTOR;
		
		//this got moved from the constructor because its only used here
		int moveArcX = 0 , moveArcY = 0;
		/*
		if (quadrant == 2) { //drawArc fits well for second quadrant arcs but needs to be offset otherwise
			moveArcX = 0;
			moveArcY = 0;
		} 
		*/
		if(quadrant == 1) {
			moveArcX = -1;
			//moveArcY = 0;
		}
		if (quadrant == 3) {
			//moveArcX = 0;
			moveArcY = -1;
		}
		if(quadrant == 4) {
			moveArcX = -1;
			moveArcY = -1;
		}
		//moved stuff, commented things out if they weren't need anymore, afraid to delete it though
		
		g.setColor(color);
		g.drawRect(x, y, squareLength, squareLength);
		g.drawArc(x + squareLength * moveArcX, y + squareLength *moveArcY, squareLength * 2, squareLength * 2, angle,90);
		
		/*
		//print fibonacci at a  random location
		//change this yo
		Random rand = new Random();
		//font size
		int fsize = rand.nextInt(16)+10;
		Font font = new Font("Courier", Font.BOLD, fsize);
		g.setFont(font);
		g.setColor(new Color(rand.nextInt()));
		int x = rand.nextInt(MainClass.frameWidth);
		int y = rand.nextInt(MainClass.frameHeight);
		*/
	}
	public static int fibonacci(int n) {
		int foo = 1;
		int bar = 0;
		int holder = 0;
		while(n > 0) {
			holder = foo;
			foo = foo + bar;
			bar = holder;
			--n;
		}
		return foo;
	}
	
	public static int recursiveFibonacci(int n) {
		if (n == 1 || n == 2) {
		
			return 1;
		} else {
			return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
		}	
	}
	//both methods return the value of the nth fibonacci number

	/* (non-Javadoc)
	 * @see homework3.Shape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		if (x > this.x && x < (this.x + recursiveFibonacci(this.n) * SCALE_FACTOR) && y > this.y && y < (this.y + recursiveFibonacci(this.y) * SCALE_FACTOR)) {
			return true;
		} else {
			return false;
		}
	}


}

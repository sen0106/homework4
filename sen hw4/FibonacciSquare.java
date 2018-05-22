import java.awt.*;
import java.util.Random;

import javax.imageio.IIOException;

public class FibonacciSquare extends AbstractShape {
	private int quadrant;	//the corresponding quadrant of the arc (= a quarter circle.)
	private int n;			//n refers to the nth fibonacci number Fn in the fibonacci sequence, 
							//which we take to be the length of the side of the square.
	protected static final int SCALE_FACTOR = 30;
	private int nextQuadrant;
	private int nextN;
	private int previousSize;
	private int nextSize;
	
	//Constructor	
	public FibonacciSquare(int x, int y, int n, int quadrant, Color color) {
		super(x, y, fibonacci(n) * SCALE_FACTOR, color);
		this.quadrant = quadrant;
		this.n = n;
		this.nextN = n + 1;
		if (n > 1) {
			this.previousSize = fibonacci(n - 1) * SCALE_FACTOR;
		}
		this.nextSize = fibonacci(nextN) * SCALE_FACTOR;
		children = new Shape[1];
	}
	
	public FibonacciSquare getNextFibonacciSquare() {
		if(quadrant == 1) {
			nextQuadrant = 2;
			return new FibonacciSquare(x - nextSize, y, nextN, nextQuadrant, color);
		}else if(quadrant == 2) {
			nextQuadrant = 3;
			return new FibonacciSquare(x, y + size, nextN, nextQuadrant, color);
		}else if(quadrant == 3) {
			nextQuadrant = 4;
			return new FibonacciSquare(x + size, y - previousSize, nextN, nextQuadrant, color);
		}else if(quadrant == 4){
			nextQuadrant = 1;
			return new FibonacciSquare(x + size - nextSize, y - nextSize, nextN, nextQuadrant, color);
		}else {
			return null;
		}
	}
	
	// returns the value of the nth Fibonacci number
	public static int fibonacci(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 1;
		}else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// print Fibonacci Square
		g.setColor(color);
		//g.drawRect(x, y, n * 60, n * 60);
		if (quadrant > 4 || quadrant < 1) {
			//nothing
		}else if (quadrant == 1) {	
			g.drawRect(x, y, size, size);
			//g.drawArc(x1, y1, width, height, startAngle, Angle);
			g.drawArc(x - size, y, size * 2, size * 2, 0, 90);			
		}else if (quadrant == 2){
			g.drawRect(x, y, size, size);
			g.drawArc(x, y, size * 2, size * 2, 90, 90);
		}else if (quadrant == 3){
			g.drawRect(x, y, size, size);
			g.drawArc(x, y - size, size * 2, size * 2, 180, 90);
		}else if (quadrant == 4) {
			g.drawRect(x, y, size, size);
			g.drawArc(x - size, y - size, size * 2, size * 2, 270, 90);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		if (this.x < x && x < this.x + this.size && this.y < y && y < this.y + this.size){
	        return true;
	    } else {
	        return false;
	    }
	}

	public boolean createChildren() {
		if(children[0] == null) {
			if(quadrant == 1) {
				nextQuadrant = 2;
				children[0] = new FibonacciSquare(x - nextSize, y, nextN, nextQuadrant, color);
			}else if(quadrant == 2) {
				nextQuadrant = 3;
				children[0] = new FibonacciSquare(x, y + size, nextN, nextQuadrant, color);
			}else if(quadrant == 3) {
				nextQuadrant = 4;
				children[0] = new FibonacciSquare(x + size, y - previousSize, nextN, nextQuadrant, color);
			}else if(quadrant == 4){
				nextQuadrant = 1;
				children[0] = new FibonacciSquare(x + size - nextSize, y - nextSize, nextN, nextQuadrant, color);
			}
			return true;
		}else {
			return false;
		}
	}
}

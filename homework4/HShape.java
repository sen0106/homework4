/* Program: HW3 / Class:HShape.java 
 * Date Created: May 4, 2018 / Modified:
 * Author: Zachary Chandler
 * Description: 
 */

package homework3;

import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape implements Shape{
	public int size;
	public HShape(int x, int y, Color color, int size) {
		super(x,y,color);
		this.size = size;
		children = new Shape[7];
	}
	
	public Shape deepCopy() { //currently any copy is a deep copy due to only having int and enum fields
		return new HShape(x, y, color, size);
	}

	public boolean createChild() {
		if (this.size / 9 > 2) {
			return false;
		} else {//going top to bottom, left to right, our start points will be x,y, x, y + 1/3, x, y + 2/3 size, x + 1/3size, y + 1/3 size, x + 2/3 size, y, x + 2/3 size, y + 1/3 size, x + 2/3 size, y + 2/3 size
			if (this.children[0] == null) children[0] = new HShape(x, y, color,  size / 3);
			else if (this.children[1] == null) children[1] = new HShape(x, y + 1/3 * size, color,  size / 3);
			else if (this.children[2] == null) children[2] = new HShape(x, y + 2/3 * size, color,  size / 3);
			else if (this.children[3] == null) children[3] = new HShape(x + 1/3 * size, y + 1/2 * size, color,  size / 3);
			else if (this.children[4] == null) children[4] = new HShape(x + 2/3 * size, y, color,  size / 3);
			else if (this.children[5] == null) children[5] = new HShape(x + 2/3 * size, y + 1/3 * size, color,  size / 3);
			else if (this.children[6] == null) children[6] = new HShape(x + 2/3 * size, y + 2/3 * size, color,  size / 3);
			return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see homework3.Shape#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int holder = size / 3;
		int holderAgain = size * 2 / 3;
		g.setColor(color);
		g.fillRect(x, y, holder, holder);
		g.fillRect(x, y + holder, holder, holder);
		g.fillRect(x, y + holderAgain, holder, holder);
		//first column
		
		//g.fillRect(x + holder, y, holder, holder);
		g.fillRect(x + holder, y + holder, holder, holder);
		//g.fillRect(x + holder, y + holder + holder, holder, holder); the middle top and bottom squares are background color
	
		g.fillRect(x + holderAgain, y, holder, holder);
		g.fillRect(x + holderAgain, y + holder, holder, holder);
		g.fillRect(x + holderAgain, y + holderAgain, holder, holder);
		
		g.setColor(Color.BLACK);
		g.drawRect(x, y, holder, holder);
		g.drawRect(x, y + holder, holder, holder);
		g.drawRect(x, y + holderAgain, holder, holder);
		//first column
		
		//g.drawRect(x + holder, y, holder, holder);
		g.drawRect(x + holder, y + holder, holder, holder);
		//g.drawRect(x + holder, y + holder + holder, holder, holder); the middle top and bottom squares are background color
	
		g.drawRect(x + holderAgain, y, holder, holder);
		g.drawRect(x + holderAgain, y + holder, holder, holder);
		g.drawRect(x + holderAgain, y + holderAgain, holder, holder);


		
		
	}

	/* (non-Javadoc)
	 * @see homework3.Shape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		if (x > this.x && x < (this.x + this.size) && y > this.y && y < (this.y + this.size)) {
			return true;
		} else {
			return false;
		}
	}

	
}

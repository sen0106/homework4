import java.awt.*;

import javax.swing.JPanel;

public abstract class AbstractShape implements Shape{
	// common fields
	protected int x, y, size;
	protected Color color;
	
	// the children of this shape
	protected Shape[] children;
	
	public AbstractShape(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	@Override
	public boolean addLevel() {
		if (children[0] == null) {
			// possibly add a level
			// write a method createChildren() (declared in Shape
			// and implemented in Fibonacci and HShape)
			createChildren();
			return true;
		} else {
			for (Shape child : children) {
				child.addLevel();
			}
		}
		return false;
	}
	
	@Override
	public boolean removeLevel() {
		return false;
	}
	
	@Override
	public Shape[] getChildren() {
		return children;
	}
}

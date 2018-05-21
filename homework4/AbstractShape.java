/* Program: HW3 / Class:AbstractShape.java 
 * Date Created: May 3, 2018 / Modified:
 * Author: Zachary Chandler
 * Description: 
 */

package homework3;

import java.awt.Color;
import java.lang.reflect.Array;

abstract class AbstractShape implements Shape{
	protected int x=0, y=0;
	public Color color;
	protected Shape[] children;
	
	/**
	 * 
	 */
	public AbstractShape(int x, int y, Color c) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.color = c;
	}
	@Override
	public boolean addLevel() {
		if (children[0] == null) {
			for (Shape child : children) {
				child.createChild();
			}
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
	
	
	

	
}

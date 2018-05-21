/* Program: HW3 / Class:Shape.java 
 * Date Created: May 3, 2018 / Modified:
 * Author: Zachary Chandler
 * Description: 
 */

package homework3;

import java.awt.Graphics;

public interface Shape {
	
	public Shape deepCopy();
	public void draw(Graphics g); //this is all we got so far, the contract to this day so to speak

	public boolean contains(int x, int y);
	public boolean addLevel();
	public boolean removeLevel();
	public boolean createChild();

}

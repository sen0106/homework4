/* Program: HW3 / Class:Viewer.java 
 * Date Created: May 4, 2018 / Modified:
 * Author: Zachary Chandler
 * Description: 
 */

package homework3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Viewer extends JPanel implements View{
	//note to self: this class, combined with the Runnable in MainClass, is where personal knowledge is weakest
	
	private DrawingModel model;
	
	public Viewer() {
		setBackground(Color.WHITE);
	}

	@Override
	public void update(DrawingModel model) {
		System.out.println("Update called");
		this.model = model;
		repaint(); //will eventually call paintComponent
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//display the shapes
		if (model != null) {
			for (Shape shape : model.getShapes()) {
				shape.draw(g);
				
			}
		}
	}
}

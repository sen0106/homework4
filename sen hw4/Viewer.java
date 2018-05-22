import java.awt.*;
import javax.swing.*;

public class Viewer extends JPanel implements View{
	// The model this View is connected to 
	private DrawingModel model;
	
	
	// This is own JPanel that implements View
	public Viewer() {
		setBackground(Color.WHITE);
	}
	
	@Override
	public void update(DrawingModel model) {
		System.out.println("Update called");
		this.model = model;
		repaint();	// will eventually call paintComponent
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// display of the shapes	
		if (model != null) {
			for(Shape s: model.getShapes()) {
				s.draw(g);
			}
		}
	}
}

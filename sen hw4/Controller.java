import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class Controller implements ActionListener, MouseListener{
	private DrawingModel model;
	private boolean addLevel = true;	//true - add : false - remove
	
	// Connect controller and model via Constructor
	public Controller(DrawingModel model) {
		this.model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.printf("(x,y)=(%d,%d)\n", e.getX(), e.getY());
		if(addLevel) {
			boolean success = model.addLevel(e.getX(), e.getY());
			if(!success) {
				//display a message box starting that no more level can be added
				//look at JOptionPane.showMessageDialog
				//JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			boolean success = model.removeLevel(e.getX(), e.getY());
			if(!success) {
				//display a message box starting that no more level can be removed
				//look at JOptionPane.showMessageDialog
				//JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
				//JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contains("Add")) {
			// click on add level
			addLevel = true;
		}else if (e.getActionCommand().contains("Remove")) {
			// click on remove level
			addLevel = false;
		}else {
			// has to be reset
		}
	}
	
	//Not used
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}

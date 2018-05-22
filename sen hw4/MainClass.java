import java.awt.*;
import java.util.*;

import javax.swing.*;

//MVC - Model View Controller

public class MainClass {

	public static void main(String[] args) {
		// instantiate an anonymous class that implements
		// Runnable
		// new Runnable()  ( // override of run )
		/*
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createGUI();
			}
		});
		*/
		
		// Shorter version of the same code
		// using lambda notation
		SwingUtilities.invokeLater(() -> createGUI());
	}
	
	public static void createGUI() {
		JFrame frame = new JFrame("H's and Fibonacci squares");
		//frame.setLocation(0, 0);
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// What goes in the frame
		Viewer viewer = new Viewer();	
		frame.add(viewer);
		
		// Buttons at the top of the frame
		JRadioButton add = new JRadioButton("Add Level");
		JRadioButton remove = new JRadioButton("Remove Level");
		JButton reset = new JButton("Reset");
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.YELLOW);
		northPanel.add(add);
		northPanel.add(remove);
		northPanel.add(reset);
		frame.add(northPanel, BorderLayout.NORTH);
		
		// Connect the two radio buttons and select the add button
		ButtonGroup group = new ButtonGroup();
		group.add(add);
		group.add(remove);
		add.setSelected(true);
		
		//Connect the view to a model
		DrawingModel model = new DrawingModel();
		model.addView(viewer);
		
		// Create a controller
		Controller controller = new Controller(model);
		
		// The controller listens to the button clicks
		add.addActionListener(controller);
		remove.addActionListener(controller);
		reset.addActionListener(controller);
		
		// The controller listens to the mouse clicks on the display pane
		viewer.addMouseListener(controller);
		
		// tell the controller that the add button is selected
		add.doClick();
		
		
//		// place a label at the top of the frame
//		JLabel label = new JLabel("Current Level");
//		label.setFont(new Font("Courier", Font.BOLD, 30));
//		label.setForeground(Color.BLACK);
//		JPanel southPanel = new JPanel();
//		southPanel.setBackground(Color.CYAN);
//		southPanel.add(label);
//		frame.add(southPanel, BorderLayout.SOUTH);
		
		// show it (execute this line last)
		frame.setVisible(true);	
		
		// first level
		model.addShape(new HShape(55, 110, 390, Color.GREEN));
		model.addShape(new FibonacciSquare(825, 220, 1, 1, Color.RED));
	}
}

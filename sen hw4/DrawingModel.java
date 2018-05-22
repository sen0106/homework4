import java.util.ArrayList;

public class DrawingModel {
	// the list of the shapes
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	// the list of the views connected to this model
	private ArrayList<View> views = new ArrayList<View>();

	// A client should be able to add a Shape to the model
	public void addShape(Shape s) {
		shapes.add(s);
		updateAll();
	}

	// A viewer should be able to register with the model
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}

	// It should notify all viewers when something in the model changes.
	public void updateAll() {
		// with an index
		// for (int i = 0; i < views.size(); i ++) {
		// views.get(i).update(this);
		// }
		// or with a for-each loop
		for (View v : views) {
			v.update(this);
		}
	}
	
	// Returns the list of the shapes
	public ArrayList<Shape> getShapes() {
		return shapes; // OK for homework 4
	}

	public boolean addLevel(int x, int y) {
		boolean b = true;
		for (Shape s : shapes) {
			// if (x,y) is within s, add a level to s
			if (s instanceof FibonacciSquare) {
				FibonacciSquare f = (FibonacciSquare)s;
				if(f.contains(x, y)) {
					b = f.addLevel();
					addShape(f.getChildren()[0]);
				}
			}else if (s instanceof HShape){
				HShape h = (HShape)s;
				if(h.contains(x, y)) {
					b = h.addLevel();
					for(int i = 0; i < s.getChildren().length;i++) {
						addShape(h.getChildren()[i]);
					}
				}
			}
		}
		updateAll();
		return b;
	}

	public boolean removeLevel(int x, int y) {
		boolean b = true;
		for(Shape s : shapes) {
			// if (x,y) is within s, remove a level from s
			if (s.contains(x,y)) {
				b = s.removeLevel();
			}
		}
		return b;
	}
}



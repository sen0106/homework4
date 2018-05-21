/* Program: HW3 / Class:DrawingModel.java 
 * Date Created: May 3, 2018 / Modified:
 * Author: Zachary Chandler
 * Description: 
 */

package homework3;

import java.util.ArrayList;

import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;

import org.omg.CORBA.PUBLIC_MEMBER;

public class DrawingModel {

	int[] arrayYo;
	private ArrayList<Shape>shapes = new ArrayList<Shape>();
	
	private ArrayList<View>views = new ArrayList<View>(); 
	
	public void addShape(Shape s) {
		shapes.add(s);
	}
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}
	public void updateAll(ArrayList<View> views) {
		for (View v: views) {
			v.update(this);
		}
		/*with a for loop
		 * for(int i = 0; i < views.size(); ++i){
		 * 		views.get(i).update(this);
		    }  */
	}
	public ArrayList<Shape> getShapes(){//creates temporary ArrayList that is populalated by deep copies, then returned whole sale
		ArrayList<Shape> tempArray = new ArrayList<Shape>();
		for (Shape shape : shapes) {
			tempArray.add(shape.deepCopy());
		}
		return tempArray;
	}
	
	public boolean addLevel ( int x, int y) {
		return true;
	}
	public boolean removeLevel(int x, int y)
	
}

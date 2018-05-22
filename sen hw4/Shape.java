import java.awt.Graphics;

public interface Shape {
	void draw(Graphics g);
	
	boolean contains(int x, int y);
	
	boolean addLevel();
	
	boolean removeLevel();
	
	boolean createChildren();
	
	Shape[] getChildren();
}

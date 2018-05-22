import java.awt.*;
import java.util.Random;



public class HShape extends AbstractShape {
	private int size;
	
	//constructor
	public HShape(int x, int y, int size, Color color) {
		super(x, y, size, color);
		this.size = size;
		children = new Shape[7];
	}

	@Override
	public void draw(Graphics g) {
		// draw an H by displaying
		// seven squares starting at location (x,y) and with
		// the given size
		if(children[0] == null) {
			g.setColor(Color.WHITE);
			g.fillRect(x + size/3, y, size/3, size/3);
			g.fillRect(x + size/3, y + size*2/3, size/3, size/3);
			
			g.setColor(color);
			g.fillRect(x, y, size/3, size);
			g.fillRect(x + size * 2/3, y, size/3, size);
			g.fillRect(x + size/3, y + size/3, size/3, size/3);

			g.setColor(Color.BLACK);
			g.drawRect(x, y, size/3, size/3);
			g.drawRect(x, y + size/3, size/3, size/3);
			g.drawRect(x, y + size*2/3, size/3, size/3);
			g.drawRect(x + size/3, y + size/3, size/3, size/3);
			g.drawRect(x + size*2/3, y, size/3, size/3);
			g.drawRect(x + size*2/3, y + size/3, size/3, size/3);
			g.drawRect(x + size*2/3, y + size*2/3, size/3, size/3);
			
			g.drawRect(x + size/3, y, size/3, size/3);
			g.drawRect(x + size/3, y + size*2/3, size/3, size/3);
			
			g.drawLine(500, 0, 500, 800);
		}else {
			for(Shape child : children) {
				child.draw(g);
			}
		}
	}

	@Override
	public boolean contains(int x, int y) {
		if(this.x < x && x < this.x + this.size && this.y < y && y < this.y + this.size) {
			return true;
		}else {
			return false;
		}	
	}


	@Override
	public boolean createChildren() {
		// size of the children
		int childSize = size / 3;
		if (childSize > 1) {
			int index = 0;
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					int xChild = x + size * col / 3;
					int yChild = y + size * row / 3;
					// create a new H (except at row = 0,2 and col = 1)
					if(row != 0 && col != 1) {
						children[index] = new HShape(xChild, yChild, size / 3, color);
						index++;
					}
				}
			}
			return true;
		} else {
			// too small to create new children
			return false;
		}
	}
}

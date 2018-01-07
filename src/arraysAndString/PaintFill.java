package arraysAndString;

public class PaintFill {
	
	enum Color{
		Black,
		White,
		Red,
		Blue
	}
	
	boolean paintFill(Color[][] screen, int row, int col, Color color ) {
		if(screen[row][col] == color) return false;
		return paintFill(screen, row, col, screen[row][col], color);
	}

	private boolean paintFill(Color[][] screen, int row, int col, Color oldcolor, Color newcolor) {
		if(row < 0 || row > screen.length || col < 0 || col > screen[0].length) return false;
		
		if(screen[row][col] == oldcolor) {
			screen[row][col] = newcolor;
			paintFill(screen, row-1, col, oldcolor, newcolor);
			paintFill(screen, row+1, col, oldcolor, newcolor);
			paintFill(screen, row, col-1, oldcolor, newcolor);
			paintFill(screen, row, col+1, oldcolor, newcolor);
		}
		return true;
	}

}

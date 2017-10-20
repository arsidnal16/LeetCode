package graphs;

public class sudoku {

	public static int ar[][] = { 
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

	public static void printGrid() {
		for (int i = 0; i < ar.length; i++) {

			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean solve() {

		// find unsiigned column,row

		int[] temp = findUn();

		if (temp != null) {
			int row = temp[0];
			int col = temp[1];

			// System.out.println("Empty place is "+row+" "+col);
			for (int i = 1; i <= 9; i++) {
				if (isSafe(row, col, i)) {
					// System.out.println("Its safe "+row +" "+col+" for "+i);

					ar[row][col] = i;
					if (solve()) {
						return true;
					}
					ar[row][col] = 0;
				}
			}
		} else
			return true;
		return false;

	}

	// public static boolean isSafe(int row, int col,int num){

	// check row

	public static boolean isSafe(int row, int col, int num) {

		return checkRow(row, col, num) && checkCol(row, col, num) && checkGrid(row, col, num);
	}

	public static boolean checkRow(int row, int col, int num) {

		for (int i = 0; i < ar.length; i++) {
			if (ar[row][i] == num) {
				return false;
			}
		}
		return true;
	}

	// check column
	public static boolean checkCol(int row, int col, int num) {

		for (int i = 0; i < ar.length; i++) {
			if (ar[i][col] == num) {
				return false;
			}
		}

		return true;
	}

	// check grid
	// change row & col to find start of box

	public static boolean checkGrid(int row, int col, int num) {
		row = row - (row % 3);
		col = col - (col % 3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ar[i + row][j + col] == num) {
					return false;
				}
			}
		}
		return true;

	}

	public static int[] findUn() {

		int[] t = new int[2];
		for (int i = 0; i < ar.length; i++) {

			for (int j = 0; j < ar.length; j++) {
				if (ar[i][j] == 0) {
					t[0] = i;
					t[1] = j;
					return t;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {

		System.out.println("unsolved sudoku\n\n");
		printGrid();
		System.out.println("\n\nSolved sudoku\n\n");
		if (solve()) {
			printGrid();
		}
	}

}
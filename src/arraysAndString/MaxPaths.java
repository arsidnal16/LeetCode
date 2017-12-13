package arraysAndString;

public class MaxPaths {

	static int[] arr;
	//static int top;

	public static void main(String[] args) {

		int[][] matrix = getInputMatrix();
		int m = matrix.length;
		int n = matrix[0].length;

		arr = new int[m * n];
		int top = 0;
		printAllPaths(matrix, m, n, top);
	}

	private static int[][] getInputMatrix() {

		String[] table = new String[] { "123", "456", "789" };

		int[][] matrix = new int[table.length][];

		for (int i = 0; i < table.length; i++) {
			matrix[i] = new int[table[i].length()];
			for (int j = 0; j < table[i].length(); j++) {
				matrix[i][j] = Character.getNumericValue(table[i].charAt(j));
			}
		}

		return matrix;
	}

	static void printAllPaths(int[][] matrix, int m, int n, int top) {
		if (m == 0 || n == 0)
			return;

		arr[top++] = matrix[m - 1][n - 1];
		
		//printStack(top);
		if (m == 1 && n == 1)
			printStack(top);

		printAllPaths(matrix, m - 1, n, top);
		printAllPaths(matrix, m, n - 1, top);
		top--;
	}

	private static void printStack(int top) {
		for (int i = top - 1; i > 0; i--)
			System.out.print(arr[i] + "->");
		System.out.println(arr[0]);
	}
}
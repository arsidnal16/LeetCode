package arraysAndString;

public class MaxPaths {

	static int[] stack;
	static int top;

	public static void main(String[] args) {

		int[][] matrix = getInputMatrix();
		int m = matrix.length;
		int n = matrix[0].length;

		stack = new int[m * n];
		top = 0;
		printAllPaths(matrix, m, n);
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

	static void printAllPaths(int[][] matrix, int m, int n) {
		if (m == 0 || n == 0)
			return;

		stack[top++] = matrix[m - 1][n - 1];
		if (m == 1 && n == 1)
			printStack();

		printAllPaths(matrix, m - 1, n);
		printAllPaths(matrix, m, n - 1);
		top--;
	}

	private static void printStack() {
		for (int i = top - 1; i > 0; i--)
			System.out.print(stack[i] + "->");
		System.out.println(stack[0]);
	}
}
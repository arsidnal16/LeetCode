package matrix;

public class RotateMatrix {
	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	
	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/

	public void rotate2(int[][] matrix) {
		int s = 0, e = matrix.length - 1;
		while (s < e) {
			int[] temp = matrix[s];
			matrix[s] = matrix[e];
			matrix[e] = temp;
			s++;
			e--;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	/*
	 * The idea was firstly transpose the matrix and then flip it symmetrically. For
	 * instance,
	 * 
	 * 1 2 3 4 5 6 7 8 9 after transpose, it will be swap(matrix[i][j],
	 * matrix[j][i])
	 * 
	 * 1 4 7 2 5 8 3 6 9 Then flip the matrix horizontally. (swap(matrix[i][j],
	 * matrix[i][matrix.length-1-j])
	 * 
	 * 7 4 1 8 5 2 9 6 3 Hope this helps.
	 * 
	 */
	public void rotate(int[][] matrix) {

		// transpose
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// flip
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}
	}

}

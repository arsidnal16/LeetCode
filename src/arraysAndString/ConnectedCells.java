package arraysAndString;

public class ConnectedCells {
	
	 public static int getBiggestRegion(int[][] matrix) {
	        int max = 0;
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                max = Math.max(max, countCells(matrix, i, j));
	            }
	        }
	        return max;
	    }
	    
	    private static int countCells(int[][] matrix, int i, int j) {
	        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
	        if (matrix[i][j] == 0) return 0;
	        int count = matrix[i][j]--;
	        count += countCells(matrix, i + 1, j);
	        count += countCells(matrix, i - 1, j);
	        count += countCells(matrix, i, j + 1);
	        count += countCells(matrix, i, j - 1);
	        count += countCells(matrix, i + 1, j + 1);
	        count += countCells(matrix, i - 1, j - 1);
	        count += countCells(matrix, i - 1, j + 1);
	        count += countCells(matrix, i + 1, j - 1);
	       return count; 
	    }

}

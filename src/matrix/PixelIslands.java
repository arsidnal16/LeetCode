package matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

class Pixel{
	String color;
	String coordinates;
}
public class PixelIslands {
	
	
	
	public static HashMap<String, List<List<String>>> getPixelCoordination(Pixel [][] matrix){
		HashMap<String, List<List<String>>> resultMap = new HashMap<String, List<List<String>>>();
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		
		for(int i =0; i< m;i++) {
			for(int j=0; j< n;j++) {
				if(visited[i][j] == false) {
					List<String> tempList = new ArrayList<String>();
					dfs(matrix, i, j, visited, tempList, matrix[i][j].color);
					
					
					if(!resultMap.containsKey(matrix[i][j].color)) {
						List<List<String>> result = new ArrayList<List<String>>();
						result.add(tempList);
						resultMap.put(matrix[i][j].color, result);
					}
					else {
						List<List<String>> result = resultMap.get(matrix[i][j].color);
						result.add(tempList);
						resultMap.put(matrix[i][j].color, result);
					}
				}
			}
		}
		
		return resultMap;
	}

	private static void dfs(Pixel[][] matrix, int i, int j, boolean[][] visited, List<String> tempList, String color) {
		if(i<0 || j<0 || i>matrix.length-1 || j> matrix[0].length-1 || !matrix[i][j].color.equals(color) || visited[i][j] == true ) return;
		
		visited[i][j] = true;
		//System.out.println("visiting "+ color+" "+matrix[i][j].coordinates);
		tempList.add(matrix[i][j].coordinates);
		dfs(matrix, i+1, j, visited, tempList, color);
		dfs(matrix, i-1, j, visited, tempList, color);
		dfs(matrix, i, j+1, visited, tempList, color);
		dfs(matrix, i, j-1, visited, tempList, color);
	}
	
	public static void main(String args[]) {
		Pixel[][] pixelIsland = new Pixel[6][6];
		String[] colorArr = {"red", "blue", "green", "yellow"};
		
		int m = pixelIsland.length;
		int n = pixelIsland[0].length;
		
		Random random = new Random();
		
		
		for(int i =0; i< m;i++) {
			for(int j=0; j< n;j++) {
				pixelIsland[i][j] = new Pixel();
				pixelIsland[i][j].coordinates = i+ ","+ j;
				pixelIsland[i][j].color = colorArr[random.nextInt(4)];
			}
		
		}
		
		
		printMatrix(pixelIsland);
		
		HashMap<String, List<List<String>>> resultMap = getPixelCoordination(pixelIsland);
		//System.out.println(resultList);
		for(Entry entry:resultMap.entrySet()) {
			System.out.println(entry.getKey() + " : "+entry.getValue());
		}
	}

	private static void printMatrix(Pixel[][] pixelIsland) {
		int m = pixelIsland.length;
		int n = pixelIsland[0].length;
		for(int i =0; i< m;i++) {
			for(int j=0; j< n;j++) {
				System.out.println(pixelIsland[i][j].coordinates + " "+ pixelIsland[i][j].color);
			}
		}
		
	}

}

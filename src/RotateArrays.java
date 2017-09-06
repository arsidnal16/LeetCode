import java.util.Arrays;

public class RotateArrays {
	
	public static void main(String args[]) {
		int[] arr = {0,1,2,3,4,5,6};
		rotate(arr, 2);
		System.out.println(Arrays.toString(arr));
		rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
		rotate(arr, 4);
		System.out.println(Arrays.toString(arr));
		rotate(arr, 5);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] rotate(int[] arr, int k) {
		if(arr.length == 0  || arr == null) {
			return arr;
		}
		int a = arr.length - k;
		
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length -1);
		reverse(arr, 0, arr.length -1);
		
		return arr;
		
	}
	
	public static void reverse(int[] arr, int start, int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}

}

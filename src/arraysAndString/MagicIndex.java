package arraysAndString;

public class MagicIndex {
	
	// 8.3 CTCI pg 346
	
	// magic index is A[i] = i;
	
	//if elements are distinct, if elements are not distinct this algo fails
	
	int magicFast(int[] arr) {
		return magicFast(arr, 0, arr.length-1);
	}

	private int magicFast(int[] arr, int start, int end) {
		if(start > end) return -1;
		
		int mid = end + (end - start)/2;
		
		if(arr[mid] ==mid) {
			return mid;
		}
		else if(arr[mid] < mid) {
			return magicFast(arr, mid +1, end );
		}
		else {
			return magicFast(arr, start, mid-1);
		}
		
	}
	
	
	
	
	//if elements are not distinct
	
	
	int magicFast2(int[] arr) {
		return magicFast2(arr, 0, arr.length-1);
	}

	private int magicFast2(int[] arr, int start, int end) {
		if(start >end) return -1;
		
		int mid  = end+ (end -start)/2;
		
		if(arr[mid] == mid) return mid;
		
		// otherwise recursively search elements left and right
		
		int leftIndex = Math.min(mid -1, arr[mid]);
		
		int left = magicFast2(arr, start, leftIndex);
		
		if(left >= 0) return left;
		
		
		int rightIndex = Math.max(mid+1, arr[mid]);
		
		int right = magicFast2(arr, rightIndex, end);
		
		return right;
		
	}
	
	
	
	
	

}

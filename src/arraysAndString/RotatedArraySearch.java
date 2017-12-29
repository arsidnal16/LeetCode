package arraysAndString;

public class RotatedArraySearch {
	
	public int search(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return A[lo] == target ? lo : -1;
	}
	

public static void findRotationPoint(int[] A) {
	int start = 0, end = A.length - 1, mid;
	mid = start + (end - start) / 2;
	int last = A[A.length - 1];
	while (start <= end) {
		if (A[mid] > last) {
			start = mid + 1;
		} else if (A[mid] < last) {
			end = mid - 1;
		} else
			break;
		mid = start + (end - start) / 2;
	}
	System.out.println(A[mid]);
}

}

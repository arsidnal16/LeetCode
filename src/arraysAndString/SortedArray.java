package arraysAndString;

public class SortedArray {
	
	/*
	 * If we are adding a value target that is greater than all elements already in arr, this algorithm does 0 iterations of the loop.

Suppose we are given a series of target values to insert into an initially empty array, and that these values are already sorted.

Then each new value will be greater than all the ones already inserted into the array.

Each call to orderedInsert will use 0 iterations.

and so each call will insert a new element almost instantly.
	 * 
	 */
	
	public int orderedInsert (int arr[], int first, int last, int target)
	// insert target into arr such that arr[first..last] is sorted,
	//   given that arr[first..last-1] is already sorted.
	//   Return the position where inserted.
	{
	  int i = last;  
	  while ((i > first) && (target < arr[i-1]))
	    {   
	      arr[i] = arr[i-1];
	      i = i - 1;
	    }
	  arr[i] = target; 
	  return i;
	}

	
	int binSearch (int arr[], int first, int last, int target)
	// search for target in ordered array of data
	// return index of target, or index of
	// next smaller target if not in collection
	{
	  int mid;      // index of the midpoint
	  int midValue; // object that is assigned arr[mid]
	  int origLast = last; // save original value of last 
	  
	  // repeatedly reduce the area of search
	  // until it is just one target
	  while (first < last) {  // test for nonempty sublist
	    mid = (first + last) / 2; 
	    midValue = arr[mid]; 
	    if (target == midValue) 
	      return mid;
	    else if (target < midValue) 
	      last = mid;        // search lower sublist, reset last 
	    else 
	      first = mid+1;     // search upper sublist, reset first 
	  }
	  return origLast;
	}

}

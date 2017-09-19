package Medium;

public class ReverseString {
	
	public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int low = 0;
        int high = s.length() -1;
        
        while(low<high){
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        
        return String.valueOf(arr);
    }

}

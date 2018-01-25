package arraysAndString;

public class Square {
	
	static int sq(int num){
		
		int i,sum=0,j=1;
		for(i=0;i<num;i++,j+=2)
			sum+=j;
		return sum;
	}

	
	public static void main(String args[]) {
		System.out.println(sq(25));
	}
}

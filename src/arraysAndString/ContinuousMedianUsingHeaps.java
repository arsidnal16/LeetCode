package arraysAndString;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedianUsingHeaps {
	
	private static double[] getContinuousMedians(int[] array) {
		double[] medians=new double[array.length];
		PriorityQueue<Integer> lowers=new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return -1*a.compareTo(b);
			}
		});
		PriorityQueue<Integer> highers=new PriorityQueue<>();
		for(int i=0;i<array.length;i++){
			int num=array[i];
			addNumber(num,lowers,highers);
			rebalance(lowers,highers);
			medians[i]=getMedian(lowers,highers);
		}
		return medians;
	}

	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap=lowers.size()>highers.size()?lowers:highers;
		PriorityQueue<Integer> smallerHeap=lowers.size()>highers.size()?highers:lowers;
		if(biggerHeap.size()==smallerHeap.size()){
			return ((double)biggerHeap.peek()+smallerHeap.peek())/2;
		}
		return biggerHeap.peek();
	}

	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap=lowers.size()>highers.size()?lowers:highers;
		PriorityQueue<Integer> smallerHeap=lowers.size()>highers.size()?highers:lowers;
		if((biggerHeap.size()-smallerHeap.size())>=2){
			smallerHeap.add(biggerHeap.poll());
		}
	}

	private static void addNumber(int num, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if(lowers.size()==0 || num<lowers.peek()){
			lowers.add(num);
		}
		else
			highers.add(num);
	}

	public static void main(String[] args) {
		int A[] = {5,4,3,2,1};
		double[] result=getContinuousMedians(A);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}

	

}
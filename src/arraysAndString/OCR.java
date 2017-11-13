package arraysAndString;

import java.util.ArrayList;
import java.util.List;

public class OCR {
	
	 public static boolean solution(String S, String T) {
	        List<Character> listS = new ArrayList<Character>();
	        List<Character> listT = new ArrayList<Character>();
	        
	        
	        for(int i = 0 ; i <S.length(); i++) {
	        		if(!Character.isDigit(S.charAt(i))) listS.add(S.charAt(i));
	        		else {
	        			int x = Character.getNumericValue(S.charAt(i));
	        			System.out.println(x);
	        			int times = 1;
	        			while(times<= x) {
	        				listS.add('_');
	        				times++;
	        			}
	        		}
	        }
	        
	        System.out.println(listS);
	        
	        for(int i = 0 ; i <T.length(); i++) {
        		if(!Character.isDigit(T.charAt(i))) listT.add(T.charAt(i));
        		else {
        			int x = Character.getNumericValue(T.charAt(i));
        			int times = 1;
        			while(times<= x) {
        				listT.add('_');
        				times++;
        			}
        		}
        }
	        
	        System.out.println(listT);
	        
	        if(listS.size() != listT.size()) return false;
	        
	        for(int i=0; i< listS.size(); i++) {
	        		if(listS.get(i) != '_') {
	        			if(listT.get(i) != '_' ) {
	        			if(listS.get(i) != listT.get(i)) {
	        				return false;
	        			}
	        		}
	        		}
	        }
	        
		 
		 
		 return true;
		 
	    }
	 
	 
	 public static void main(String args[]) {
		 String S = "A2Le";
		 String T = "2pL1";
		 System.out.println(solution(S, T));
		 
		 String Q = "10a";
		 String R = "a10";
		 System.out.println(solution(Q, R));
		 
		 String A = "ba1";
		 String B = "1Ad";
		 System.out.println(solution(A, B));
		 
		 String C = "3x2x";
		 String D = "8";
		 System.out.println(solution(C, D));
		 
	 }

}

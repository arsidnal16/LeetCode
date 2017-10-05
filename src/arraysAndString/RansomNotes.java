package arraysAndString;
import java.util.HashMap;

public class RansomNotes {
	
	public static boolean ransomNotes(int m, int n, String[] magzine, String[] ransom){
        if(n>m){
            return false;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String mag : magzine){
            int count = 1;
            if(map.containsKey(mag)){
                count = map.get(mag)+1;
            }
            map.put(mag, count);
        }
        
        for(String ran : ransom){
            int count = -1;
            if(!map.containsKey(ran)){
                return false; 
            }
            else{
                count = map.get(ran)-1;
                map.put(ran, count);
            }
            
        }
        
       for(String key : map.keySet()){
           if(map.get(key) < 0){
               return false;
           }
       }
        
        return true;
        
    }

}

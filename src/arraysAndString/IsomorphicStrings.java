package arraysAndString;

public class IsomorphicStrings {
/*	
	For example,
	Given "egg", "add", return true.

	Given "foo", "bar", return false.

	Given "paper", "title", return true.

*/
	
	boolean isIsomorphic(String s, String t) {
        int m1[] = new int[256], m2[] = new int[256], n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;  //"+1" is to exclude 0 from valid index.
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

}

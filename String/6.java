/* Rabin Karp 

this algo says to generate a hash value for the samller str,
and if the substr hashVal is equal to the smaller str hashVal then we go for further 
checking to compare them.
Best case for this Algo. is that now other vals. found similar to hashVal of our str
worst is O(N^2)
*/


import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		ArrayList<Integer> list = new ArrayList<>();
        //Rabin Karp
        //Step-1: Generate a hashCode to pat
        int pCode = 0;
        for(int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            pCode = pCode + (ch - 'A');
        }
        
        int sCode = 0;
        for(int i = 0; i < pat.length(); i++) {
            sCode = sCode + (str.charAt(i) - 'A');
        }
        if(pCode == sCode && isSubstring(str, pat, 0)) list.add(0);
        
        for(int i = pat.length(); i < str.length(); i++) {
            //remove last and add new char
            int lastIdx = i-pat.length();
            sCode = sCode - (str.charAt(lastIdx) - 'A');
            sCode = sCode + (str.charAt(i) - 'A');
    
           if(pCode == sCode && isSubstring(str, pat, lastIdx+1)) 
               list.add(lastIdx + 1);
        }
        
        return list;
	}
    
    static boolean isSubstring(String str, String pat, int idx) {
        for(int j = 0; j < pat.length(); j++) {
            if(str.charAt(idx+j) != pat.charAt(j)) return false;
        }
        
        return true;
    }
}

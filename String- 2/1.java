/* Find the Index of the First Occurrence in a String */


class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if(m > n) return -1;
        
        int i = 0;
        while(i <= (n-m)) {
            //comparing both strs
            if(isEqual(haystack, needle, i, m, n)) return i;
            i++;
        }
        
        return -1;
    }
    
    static boolean isEqual(String haystack, String needle, int idx, int m, int n) {
        for(int j = 0; j < m; j++) {
            if(haystack.charAt(j + idx) != needle.charAt(j)) return false;
        }
        
        return true;
    }
}
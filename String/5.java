/* Longest Common Prefix */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        
        Arrays.sort(strs);
        StringBuilder res = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length()) {
            if(first.charAt(c) != last.charAt(c)) return res.toString();
            else res.append(first.charAt(c));
            
            c++;
        }
        
        return res.toString();
    }
}
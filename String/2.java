/* Longest Palindromic Substring */

class Solution {
    public String longestPalindrome(String s) {
        //Total no. of substrings in a string of length n is (n * (n+1) / 2)
        //Applying same approach of dp to compute number of pallindromic substr in str
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int st = 0;
        int ed = 0;
        for(int g = 0; g < n; g++) {
            for(int i = 0, j = g; j < n; i++, j++) {
                if(g == 0) {
                    dp[i][j] = true;
                }else if(g == 1) {
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                }else {
                   if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                      dp[i][j] = true; 
                }
                if(dp[i][j] && ((j-i) + 1) > maxLen) {
                    maxLen = (j-i) + 1;
                    st = i;
                    ed = j;
                } 
            }  
        }
        
        String res = "";
        for(int p = st; p <= ed; p++) {
            res += s.charAt(p);
        }
        
        return res;
    }
    
}
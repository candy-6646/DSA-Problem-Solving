/* Palindromic Substrings Count */

class Solution {
    public int countSubstrings(String s) {
        //Solving using DP
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //we just need to traverse the upper diagonals
        //because taking start pt. on left and end pt. on right for a subStr
        int count = 0;
        for(int gap = 0; gap < n; gap++) {
            //always start from first row to trverse a diagonal
            //and go till last col
            //i= start of substr and j = end of substr
            for(int i = 0, j = gap; j < n; i++, j++) {
                //gap = 0 means we are in first diagonal where len of each substr == 1
                if(gap == 0) {
                    dp[i][j] = true;
                }else if(gap == 1) {
                    //if gap is 1 means length of substr == 2
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                    else dp[i][j] = false;
                }else {
                    //if substr len > 2 then compare ith and jth and check
                    //remaining chars from i+1 to j-1 are pallindrome or not
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                       dp[i][j] = true; 
                    }else {
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j]) count++;
            }
        }
        
        return count;
    }
}
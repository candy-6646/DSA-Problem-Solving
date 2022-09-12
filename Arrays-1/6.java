/* Stock Buy And Sell */

class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int lpsf = Integer.MAX_VALUE;
        int pist = 0;
        
        for(int i = 0; i < prices.length; i++) {
            lpsf = Math.min(lpsf, prices[i]);
            
            pist = prices[i] - lpsf;
            maxPro = Math.max(pist, maxPro);
        }
        
        return maxPro;
    }
}
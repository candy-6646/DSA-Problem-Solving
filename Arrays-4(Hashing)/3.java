/* Longest Consecutive Sequence 

Concept:-
    subarray/substring -> contiguous part of arr/str
    subSequence -> non-contiguous but in order
    subset -> non-contiguous and not in order

*/


/*****************************O(3N)tc and O(N)sp******************************* */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        
        int ms = 1;
        
        for(int num : nums) {
            //is the curr num is start of a sequence or not
            if(!hs.contains(num-1)) {
                int cs = 1;
                int currNum = num;
                while(hs.contains(currNum + 1)) {
                    currNum++;
                    cs++;
                }
                
                ms = Math.max(ms, cs);
            }
        }
        
        return ms;
    }
}
/* Remove Duplicates from Sorted Array 


two ptr Appraoch in O(N)
*/



class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for(int i= 1; i < nums.length; i++) {
            if(nums[idx] != nums[i]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        
        return idx+1;
    }
}
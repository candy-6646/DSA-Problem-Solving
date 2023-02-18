/******************************

Majority Element
The majority element is the element that appears more than ⌊n / 2⌋ times. 

Effective way is to use Voting Algo.

********************************** */


class Solution {
    public int majorityElement(int[] nums) {
        int ele = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                ele = nums[i];
            }
            
            if(ele == nums[i]) {
                count++;
            }else {
                count--;
            }
        }
        
        return ele;
    }
}
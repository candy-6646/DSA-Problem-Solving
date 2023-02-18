/************************
Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Using Extended voting algo.

**************************** */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if(num == ele1) c1++;
            else if(num == ele2) c2++;
            else if(c1 == 0) {
                ele1 = num;
                c1 = 1;
            }else if(c2 == 0) {
                ele2 = num;
                c2 = 1;
            }else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if(num == ele1) c1++;
            else if(num == ele2) c2++;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        if(c1 > nums.length / 3) {
            ans.add(ele1);
        }
        
        if(c2 > nums.length / 3) {
            ans.add(ele2);
        }
        
        return ans;
    }
}
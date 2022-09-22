/* 3Sum Arrays 

O(N^2)
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            
            // all numbers from now on will be greater than 0, no point in continuing
		    if (nums[i] > 0) break;
            
            //fixing one ptr at i and finding remaianing using 2ptr appraoch
            if(i == 0 || nums[i] != nums[i-1]) {
                int tar = 0 - nums[i];
                int lo = i+1;
                int hi = nums.length - 1;
                
                while(lo < hi) {
                    if(nums[lo] + nums[hi] == tar) {
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[lo]);
                        ls.add(nums[hi]);
                        ans.add(ls);
                        
                        //shifting ptr till repeating ele found
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }else if(nums[lo] + nums[hi] > tar) {
                        hi--;
                    }else {
                        lo++;
                    }
                }
            }
            
            i++;
        }
        
        return ans;
    }
}
/*  4Sum 

As in this problem we are required to find unique quadruplets
we also need to take care of duplicate vals. and ans is in sorted order

*/


/*****************************BRUTE FORCE********************************/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                for(int k = j + 1; k < n - 1; k++) {
                    if(k > j+1  && nums[k] == nums[k-1]) continue;
                    for(int l = k + 1; l < n; l++) {
                        if(l > k+1 && nums[l] == nums[l-1]) continue;
                        long cs = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                        
                        if(cs == (long)target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            
                            lists.add(list);
                        }
                    }
                }
            }
        }
        
        return lists;
    }
}



/****************************O(N logN + N^3)************************************/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                long rt = (long)target - ((long)nums[i] + (long)nums[j]);
                int l = j + 1;
                int h = n-1;
                while(l < h) {
                    if(nums[l] + nums[h] == rt) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[h]);
                        
                        lists.add(list);
                        while(l < h && nums[l] == list.get(2)) l++;
                        while(l < h && nums[h] == list.get(3)) h--;
                    }else if(rt > nums[l] + nums[h]) {
                        l++;
                    }else {
                        h--;
                    }
                }
            }
        }
        return lists;
    }
}
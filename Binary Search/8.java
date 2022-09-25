/* Minimum Limit of Balls in a Bag 

same problem as min.number of pages problem

Here we want to reduce penalty. penalty is the max. number of balls in a bag
so we want to reduce max. number of balls in a bag to minimum

Approach-
    first we check for a particular range, if that range is valid then we will try to minimise it more
    else not a valid range then we will try to find answer on a high range
*/

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        
        //l = 1, i.e, minimum 1 ball needs to be in a bag
        //r = max(arr) min. this much amount of balls a bag is holding, i.e, curr min. panalty
        int l = 1;
        int r = nums[0];
        for(int i = 1;i < n; i++) r = Math.max(r, nums[i]);
        
        int ans = -1;
        while(l <= r) {
            int mid = (l + r) / 2;
            //checking can we reduce penalty upto mid in given operations
            //if yes then we will try to reduce penalty more
            //else if it is taking more operations than penalty will increase
            if(isValid(nums, n, mid, maxOperations)) {
                ans = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        
        return ans;
    }
    
    private static boolean isValid(int[] arr, int n, int range, int maxOper) {
        int currOper = 0;
        
        for(int i = 0; i < n; i++) {
            //Ex- arr[i] = 3 and range 4, not possible to divide
            //Ex- arr[i] = 12 and range 4, 12%4 == 0 and 12/4 = 3 but op = 2
            //op = 2 because it will be divided in 4-4-4(8-4 then 4-4-4) in just two operation
            //Ex- arr[i] = 9 and range 4, 9%4 != 0 and 9/4 = 2 then op = 2
            //op = 2 because 9-> 5, 4 -> 1, 4, 4
            if(arr[i] > range) {
                int temp = arr[i] / range;
                if(arr[i] % range == 0) temp--;
                currOper += temp;
            }
        }
        
        if(currOper <= maxOper) return true;
        return false;
    }
}
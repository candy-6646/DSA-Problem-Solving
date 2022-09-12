/* Next Permutation */
/* for this problem we can see a pattern, the seq from R->L is always increasing */
/* Either 1 increasing element be there or more */
/* so first we need to find a break point where sequence is falling i.e. arr[i] < arr[i+1] */
/*If no decreasing seq. found means max possible seq. it is, so rev */
/*Else now find just greater Ele from idx ele of decreasing seq, while traversing from R->L */
/* swap them and rev fro Idx + 1 to n, so now peak is the element we just swapped*/

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) {
            return;
        }
        
        int idx1 = -1;
        int idx2 = 0;
        
        //finding Break point
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                idx1 = i;
                break;
            }
        }
        
        if(idx1 < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }else{
            for(int i = nums.length - 1; i > idx1; i--) {
                if(nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }
        }
        
        //swap
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
        
        reverse(nums, idx1 + 1, nums.length - 1);
        
    }
    
    public static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
/* Sort an array of 0’s 1’s 2’s
Approach-1 use 3 vars for counting of 0, 1 & 2
Approach-2 three pointers (i -> 0, j - > 1 & k -> 2)

if(arr[i] == 0) swap(i, j) then i++, j++;
if(arr[i] == 1) then i++;
if(arr[i] == 2) then swap(i, k) then k--;

*/



class Solution {
    public void sortColors(int[] nums) {
        
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        
        while(i <= k) {
            if(nums[i] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            }else if(nums[i] == 1) {
                i++;
            }else {
                swap(nums, i, k);
                k--;
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
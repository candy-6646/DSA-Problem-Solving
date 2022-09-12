/* Find the duplicate in an array of N+1 integers 


Use sorting then find nums[i] == num[i+1] return nums[i]

use frequency arr as nums are in range of n+1

*/



class Solution {
    public int findDuplicate(int[] nums) {
        int[] frequencyArr = new int[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++) {
            frequencyArr[nums[i]]++;
        }
        
        int num = -1;
        for(int i = 1; i < frequencyArr.length; i++) {
            if(frequencyArr[i] > 1) {
                num =  i;
                break;
            }
        }
        
        return num;
    }
}
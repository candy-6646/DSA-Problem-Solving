/* Kadane’s Algorithm : Maximum Subarray Sum in an Array */

class Solution {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        //Getting Sub-Array start Idx and End Idx
        ArrayList<Integer> subarray = new ArrayList<>();


        int ms = Integer.MIN_VALUE;
        int cs = 0;
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            if(cs + nums[i] > nums[i]){
                cs += nums[i];
            }else{
                cs = nums[i];
                s = i;
            }
    
            if(cs > ms){
                ms = cs;
                subarray.clear();
                subarray.add(s); 
                subarray.add(i);
            }
        }
        System.out.println(ms + " max sum. ");
        System.out.println(subarray.get(0) + "  " + subarray.get(1));
        return ms;
    }
}
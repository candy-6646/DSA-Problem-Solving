/* Two Sum 

Hashing Sol- we are linearly iterating through arr and storing the (arr[i], i) in hashMap and 
at same time we are seraching for (tar - arr[i])
*/



class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n1 = 0;
        int n2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            
            if(hm.containsKey(rem)) {
                n1 = hm.get(rem);
                n2 = i;
                break;
            }else {
                hm.put(nums[i], i);
            }
        }
        
        return new int[] {n1, n2};
    }
}
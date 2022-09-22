/* Trapping Rainwater 

Brute force solution is to start from i = 1 to i < n-1;
    At each idx = i, for a val at arr[i] find leftmax and rightmax
    then take minimum from lMax and rMax
    and add water += min - arr[i];


Optimized solution can be to use extra space where for each arr[i] it's lMax and rMax is already computed
*/


class Solution {
    public int trap(int[] height) {
        
        int res = 0;
        int[] lMax = findLeftMax(height);
        int[] rMax = findRightMax(height);
        
        for(int i = 1; i < height.length-1; i++) {

            int minHeight = Math.min(lMax[i], rMax[i]);
            res += minHeight - height[i];
        }
        
        return res;
    }
    
    public static int[] findLeftMax(int[] arr) {
        int[] lMax = new int[arr.length];
        int currMax = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > currMax) currMax = arr[i];
            lMax[i] = currMax;
        }
        
        return lMax;
    }
    
    public static int[] findRightMax(int[] arr) {
        int[] rMax = new int[arr.length];
        int currMax = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > currMax) currMax = arr[i];
            rMax[i] = currMax;
        }
        
        return rMax;
    }
}



/*********************************Without extra space O(N) solution*****************************************/
class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int lMax = 0;
        int rMax = 0;
        int water = 0;
        while(l < r) {
            //we will only enter here when it is assured that on right there is
            //something greater than or equal to curr arr[l]
            //and we have already computed lMax so now ans += lMax - arr[l]
            if(height[l] <= height[r]) {
                if(height[l] >= lMax) lMax = height[l];
                else water += lMax - height[l];
                l++;
                
            //here in this condition it is assured that on left there is something
            //greater than or equal to curr arr[r] val
            }else { //height[l] >= height[r]
                if(height[r] >= rMax) rMax = height[r];
                else water += rMax - height[r];
                r--;
            }
        }
        
        return water;
    }
}
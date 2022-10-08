/* Largest subarray with 0 sum */


class GfG
{
    int maxLen(int A[], int n)
    {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        int maxi = 0;
        int sum = 0; 

        for(int i = 0;i<n;i++) {

            sum += A[i]; 

            //if at any point the sum == 0, means array elements sum till i is zero and len is (i+1)
            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                //if we got the sum as previous sum that we computed somewhere earlier
                //again getting this sum means the sum in b/w these two pts. is zero
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {

                    mpp.put(sum, i); 
                }
            }
        }
        return maxi;
    }
}
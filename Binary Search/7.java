/* Min Number Of Pages */



class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M > N) return -1;
        
        int sum = 0;
        for(int i = 0; i < N; i++) sum += A[i];
        
        int ans = 0;
        int l = 0;
        int r = sum;
        
        while(l <= r) {
            int mid = (l + r) / 2;
            
            if(isValid(A, N, M, mid)) {
                ans = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        
        return ans;
    }
    public static boolean isValid(int[] arr, int n, int b, int max) {
        int sum = 0;
        int students = 1;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            
            if(sum > max) {
                sum  = arr[i];
                students++;
                
                if(sum > max) return false;
            }
            
            if(students > b) return false;
        }
        
        return true;
    }
}
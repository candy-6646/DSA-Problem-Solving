/* 
Matrix Median

TC- log(2^32) * N*log(M)

    32 * N*log(M)


    we are applying bin search on range
    and checking every time that for a particular mid val how many ele are smaller that it.
*/


import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
        int n = matrix.size();
        int m = matrix.get(0).size();
		int lo = 1;
        int hi = (int)1e5;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            
            int count = findLesserCount(matrix, mid);
            
            if(count <= (n*m)/2) {
                lo = mid+1;
            }else {
                hi = mid-1;
            }
        }
        
        return lo;
	}
    
    static int findLesserCount(ArrayList<ArrayList<Integer>> matrix, int tar) {
        int count = 0;
        for(int i = 0; i < matrix.size(); i++) {
            int l = 0;
            int h = matrix.get(i).size()-1;
            
            while(l <= h) {
                int mid = (l+h) / 2;
                
                if(matrix.get(i).get(mid) <= tar) {
                    l = mid+1;
                }else {
                    h = mid-1;
                }
            }
            count += l;
        }
        
        return count;
    }
}
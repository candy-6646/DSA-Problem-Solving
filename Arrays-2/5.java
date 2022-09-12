/* Find the repeating and missing numbers \

Brute force is using frequency Array.

without extra space for a read only array is to use mathematical equation

    S = N*(N+1)/2 ---- equation 1
    P = N(N+1)(2N+1)/6. ----- equation 2
    s1 = Sum of all elements of the array. —– equation 3
    P1 = Sum of squares of all elements of the array. ——– equation 4

    now
    (X-Y) = s – s1 = s’

    X^2 – Y^2 = P – P1 = P’ ==> X + Y = P’/s’

    now equate equations:
    (X – Y) = s’

    (X + Y) = P’/s’
*/




public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        // int[] freqArr = new int[A.length + 1];
        
        // for(int i = 0; i < A.length; i++) {
        //     freqArr[A[i]]++;
        // }
        
        // int rep = -1;
        // int missing = -1;
        // for(int i = 1; i < freqArr.length; i++) {
        //     if(freqArr[i] == 0) {
        //         missing = i;
        //     }
            
        //     if(freqArr[i] > 1) {
        //         rep = i;
        //     }
        // }
        
        //Maths Solution
        int n = A.length;
        long s = (n * (n + 1)) / 2;
        long p = (n * (n + 1) * (2 * n + 1)) / 6;
        long missing = 0;
        long repeating = 0;
        
        for(int i = 0; i < n; i++) {
            s -= (long)A[i];
            p -= (long)A[i] * (long)A[i];
        }
        
        missing = (s + p / s) / 2;
        repeating = missing - s;
        
        int[] arr = new int[2];
        arr[0] = (int)repeating;
        arr[1] = (int)missing;
        return arr;
    }
}



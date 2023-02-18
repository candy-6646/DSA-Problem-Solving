/*************************
Pow(x, n)
Brute force is to compute answer till N
Optimised is log(n) solution
****************************/

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double ans = 1.0;
        long nn = n;
        //if power is -ve making it +ve for now to compute result
        if(nn < 0)
            nn = -1 * nn;
        
        
        while(nn > 0) {
            if(nn % 2 == 1) {
               ans *= x;
                nn--;
            }else {
               x = x * x;
               nn /= 2;
            }
        }
        
        if(n < 0)
            ans = (double)1.0 / (double)ans;
        
        return ans;
    }
}
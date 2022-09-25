/* The N-th root of an integer 

TC -  N x log(M x 10^d)
    N -> we are multiplying mid N times in while loop
    M X 10^d -> M is in decimal go upto each decimal place till 0.0, 0.1, 0.2, .... 0.10
*/


public static double findNthRootOfM(int n, int m) {
		double l = 1;
        double r = m;
        //take eps as 1e-9, since we have to find answers to 9 decimal places.
        double eps = 1e-9; 
        
        while((r - l) > eps) {
            double mid = (l + r) / 2.0;
            
            //multiplying mid, n times
            double num = 1.0;
            for(int i = 1; i <= n; i++) num *= mid;
            
            if(num < m) l = mid;
            else r = mid;
        }
        
        return r;
	}
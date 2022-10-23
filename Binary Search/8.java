/* Aggressive Cows */

public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
        Collections.sort(stalls);
        int min = stalls.get(0);
        int max = stalls.get(stalls.size()-1);
        
        int l = 1;
        int r = max-min;
        int ans = -1;
        while(l <= r) {
            int mid = (l+r) / 2;
            if(isValid(stalls, k, mid)) {
                ans = mid;
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return ans;
    }
    
    static boolean isValid(ArrayList<Integer> stalls, int k, int range) {
        int c = 1;
        int prevCow = 0;
        for(int i = 1; i < stalls.size(); i++) {
            int curr = stalls.get(i);
            if(curr - stalls.get(prevCow) >= range) {
                prevCow = i;
                c++;
            }
            
            if(c == k) return true;
        }
        
        return false;
    }
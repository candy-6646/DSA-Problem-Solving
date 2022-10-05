/*  String to Integer (atoi) */


class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int i = 0;
        if(s.length() == 0) return 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }
        
        long res = 0;
        while(i < s.length()) {
            int num = s.charAt(i) - '0';
            if(num < 0 || num > 9) break;
            
            res = 10 * res + num;
            if(res > (Math.pow(2, 31) - 1)) {
                return sign == -1 ? -1-Integer.MAX_VALUE : Integer.MAX_VALUE;
            }
            
            i++;
        }
        
        return (int)res * sign;
    }
}
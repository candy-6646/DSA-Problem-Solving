/* Roman to Integer */

class Solution {
    public int romanToInt(String s) {
        int number = 0;
        int i = 0;
        while(i < s.length()) {
            char fi = s.charAt(i);
            char se = '-';
            if(i < s.length() - 1) se = s.charAt(i+1);
            
            if(se != '-' && valueOf(fi) < valueOf(se)) {
                int n1 = valueOf(se);
                int n2 = valueOf(fi);
                number += (n1-n2);
                i += 2;
            }else {
               number += valueOf(fi); 
                i++;
            }
        }
        
        return number;
    }
    
    static int valueOf(char ch) {
        if(ch == 'I') return 1;
        else if(ch == 'V') return 5;
        else if(ch == 'X') return 10;
        else if(ch == 'L') return 50;
        else if(ch == 'C') return 100;
        else if(ch == 'D') return 500;
        else return 1000;
    }
}
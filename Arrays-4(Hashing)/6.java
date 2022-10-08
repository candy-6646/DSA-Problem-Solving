/* Longest Substring without repeat

Brute force is:
    Add char to hashMap, while trversing linearly but if you encounter same char that is already in 
    hashMap, it means your maxLen str is till here, now we have a start ptr which is pointing to
    the st. of this substr, and then from it's start to endIdx->hm.get(ch), we will gonna remove all
    the chars from hm, because we are using hm.size() for comp here. Move your new start = end+1



Optimised app. is:
    Instead of removing old vals from Map, we will use pointers to do this work.
    Stuck ? It will create problem because older vals. are still in hm,
    so do a check for left, left = Math.max(left, hm.get(ch) + 1);

    for length- (r-l+1)

*/



/*********************** O(2N) ***************************************/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen = 0;
        int st = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(hm.containsKey(ch)) {
                //removing chars from startIdx of subStr to curr 
                //char where repeating start again
                int end = hm.get(ch);
                for(int j = st; j <= end; j++) {
                    char curr = s.charAt(j);
                    hm.remove(curr);
                }
                st = end+1;
            }
            
            hm.put(ch, i);
            maxLen = Math.max(maxLen, hm.size());
        }
        
        return maxLen;
    }
}















/******************************************** O(N) ****************************************************/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen = 0;
        int st = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(hm.containsKey(ch)) {
                //last occ of repeated char
                int end = hm.get(ch);
                st = Math.max(st, end + 1);
            }
            hm.put(ch, i);
            maxLen = Math.max(maxLen, (i-st) + 1);
        }
        
        return maxLen;
    }
}
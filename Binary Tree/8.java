/* Top View of Binary Tree */


class Pair {
    int val;
    int lev;
    
    Pair(int v, int l) {
        val = v;
        lev = l;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        //It is used to keep track of val that encountered first
        TreeMap<Integer, Pair> hm = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, 0, 0, hm);
        for(Pair x: hm.values()) {
            ans.add(x.val);
        }

        return ans;
        
    }
    static void helper(Node root, int d, int lev, TreeMap<Integer, Pair> hm) {
        if(root == null) return;

        if(!hm.containsKey(d)) hm.put(d, new Pair(root.data, lev));
        else {
            //if level of curr node is less, then update
            if(lev < hm.get(d).lev) {
                hm.put(d, new Pair(root.data, lev));
            }
        }
        helper(root.left, d-1, lev+1, hm);
        helper(root.right, d+1,lev+1, hm);
    }
}
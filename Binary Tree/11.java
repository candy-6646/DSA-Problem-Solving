/* Root to node path in a Binary Tree */

public class Solution {
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        findPath(A, B, ans);
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
    
    boolean findPath(TreeNode A, int B, ArrayList<Integer> ans) {
        if(A == null) return false;
        
        ans.add(A.val);
        if(A.val == B) return true;
        
        if(findPath(A.left, B, ans) || findPath(A.right, B, ans)) return true;
        ans.remove(ans.size()-1);
        return false;
    }
}
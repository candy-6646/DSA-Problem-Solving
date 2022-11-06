/* Postorder Traversal */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversePost(root, ans);
        return ans;
    }
    
    void traversePost(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        
        traversePost(root.left, ans);
        traversePost(root.right, ans);
        ans.add(root.val);
    }
}
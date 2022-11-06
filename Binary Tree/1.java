/* Inorder Traversal */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverseInorder(root, ans);
        return ans;
    }
    
    void traverseInorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        
        traverseInorder(root.left, ans);
        ans.add(root.val);
        traverseInorder(root.right, ans);
    }
}
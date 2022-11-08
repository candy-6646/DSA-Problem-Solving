/* Inorder Traversal 

Iterative way- Add curr to stack and go on left until root != null (means root.left != null)
    once root.left == null, pick ele from top of st. and print it and go on right

*/
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
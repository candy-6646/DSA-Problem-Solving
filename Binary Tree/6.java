/*LeftView Of Binary Tree*/

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      //Add first node during bfs traversal
      Queue<Node> q = new LinkedList<>();
      ArrayList<Integer> ans = new ArrayList<>();
      if(root == null) return ans;
      
      q.add(root);
      while(!q.isEmpty()) {
          int size = q.size();
          for(int i = 0; i < size; i++) {
              Node curr = q.poll();
              if(i == 0) ans.add(curr.data);
              
              if(curr.left != null) q.add(curr.left);
              if(curr.right != null) q.add(curr.right);
          }
      }
      
      return ans;
    }
}
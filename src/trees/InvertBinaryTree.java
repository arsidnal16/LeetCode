package trees;

/*
 * 
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * 
 * 
 * 
 */


public class InvertBinaryTree {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

         TreeNode left = root.left;
          TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

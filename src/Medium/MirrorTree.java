package Medium;

public class MirrorTree {
	
	//convert into mirror tree
	 TreeNode mirror(TreeNode node)
	    {
	        if (node == null)
	            return node;
	 
	        /* do the subtrees */
	        TreeNode left = mirror(node.left);
	        TreeNode right = mirror(node.right);
	 
	        /* swap the left and right pointers */
	        node.left = right;
	        node.right = left;
	 
	        return node;
	    }
	 
	 
	 /* Given two trees, return true if they are
     mirror of each other */
  boolean areMirror(TreeNode a, TreeNode b) 
  {
      /* Base case : Both empty */
      if (a == null && b == null)
          return true;

      // If only one is empty
      if (a == null || b == null) 
          return false;

      /* Both non-empty, compare them recursively
         Note that in recursive calls, we pass left
         of one tree and right of other tree */
      return a.val == b.val
              && areMirror(a.left, b.right)
              && areMirror(a.right, b.left);
  }

}




/*
 * 
 * The basic idea is here:
Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side,
 IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)
 * 
 */

public class BSTFromInorderAndPreOrder {
	
	
	public class TreeNode {
		      int val;
		     TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    if(preorder.length!=inorder.length) return null;
	    return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}

	public TreeNode build(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
	    if(preLow>preHigh || inLow>inHigh) return null;
	    TreeNode root = new TreeNode(preorder[preLow]);
	   
	    int inorderRoot = inLow;
	    for(int i=inLow;i<=inHigh;i++){
	        if(inorder[i]==root.val){ inorderRoot=i; break; }
	    }
	   
	    int leftTreeLen = inorderRoot-inLow;
	    root.left = build(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
	    root.right = build(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);       
	    return root;        
	}
}

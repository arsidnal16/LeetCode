package trees;

public class LowestCommonAncestorOfBST {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if( root == p || root == q || root == null)
	           return root;
        if(root.val > p.val && root.val > q.val){
           return lowestCommonAncestor(root.left, p, q);
       }else if(root.val < p.val && root.val < q.val){
           return lowestCommonAncestor(root.right, p, q);
       }else{
           return root;
       }
   }
}



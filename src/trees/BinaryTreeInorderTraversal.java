package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	 public List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> list = new ArrayList<Integer>();

		    Stack<TreeNode> stack = new Stack<TreeNode>();
		    TreeNode cur = root;

		    while(cur!=null || !stack.empty()){
		        while(cur!=null){
		            stack.add(cur);
		            cur = cur.left;
		        }
		        cur = stack.pop();
		        list.add(cur.val);
		        
		        if(cur.right != null)cur = cur.right;
		    }

		    return list;
	    }
	 
	 
	 public void inorderRec(TreeNode root) {
	        if (root != null) {
	            inorderRec(root.left);
	            System.out.println(root.val);
	            inorderRec(root.right);
	        }
	    }

}

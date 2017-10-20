package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	

	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	 public void levelOrderTraversal(TreeNode root){
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			while(!q.isEmpty()){
				TreeNode current = q.poll();
				System.out.print(current.val + " ");
				if(current.left != null){
					q.add(current.left);
				}
				if(current.right != null){
					q.add(current.right);
				}
				
				
			}
			
		}

}

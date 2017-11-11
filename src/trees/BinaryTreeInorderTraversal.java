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
	        
	        if(root == null){
				return list;
			}
			Stack<TreeNode> s = new Stack<TreeNode>();
			TreeNode current = root;
			
			while(current!=null){
				s.push(current);
				current = current.left;
			}
			while(!s.isEmpty()){
				current = s.pop(); 
				list.add(current.val);
				if(current.right != null){
					current = current.right;
					while(current != null){
						s.push(current);
						current = current.left;
					}
				}
			}
	        return list;
	    }

}

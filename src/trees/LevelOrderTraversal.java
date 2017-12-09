package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static TreeNode root;
	

	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	 
	 
	 public static void main(String args[]) 
	    {
	        /* creating a binary tree and entering 
	         the nodes */
	       LevelOrderTraversal tree_level = new LevelOrderTraversal();
	        tree_level.root = tree_level.new TreeNode(1);
	        tree_level.root.left = tree_level.new TreeNode(2);
	        tree_level.root.right = tree_level.new TreeNode(3);
	        tree_level.root.left.left = tree_level.new TreeNode(4);
	        tree_level.root.left.right = tree_level.new TreeNode(5);
	        tree_level.root.right.left = tree_level.new TreeNode(6);
	        tree_level.root.right.right = tree_level.new TreeNode(8);
	        tree_level.root.left.left.left = tree_level.new TreeNode(7);
	        tree_level.root.left.right.left = tree_level.new TreeNode(9);
	        
	        
	        System.out.println("Level order traversal of binary tree is - ");
	        LevelOrderTraversal.levelOrderTraversal(root);
	        System.out.println();
	        LevelOrderTraversal.levelOrderTraversal2(root);
	       
	    }

	
	 public static void levelOrderTraversal(TreeNode root){
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
	 
	 
	 
	 
	 public static void levelOrderTraversal2(TreeNode root){
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			while(!q.isEmpty()){
				// nodeCount (queue size) indicates number of nodes
	            // at current level.
	            int nodeCount = q.size();
	            if(nodeCount == 0)
	                break;
	             
	            // Dequeue all nodes of current level and Enqueue all
	            // nodes of next level
	            while(nodeCount > 0)
	            {
	                TreeNode node = q.peek();
	                System.out.print(node.val + " ");
	                q.remove();
	                if(node.left != null)
	                    q.add(node.left);
	                if(node.right != null)
	                    q.add(node.right);
	                nodeCount--;
	            }
	            System.out.println();
	        }
			
		}

}

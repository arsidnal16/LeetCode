package trees;
public class SubtreeOfATree {
	
	
	static Node root1;
	static Node root2;
	public boolean areIdentical(Node root1, Node root2){
		
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		
		return(root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
		
		
	}
	
	public boolean isSubtree(Node n1, Node n2){
		if(n2 == null){
			return true;
		}
		if(n1 == null){
			return false;
		}
		if (areIdentical(n1, n2)){
			return true;
		}
		
		return isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
			
	}
	
	 public static void main(String args[]) {
	        SubtreeOfATree tree = new SubtreeOfATree();
	         
	        // TREE 1
	        /* Construct the following tree
	              26
	             /   \
	            10     3
	           /    \     \
	          4      6      3
	           \
	            30  */
	          
	        tree.root1 = new Node(26);
	        tree.root1.right = new Node(3);
	        tree.root1.right.right = new Node(3);
	        tree.root1.left = new Node(10);
	        tree.root1.left.left = new Node(4);
	        tree.root1.left.left.right = new Node(30);
	        tree.root1.left.right = new Node(6);
	 
	        // TREE 2
	        /* Construct the following tree
	           10
	         /    \
	         4      6
	          \
	          30  */
	          
	        tree.root2 = new Node(10);
	        tree.root2.right = new Node(6);
	        tree.root2.left = new Node(4);
	        tree.root2.left.right = new Node(30);
	 
	        if (tree.isSubtree(root1, root2)) {
	            System.out.println("Tree 2 is subtree of Tree 1 ");
	        } else {
	            System.out.println("Tree 2 is not a subtree of Tree 1");
	        }
	    }
	}
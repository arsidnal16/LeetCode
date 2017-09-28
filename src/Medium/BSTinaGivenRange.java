package Medium;

class Node {
	 
    int data;
    Node left, right;
 
    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class BSTinaGivenRange {
	
		
		
	     
	    static Node root;
	     
	    /* The functions prints all the keys which in the given range [k1..k2].
	     The function assumes than k1 < k2 */
	    void Print(Node node, int k1, int k2) {
	         
	        /* base case */
	        if (node == null) {
	            return;
	        }
	 
	        /* Since the desired o/p is sorted, recurse for left subtree first
	         If root->data is greater than k1, then only we can get o/p keys
	         in left subtree */
	        if (k1 < node.data) {
	            Print(node.left, k1, k2);
	        }
	 
	        /* if root's data lies in range, then prints root's data */
	        if (k1 <= node.data && k2 >= node.data) {
	            System.out.print(node.data + " ");
	        }
	 
	        /* If root->data is smaller than k2, then only we can get o/p keys
	         in right subtree */
	        if (k2 > node.data) {
	            Print(node.right, k1, k2);
	        }
	    }
	     
	 
	    public static void main(String[] args) {
	    	BSTinaGivenRange tree = new BSTinaGivenRange();
	        int k1 = 10, k2 = 25;
	        tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(22);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(12);
	 
	        tree.Print(root, k1, k2);
	    }
	

}

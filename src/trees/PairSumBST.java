package trees;
import java.util.Stack;


// Find a pair with given sum in a Balanced BST

public class PairSumBST {
	
	public static Node root, current;
	static int n=0;
	
	public static int sum2(Node A, int B) {
	    Stack<Node> stack1 = new Stack<>();
	    Stack<Node> stack2 = new Stack<>();
	    Node cur1 = A;
	    Node cur2 = A;

	    while (!stack1.isEmpty() || !stack2.isEmpty() || cur1 != null || cur2 != null) {
	        if (cur1 != null || cur2 != null) {
	            if (cur1 != null) {
	                stack1.push(cur1);
	                cur1 = cur1.left;
	            }

	            if (cur2 != null) {
	                stack2.push(cur2);
	                cur2 = cur2.right;
	            }
	        } else {
	            int val1 = stack1.peek().data;
	            int val2 = stack2.peek().data;

	            // need to break out of here
	            if (stack1.peek() == stack2.peek()) break;

	            if (val1 +  val2 == B) {
	            	System.out.println("The pair is "+val1 +" and "+val2);
	            	return 1;
	            }

	            if (val1 + val2 < B) {
	                cur1 = stack1.pop();
	                cur1 = cur1.right;
	            } else {
	                cur2 = stack2.pop();
	                cur2 = cur2.left;
	            }
	        }
	    }
	    System.out.println("No such pairs");
	    return 0;
	}

public Node insert(Node root, int element){ // A function to insert a new key in Binary search tree(BST)
	
	if(root == null ){
		root = new Node(element); // If the tree is empty return a new node
		//System.out.println("The root inserted is " + root.data );
		return root;
		
	}
	else{
		if (element < root.data){  
			root.left = insert(root.left, element); //recurse the left subtree
		}
		else{
			root.right =insert(root.right, element); // recurse the right subrtree
		}
	}
	return root;
	
}
	
	public static void main(String args[]){
		
		PairSumBST tree = new PairSumBST();
		root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        sum2(root, 24);
        sum2(root, 28);
        sum2(root, 32);
        sum2(root, 25);
	}

}
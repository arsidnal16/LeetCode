package trees;
public class InOrderSuccessor {
	
	public static Node root;
	
	public static Node successor = null;
	
	public Node inOrderSuccessor(Node root, int element){
		
		
/*
 * 1) If right subtree of node is not NULL, then successor lies in right subtree. Do following.
		Go to right subtree and return the node with minimum key value in right subtree.
   
   2) If right subtree of node is NULL, then start from root and use search like technique. Do following.
		Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
 * 
 * 
 */
		
		if(root.right !=null){
			return minValue(root.right);
		}
		
		while(root!= null){
			if(root.data > element){
				successor = root;
				root = root.left;
			}
			else if (root.data< element){
				root = root.right;
			}
			else break;
		}
		return successor;
	}
	
	
	private Node minValue(Node right) {
		Node current = right;
		
		while(current.left != null){
			current = current.left;
		}
		return current;
	}


	public void insert(int element){
		root = insert(root, element);
		}
	
	public Node insert(Node root, int element){ // A function to insert a new key in Binary search tree(BST)
		
		if(root == null ){
			root = new Node(element); // If the tree is empty return a new node
			System.out.println("The root inserted is " + root.data );
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
	
	
	public static void main(String[] args) {
        InOrderSuccessor tree = new InOrderSuccessor();
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        
        Node suc = tree.inOrderSuccessor(root, 14);
        if (suc != null) {
            System.out.println("Inorder successor of 14 is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }
	}
	
}
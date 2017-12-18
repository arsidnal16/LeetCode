package trees;

/*
 * Searching, deleting and inserting elements in a binary search tree.
 * 
 * 
 */

public class BinarySearchTree {
	
	Node root;
	
	
	public BinarySearchTree(){
		root = null;
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
	public Node search(Node root, int element){  // A recursive function to search a given key in BST
		//System.out.println("Searching for element "+ element);
		//System.out.println(root.data);
		try{
			if(root == null || root.data == element){
				System.out.println("The searched element "+ root.data +" is present inside the tree" );
				return root;
				}
			else{
				if(root.data > element){ // If element is less than root, recurse the left subtree
					return search(root.left, element);
				}
				else{
					return search(root.right, element); // else the element is greater than right subtree, so recurse the right subtree
		  	}
			
		}}
	catch(Exception e){
			System.out.println("The element " + element+ " is not present inside the tree");
			return root;
			
		}
	}
	
	public Node deleteNode(Node root, int element){
		//System.out.println("Deleting element "+ element);
		//System.out.println("Current element " +root.data);
		
	try{
		
		
		if(element < root.data){
			root.left = deleteNode(root.left, element); // recurse down the left subtree
		}
		else if(element > root.data){
			root.right = deleteNode(root.right, element); //recurse the right subtree
		}
		else{  // If element is the same as root element, then this is the element to be deleted
				
		// Case 1 - Node with only 1 child
			if(root.left == null){
					return root.right;
				}
				else if(root.right == null){
					return root.left;
				}
			
		// Case 2 -  Node with 2 children, Get the inorder successor
				root.data = minVaue(root.right);
				
				root.right = deleteNode(root.right, element);
		}
		return root;
	}
	catch(Exception e){
			System.out.println("The node "+ root.data +" is not present inside the tree");
			return root;
			
		}
	}

	public int minVaue(Node root) { // function to get the inorder successor
		int minvalue = root.data;
		while(root.left!= null){
			minvalue = root.left.data;
			root = root.left;
		}
		
		return minvalue;
	}

	public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.search(tree.root, 60);
        tree.search(tree.root, 45);
        tree.deleteNode(tree.root, 20); // deleting left leaf node
        System.out.println("The root element is " + tree.root.data );
        tree.deleteNode(tree.root, 40);
        tree.search(tree.root, 40);
        System.out.println("The root element is " + tree.root.data );
        tree.search(tree.root, 20);
        tree.deleteNode(tree.root, 80);  // deleting right leaf node
        tree.search(tree.root, 80);
        System.out.println("The root element is " + tree.root.data );
       
	}
}
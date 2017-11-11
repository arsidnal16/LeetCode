package trees;

public class MaxHeight {
	
	private static Node root;
	
	public int maxHeight(Node node){
		if(node == null){
			return 0;
		}
		else{
			int ldepth = maxHeight(node.left);
			int rdepth = maxHeight(node.right);
			
			if(ldepth > rdepth){
				return ldepth + 1;
			}
			else{
				return rdepth + 1;
			}
		}
		
	}
	
	public static void main(String[] args) {
		 
       MaxHeight tree = new MaxHeight();
       
 
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Height of tree is : " + tree.maxHeight(root));
         
 
    }

}
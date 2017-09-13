package Medium;

public class MaximumBinaryTree {
	
	// Definition for a binary tree node.
	   public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public TreeNode constructMaxBinaryTree(int nums[]) {
		return helper(nums, 0, nums.length-1);
	}

	private TreeNode helper(int[] nums, int left, int right) {
		
		if(left > right) {
			return null;
		}
		
		int max_index = left;
		
		for(int i =left ; i <= right ; i++) {
			if(nums[i] > nums[max_index])max_index = i; 
		}
		
		TreeNode root = new TreeNode(nums[max_index]);
        root.left = helper(nums, left, max_index - 1);
        root.right = helper(nums, max_index + 1, right);
        return root;
		
	}

}

package trees;

import java.util.ArrayList;
import java.util.List;

public class RangeInABST {
	
	public List<TreeNode> getRangeElements(TreeNode root, int start, int end){
		List<TreeNode> list = new ArrayList<TreeNode>();
		rangeElementHelper(root, list, start, end);
		return list;
	}

	private void rangeElementHelper(TreeNode root, List<TreeNode> list, int start, int end) {
		if(root == null) return;
		
		if(root.val < start) rangeElementHelper(root.right, list, start, end);
		if(root.val > end) rangeElementHelper(root.left, list, start, end);
		
		if(root.val > start && root.val < end) {
			
			rangeElementHelper(root.left, list, start, end);
			list.add(root);
			rangeElementHelper(root.right, list, start, end);
		}
		
	}

}

package trees;

import java.util.ArrayList;
import java.util.List;

public class KLargestElementsInBST {
	
	
	public List<TreeNode> KLargestElements(TreeNode root, int k){
		List<TreeNode> list = new ArrayList<TreeNode>();
		getKLargestElements(root, list, k);
		return list;
		
	}

	private void getKLargestElements(TreeNode root, List<TreeNode> list, int k) {
		getKLargestElements(root.right, list, k);
		if(root!=null && list.size() < k) {
			if(list.size() < k) {
				list.add(root);
				getKLargestElements(root.left, list, k);
			}
		}
		
	}

}

package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class MergeTwoBST {

	// Merging 2 BST to make 1 BST

	static Node root, root1, root2, current;
	static ArrayList<Integer> arr1 = new ArrayList<>();
	static ArrayList<Integer> arr2 = new ArrayList<>();

	public static Node insert(Node root, int element) { // A function to insert a new key in Binary search tree(BST)

		if (root == null) {
			root = new Node(element); // If the tree is empty return a new node
			System.out.println("The element inserted is " + root.data);
			return root;

		} else {
			if (element < root.data) {
				root.left = insert(root.left, element); // recurse the left subtree
			} else {
				root.right = insert(root.right, element); // recurse the right subrtree
			}
		}
		return root;

	}

	public static void inOrder(Node root, ArrayList<Integer> array1) {

		if (root == null) {
			return;
		}
		Stack<Node> s = new Stack<Node>();
		current = root;

		while (current != null) {
			s.push(current);
			current = current.left;
		}
		while (s.size() > 0) {
			current = s.pop();
			array1.add(current.data);
			// System.out.println(current.data+ " ");
			if (current.right != null) {
				current = current.right;
				while (current != null) {
					s.push(current);
					current = current.left;
				}
			}
		}

	}

	public static void main(String args[]) {

		MergeTwoBST tree1 = new MergeTwoBST();
		tree1.root1 = new Node(100);
		tree1.root1.left = new Node(50);
		tree1.root1.right = new Node(300);
		tree1.root1.left.left = new Node(20);
		tree1.root1.left.right = new Node(70);

		MergeTwoBST tree2 = new MergeTwoBST();
		tree2.root2 = new Node(80);
		tree2.root2.left = new Node(40);
		tree2.root2.right = new Node(120);

		MergeTwoBST tree = new MergeTwoBST();

		merge2BST(tree1, tree2, tree);

	}

	private static void merge2BST(MergeTwoBST tree1, MergeTwoBST tree2, MergeTwoBST tree) {
		inOrder(tree1.root1, arr1);
		inOrder(tree2.root2, arr2);

		int[] array1 = new int[arr1.size()];
		int[] array2 = new int[arr2.size()];

		// System.out.println(arr1);
		// System.out.println(arr2);

		Iterator<Integer> iterator = arr1.iterator();
		for (int i = 0; i < array1.length; i++) {
			array1[i] = iterator.next().intValue();
		}
		Iterator<Integer> iterator2 = arr2.iterator();
		for (int i = 0; i < array2.length; i++) {
			array2[i] = iterator2.next().intValue();
		}

		// System.out.println(Arrays.toString(array1));
		// System.out.println(Arrays.toString(array2));
		int[] arr = new int[arr1.size() + arr2.size()];
		mergeArrays(array1, array2, arr);

		for (int i = 0; i < arr.length; i++) {
			tree.insert(tree.root, arr[i]);
		}

	}

	private static void mergeArrays(int[] arr12, int[] arr22, int[] arr123) {
		int i = 0;
		int j = 0;
		int k = 0;
		int a = arr12.length;
		int b = arr22.length;

		while (i < a && j < b) {
			if (arr12[i] <= arr22[j]) {
				arr123[k] = arr12[i];
				i++;
			} else {
				arr123[k] = arr22[j];
				j++;
			}
			k++;
		}

		if (i < a) {

			arr123[k] = arr12[i];
			k++;
			i++;

		} else {

			arr123[k] = arr22[j];
			k++;
			j++;

		}

	}

}
public class TreeMaximumPath {
	static Node root;
	
	static int maxSum = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		TreeMaximumPath tree = new TreeMaximumPath();
		tree.root = tree.buildMockTree();
			
		tree.maxPath(root);
		System.out.println("Max Path is: " + maxSum);
	}
	
	int maxPath(Node node) {
		// Base case		
		if (node == null) {
			return 0;
		}
			
		if (node.left == null && node.right == null) {
			return node.value;
		}
		
		int leftSum = 0;
		int rightSum = 0;
		
		// Find the sum of the left subtree
		if (node.left != null) {
			leftSum = maxPath(node.left);
		}
		
		// Find the sum of the right subtree
		if (node.right != null) {
			rightSum = maxPath(node.right);
		}
		
		int maxWidth = Math.max(Math.max(leftSum, rightSum) + node.value, node.value);
		
		int trueMax = Math.max(maxWidth, leftSum + rightSum + node.value);
		
		maxSum = Math.max(maxSum, trueMax);
		
		return maxWidth; 
		
	}
	
	private Node buildMockTree() {
		Node root = new Node(10);
		
		root.left = new Node(3);
		root.left.left = new Node(20);
		root.left.right = new Node(1);
		root.right = new Node(10);
		root.right.right = new Node(-20);
		root.right.right.left = new Node(5);
		root.right.right.right = new Node(2);
		
		return root;
	}

	class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}
}

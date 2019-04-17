package Leetcode._51_100;

public class _100_SameTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return helper(p, q);
	}

	private boolean helper(TreeNode p, TreeNode q) {
		if (p == null && q != null)
			return false;
		if (p != null && q == null)
			return false;
		if (p == null && q == null)
			return true;
		if (p.val == q.val) {
			return helper(p.left, q.left) && helper(p.right, q.right);
		} else {
			return false;
		}
	}

}

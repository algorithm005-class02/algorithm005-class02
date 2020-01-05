package com.solution;

import java.util.ArrayList;
import java.util.List;

public class LargestValues515 {

	static TreeNode tn = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tn = new TreeNode(1);
		TreeNode tleft = new TreeNode(2);
		TreeNode tright = new TreeNode(3);
		tn.left = tleft;
		tn.right = tright;

		TreeNode tleft1 = new TreeNode(4);
		TreeNode tright1 = new TreeNode(5);
		tleft.left = tleft1;
		tleft.right = tright1;

		TreeNode tleft2 = new TreeNode(6);
		TreeNode tright2 = new TreeNode(7);
		tright.left = tleft2;
		tright.right = tright2;

		TreeNode tleft3 = new TreeNode(8);
		TreeNode tright3 = new TreeNode(9);
		tleft1.left = tleft3;
		tleft1.right = tright3;

		TreeNode tleft4 = new TreeNode(10);
		TreeNode tright4 = new TreeNode(11);
		tright1.left = tleft4;
		tright1.right = tright4;

		System.out.println(new LargestValues515().largestValues(tn));
	}

	public List<Integer> largestValues(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		helper(root, res, 0);
		return res;
	}

	public void helper(TreeNode root, ArrayList<Integer> res, int lever) {
		if (root == null) {
			return;
		}
		if (res.size() <= lever) {
			res.add(root.val);
		} else {
			int x = res.get(lever);
			if (x < root.val)
				res.set(lever, root.val);
		}
		helper(root.left, res, lever + 1);
		helper(root.right, res, lever + 1);

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}

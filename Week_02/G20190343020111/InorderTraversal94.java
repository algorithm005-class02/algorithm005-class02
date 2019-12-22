package com.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 给定一个二叉树，返回它的中序 遍历。
 */

public class InorderTraversal94 {

	static TreeNode tn=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tn=new TreeNode(null,null,null,1);
		TreeNode tleft=new TreeNode(tn,null,null,2);
		TreeNode tright=new TreeNode(tn,null,null,3);
		tn.left=tleft;
		tn.right=tright;
		
		TreeNode tleft1=new TreeNode(tleft,null,null,4);
		TreeNode tright1=new TreeNode(tleft,null,null,5);
		tleft.left=tleft1;
		tleft.right=tright1;
		
		TreeNode tleft2=new TreeNode(tright,null,null,6);
		TreeNode tright2=new TreeNode(tright,null,null,7);
		tright.left=tleft2;
		tright.right=tright2;
		
		TreeNode tleft3=new TreeNode(tleft1,null,null,8);
		TreeNode tright3=new TreeNode(tleft1,null,null,9);
		tleft1.left=tleft3;
		tleft1.right=tright3;
		
		TreeNode tleft4=new TreeNode(tright1,null,null,10);
		TreeNode tright4=new TreeNode(tright1,null,null,11);
		tright1.left=tleft4;
		tright1.right=tright4;
		
		System.out.println(inorderTraversal2(tn));
	}

	//方法1：递归实现
	public static List < Integer > inorderTraversal(TreeNode root) {
		
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }
	public static void helper(TreeNode root, List < Integer >res) {
		//terminator
		if (root!=null) {
			if (root.left != null) {
				helper(root.left,res);
			}
			res.add(root.v);
			if (root.right != null) {
				helper(root.right,res);
			}
		}
		//process current logic
		
		//drill down
		
		//restore current status
	}
	//方法2：stack实现
	public static List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.v);
            curr = curr.right;
        }
        return res;
    }
	
	static class TreeNode{
		TreeNode parent;  // red-black tree links
        TreeNode left;
        TreeNode right;
        int v; 
        public TreeNode(TreeNode parent,TreeNode left,TreeNode right,int v) {
        	this.parent=parent;
        	this.left=left;
        	this.right=right;
        	this.v=v;
        }
	}
}

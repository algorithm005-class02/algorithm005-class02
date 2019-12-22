package com.solution;

/*
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestor236 {

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
		new LowestCommonAncestor236().lowestCommonAncestor(tn, tright3, tright4);
		System.out.println(ans.v);
		
	}

	private static TreeNode ans;

    public LowestCommonAncestor236() {
        // Variable to store LCA node.
        ans = null;
    }

   
    //递归实现
    private boolean recurseTree2(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }
        
        int left =recurseTree2(currentNode.left, p, q)? 1:0;//找到返回1
        int right =recurseTree2(currentNode.right, p, q)? 1:0;//找到返回1
        int mid =(currentNode == p || currentNode ==q)? 1:0;//递归逻辑
        if (left +right +mid>=2) {
        	ans =currentNode;
        }
        return left+right+mid>0;
       
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree2(root, p, q);
        return ans;
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

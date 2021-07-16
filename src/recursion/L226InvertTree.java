package recursion;

import recursion.L104MaxDepth.TreeNode;

public class L226InvertTree {
	/*
	 * 226. 翻转二叉树
	 * 翻转一棵二叉树。
	 */
	class TreeNode 
	{
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) 
		 {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }
	}
	
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null)
		{
			return null;
		}
		
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}

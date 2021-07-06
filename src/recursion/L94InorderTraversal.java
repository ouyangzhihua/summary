package recursion;

import java.util.ArrayList;
import java.util.List;

public class L94InorderTraversal {
	/*
	 * 94. 二叉树的中序遍历
	 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历
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
	
	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> res = new ArrayList<>();
		recur(root, res);
		return res;
	}
	
	private void recur(TreeNode root, List<Integer> res)
	{
		if(root == null)
		{
			return;
		}
		
		recur(root.left, res);
		res.add(root.val);
		recur(root.right, res);
	}
}

package recursion;

import java.util.HashMap;
import java.util.Map;

public class L105RebuildTree {
	/*
	 * 105. 从前序与中序遍历序列构造二叉树
	 * 根据一棵树的前序遍历与中序遍历构造二叉树。注意:你可以假设树中没有重复的元素。
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
	
	Map<Integer, Integer> dic = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		for(int i = 0; i < inorder.length; i++)
		{
			dic.put(inorder[i], i);
		}
		return recur(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	private TreeNode recur(int[] preorder, int pl, int pr, int[] inorder, int il, int ir)
	{
		if(pl > pr)
		{
			return null;
		}
		int rv = preorder[pl];
		TreeNode root = new TreeNode(rv);
		int ri = dic.get(rv);
		int sl = ri - il;
		root.left = recur(preorder, pl+1, pl+sl, inorder, il, ri-1);
		root.right = recur(preorder, pl+sl+1, pr, inorder, ri+1, ir);
		return root;
	}
}

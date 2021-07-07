package breath_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102LevelOrder {
	/*
	 * 102. 二叉树的层序遍历
	 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
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
	
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> res = new ArrayList<>();		
		Queue<TreeNode> que = new LinkedList<>();
		if(root == null)
		{
			return res;
		}
		que.add(root);
		while(!que.isEmpty())
		{
			int n = que.size();
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < n; i++)		//此处不能用i < que.size()，因为在循环中在添加节点，size在变化
			{
				TreeNode node = que.poll();
				list.add(node.val);
				if(node.left != null)
				{
					que.add(node.left);
				}
				if(node.right != null)
				{
					que.add(node.right);
				}
			}
			res.add(list);
		}
		return res;
	}
}

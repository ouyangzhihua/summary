package recursion;

public class L101IsSymmetric {
	/*
	 * 101. 对称二叉树
	 * 给定一个二叉树，检查它是否是镜像对称的
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
	
	public boolean isSymmetric(TreeNode root)
	{
		if(root == null)
		{
			return true;
		}
		else
		{
			return recur(root.left, root.right);
		}
	}
	
	private boolean recur(TreeNode l, TreeNode r)
	{
		if(l == null && r == null)
		{
			return true;
		}
		else if(l == null || r == null || l.val != r.val)
		{
			return false;
		}
		else
		{
			return recur(l.left, r.right) && recur(l.right, r.left);
		}
	}
}

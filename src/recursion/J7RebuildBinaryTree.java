package recursion;

import java.util.Map;
import java.util.HashMap;

public class J7RebuildBinaryTree {
	/*
	 * 剑指 Offer 07. 重建二叉树
	 * 需求：输入某二叉树的前序遍历和中序遍历的结果，重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
	 * 
	 * 方法1：递归
	 * 思路：对于任何一棵树，前序遍历的形式总是[根节点 | 左子树 | 右子树]，
	 * 					中序遍历的形式总是[左子树 | 根节点 | 右子树]
	 * 根据前序遍历的第一个元素得到根节点，由于不含重复的数字，在中序遍历的找到根节点，则可以得到左子树和右子树。
	 * 分别将左子树和右子树看成一个全新的树，重复上述步骤，直到找到所有节点。
	 * 
	 * 1,明确当前root节点应该做什么：构建左右子树
	 * 2，根据函数定义递归调用子节点，做相同事
	 * 递归：
	 * 1，递归函数的定义（即这个函数是干嘛的）：根据当前root节点重建左右子树
	 * 2，递归函数参数的变量：前序遍历中序遍历存储节点数组的索引，不变量：存储数组
	 * 3，得到函数的递归结果后要做的事：建立左右子节点
	 * 4，base case也是递归结束条件：left>right
	 * 
	 * 优化：由于每次在递归时要在中序遍历数组中都要用一个for循环寻找根节点。因此可以用HashMap构造哈希映射来对根节点进行定位。
	 * */
	class TreeNode 
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//递归
	/*
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		//特例输入处理
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
			return null;
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	private TreeNode build(int[] pre, int[] in, int pl, int pr, int il, int ir)
	{
		//前序遍历位置
		//递归终止条件
		if(pl > pr)
		{
			return null;
		}
		int rootValue = pre[pl];
		TreeNode root = new TreeNode(rootValue);	//建立根节点
		int rootIndex = 0;
		for(int i = 0; i < in.length; i++)		//找到中序遍历中根节点位置
		{
			if(rootValue == in[i])
			{
				rootIndex = i;
				break;
			}
		}
		int sizeLeft = rootIndex - il;		//划分根节点、左子树、右子树
		
		root.left = build(pre, in, pl+1, pl+sizeLeft, il, rootIndex-1);		//左子树递归
		root.right = build(pre, in, pl+sizeLeft+1, pr, rootIndex+1, ir);	//右子树递归
		return root;
	}
	*/
	//哈希映射优化
	Map<Integer, Integer> indexMap;
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		//特例输入处理
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
			return null;
		indexMap = new HashMap<>();
		for(int i = 0; i < inorder.length; i++)
		{
			indexMap.put(inorder[i], i);
		}
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	private TreeNode build(int[] pre, int[] in, int pl, int pr, int il, int ir)
	{
		if(pl > pr)
		{
			return null;
		}
		int rootValue = pre[pl];
		TreeNode root = new TreeNode(rootValue);
		int rootIndex = indexMap.get(rootValue);
		int sizeLeft = rootIndex - il;
		root.left = build(pre, in, pl+1, pl+sizeLeft, il, rootIndex-1);
		root.right = build(pre, in, pl+sizeLeft+1, pr, rootIndex+1, ir);
		return root;
	}
}

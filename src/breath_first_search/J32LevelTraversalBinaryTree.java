package breath_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class J32LevelTraversalBinaryTree {
	class TreeNode 
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int[] levelOrder(TreeNode root)
	{
		/*
		 * 剑指 Offer 32 - I. 从上到下打印二叉树
		 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
		 * 
		 * 广度优先搜索
		 * 层序遍历实际就是利用广度优先搜索
		 * 代码框架：
		 * 计算从起点start到终点target的最近距离
		 * int bfs(Node start, Node target)
		 * {
		 * 		Queue<Node> que = new ...核心数据结构
		 * 		Set<Node> visited = new ...避免走回头路
		 * 
		 * 		que.offer(start);将起点加入队列
		 * 		visited.add(start);
		 * 		int step = 0;
		 * 
		 * 		while(!que.isEmpty())
		 * 		{
		 * 			for(int i = 0; i < que.size(); i++) 将当前队列中所有节点向四周扩散
		 * 			{
		 * 				Node cur = que.poll;
		 * 				if(cur is target) 判断是否到达终点
		 * 				{
		 * 					return step;
		 * 				}
		 * 				for(Node x : cur.adj()) 将cur的相邻节点都加入队列
		 * 				{
		 * 					if(x is not visited)
		 * 					{
		 * 						que.offer(x);
		 * 						visited.add(x);
		 * 					}
		 * 				}
		 * 				step++;
		 * 			}
		 * 		}
		 * }
		 * */
		if(root == null)
			return new int[0];
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty())
		{
			int n = que.size();
			for(int i = n; i > 0; i--)
			{
				TreeNode node = que.poll();
				res.add(node.val);
				if(node.left != null)
					que.offer(node.left);
				if(node.right != null)
					que.offer(node.right);
			}
		}
		int[] arr = new int[res.size()];
		for(int i = 0; i < res.size(); i++)
		{
			arr[i] = res.get(i);
		}
		return arr;
	}
	
	
	//-----------------------------------------------------------------------------------
	public List<List<Integer>> levelOrder2(TreeNode root) 
	{
		/*
		 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
		 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
		 * 
		 * 思路：
		 * 方法1：广度优先搜索
		 * 每一层打印一行可以通过广度优先搜索找到一层的所有节点。
		 * 广度优先搜索通常利用队列先进先出的特性实现
		 * 
		 * 步骤：
		 * 特例处理：root=null，返回空列表
		 * 初始化：
		 * BFS循环条件：
		 * 
		 * */	
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		if(root == null)
			que.offer(root);
		while(!que.isEmpty())
		{
			List<Integer> temp = new ArrayList<>();
			for(int i = que.size(); i > 0; i--)
			{
				TreeNode node = que.poll();
				temp.add(node.val);
				if(node.left != null)
					que.offer(node.left);
				if(node.right != null)
					que.offer(node.right);
			}
			res.add(temp);
		}
		return res;
	}
	
	
	//----------------------------------------------------------------------------------------
	public List<List<Integer>> levelOrder3(TreeNode root)
	{
		/*
		 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
		 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
		 * 第三行再按照从左到右的顺序打印，其他行以此类推。
		 * 
		 * 思路：
		 * 方法1：层序遍历+双端队列
		 * 
		 * 方法2：层序遍历 + 双端队列（奇偶层逻辑分离）
		 * 
		 * 方法3：层序遍历 + 倒序
		 * */
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		if(root != null)
			que.offer(root);
		while(!que.isEmpty())
		{
			LinkedList<Integer> temp = new LinkedList<>();
			for(int i = que.size(); i > 0; i--)
			{
				TreeNode node = que.poll();
				if((res.size() & 1) == 0)
					temp.addLast(node.val);
				else
					temp.addFirst(node.val);
				if(node.left != null)
					que.offer(node.left);
				if(node.right != null)
					que.offer(node.right);
			}
			res.add(temp);
		}
		return res;
		
		//方法2：层序遍历 + 双端队列（奇偶层逻辑分离）
		/*
		Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) deque.add(root);
        while(!deque.isEmpty()) 
        {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) 
            {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if(node.left != null) 
                	deque.addLast(node.left);
                if(node.right != null) 
                	deque.addLast(node.right);
            }
            res.add(tmp);
            if(deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) 
            {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if(node.right != null) 
                	deque.addFirst(node.right);
                if(node.left != null) 
                	deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
		*/
		
		//方法3：层序遍历 + 倒序
		/*
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) 
        {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) 
            {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) 
                	queue.add(node.left);
                if(node.right != null) 
                	queue.add(node.right);
            }
            if(res.size() % 2 == 1) 
            	Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
		*/
	}
}

package union_find;

import java.util.LinkedList;
import java.util.Queue;

public class L200N109NumberoOfIslands {
	/*
	 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
	 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
	 * 
	 * 1,回溯法（深度优先搜索DFS）
	 * 路径：已经做出的选择
	 * 选择列表：当前可以做的选择，上下左右
	 * 结束条件：到达决策树底层，无法在做选择。
	 * 算法框架
	 * res = [];
	 * backtrack(路径，选择列表）
	 * {
	 * 		if(满足结束条件)
	 * 		{
	 * 			res.add(路径)；
	 * 			return；
	 * 		}
	 * 
	 * 		for(选择 ： 选择列表)
	 * 		{
	 * 			做选择
	 * 			backtrack(路径，选择列表)
	 * 			撤销选择
	 * 		}
	 * }
	 * 
	 * backtrack()定义：遍历上下左右四个方向，找到所有连在一起的‘1’
	 * 
	 * 2，广度优先搜索BFS
	 * 代码框架：
	 * 计算起点start到终点target的最近距离
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
	 * 			for(int i = 0; i < que.size(); i++)	将当前队列中的所有节点向四周扩散
	 * 			{
	 * 				Node cur = que.poll();
	 * 				if(cur is target)	判断到达终点
	 * 				{
	 * 					return step;
	 * 				}
	 * 				for(Node x : cur.adj())
	 * 				{
	 * 					if(x not in isited)
	 * 					{
	 * 						que.offer(x);
	 * 						visited.add(x);
	 * 					}
	 * 				}
	 * 			}
	 * 			step++;
	 * 		}
	 * }
	 * 
	 * 3，并查集
	 * */
	public int numOfIsland(char[][] grid)
	{
		//方法1：回溯法（DFS）
		/*
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int res = 0;
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[0].length; col++)
			{
				if(grid[row][col] == '1')
				{
					res++;
					backtrack(grid, row, col);
				}
			}
		}		
		return res;
		*/
		//方法2：BFS
		/*
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int res = 0;
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[0].length; col++)
			{
				if(grid[row][col] == '1')
				{
					res++;
					bfs(grid, row, col);
				}
			}
		}		
		return res;
		*/
		
		//方法3：并查集
		class UnionFind
		{
			//连通分量个数
			private int count;
			//存储一棵树
			private int[] parent;
			//记录树的重量
			private int[] size;
			
			public UnionFind(char[][] grid)
			{
				int m = grid.length;
				int n = grid[0].length; 
				count = 0;
				parent = new int[n*m];
				size = new int[n*m];
				for(int i = 0; i < m; i++)
				{
					for(int j = 0; j < n; j++)
					{
						parent[i*n+j] = i*n+j;
						size[i*n+j] = 1;
						if(grid[i][j] == '1')
						{
							count++;
						}
					}
					
					
				}
			}
			
			public void union(int p, int q)
			{
				int rootp = find(p);
				int rootq = find(q);
				if(rootp == rootq)
				{
					return;
				}
				if(size[rootp] > size[rootq])
				{
					parent[rootq] = rootp;
					size[rootp] += size[rootq];
				}
				else
				{
					parent[rootp] = rootq;
					size[rootq] += size[rootp];
				}
				count--;
			}
			
			public boolean connected(int p, int q)
			{
				int rootp = find(p);
				int rootq = find(q);
				return rootp == rootq;
			}
			
			private int find(int x)
			{
				while(parent[x] != x)
				{
					//路径压缩
					parent[x] = parent[parent[x]];
					x = parent[x];
				}
				return x;
			}
		}
		
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		UnionFind uf = new UnionFind(grid);
		int[][] dir = {{1, 0}, {0, 1}};
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(grid[i][j] == '1')
				{
					for(int k = 0; k < 2; k++)
					{
						int row = i + dir[k][0];
						int col = j + dir[k][1];
						if(row >= m || col >= n)
						{
							continue;
						}
						if(grid[row][col] == '1')
						{
							uf.union(n*i+j, n*row+col);
						}
					}
				}
			}
		}
		return uf.count;
	}
	
	
	
	
	private void backtrack(char[][] grid, int row, int col)
	{
		if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
			return;
		
		grid[row][col] = '0';
		backtrack(grid, row-1, col);
		backtrack(grid, row+1, col);
		backtrack(grid, row, col-1);
		backtrack(grid, row, col+1);
	}
	
	private void bfs(char[][] grid, int row, int col)
	{
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {row, col});
		while(!que.isEmpty())
		{
			for(int i = 0; i < que.size(); i++)
			{
				int[] cur = que.poll();
				int crow = cur[0];
				int ccol = cur[1];
				if(crow >= 0 && ccol >= 0 && crow < grid.length && ccol < grid[0].length && grid[crow][ccol] == '1')
				{
					grid[crow][ccol] = 0;
					que.offer(new int[] {crow-1, ccol});
					que.offer(new int[] {crow+1, ccol});
					que.offer(new int[] {crow, ccol-1});
					que.offer(new int[] {crow, ccol+1});
				}
			}
		}
		
	}
}

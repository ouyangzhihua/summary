package depth_first_search;

public class N109NumberoOfIslands {
	/*
	 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
	 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
	 * 
	 * 1,回溯法
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
	 * */
	public int numOfIsland(char[][] grid)
	{
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
}

package depth_first_search;

public class L79WordExist {
	/*
	 * 79. 单词搜索
	 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
	 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
	 */
	public boolean exist(char[][] board, String word)
	{
		int m = board.length;
		int n = board[0].length;
		boolean[][] vis = new boolean[m][n];
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				boolean res = backtrack(board, word, vis, i, j, 0);
				if(res)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean backtrack(char[][] board, String word, boolean[][] vis, int i, int j, int k)
	{
		if(board[i][j] != word.charAt(k))
		{
			return false;
		}
		if(k == word.length()-1)
		{
			return true;
		}
		vis[i][j] = true;
		
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for(int c = 0; c < 4; c++)
		{
			int ni = i + dir[c][0];
			int nj = j + dir[c][1];
			if(ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length)
			{
				continue;
			}
			if(!vis[ni][nj])
			{
				boolean res = backtrack(board, word, vis, ni, nj, k+1);
				if(res)
				{
					return true;
				}
			}
			
		}
		vis[i][j] = false;
		return false;
	}
}

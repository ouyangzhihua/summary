package depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L51N39NQueens {
	/*
	 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
	 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。任何两个皇后都不能处于同一条横行、纵行或斜线上。
	 * 
	 * 1,回溯法
	 * 
	 * */
	public List<List<String>> solveNQueens(int n)
	{
		List<List<String>> res = new ArrayList<>();
		if(n < 1)
		{
			return res;
		}			
		char[][] board = new char[n][n];
		for(int i = 0; i < n; i++)
		{
			Arrays.fill(board[i], '.');
		}
		backtrack(0, n, board, res);
		return res;
	}
	
	private void backtrack(int row, int n, char[][] board, List<List<String>> res)
	{
		if(row == n)
		{
			List<String> temp = new ArrayList<>();
			for(int i = 0; i < n; i++)
			{
				temp.add(String.valueOf(board[i]));
			}
			res.add(temp);
			return;
		}
		
		for(int col = 0; col < n; col++)
		{
			if(!isValid(row, col, n, board))
			{
				continue;
			}
			board[row][col] = 'Q';
			backtrack(row+1, n, board, res);
			board[row][col] = '.';
		}
	}
	
	private boolean isValid(int row, int col, int n, char[][] board)
	{
		//检查同一列
		for(int i = 0; i < n; i++)
		{
			if(board[i][col] == 'Q')
			{
				return false;
			}
		}
		//检查右上方
		for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++)
		{
			if(board[i][j] == 'Q')
			{
				return false;
			}
		}
		//检查左上方
		for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
		{
			if(board[i][j] == 'Q')
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		L51N39NQueens f = new L51N39NQueens();
		while(in.hasNext())
		{
			int n = in.nextInt();
			List<List<String>> res = f.solveNQueens(n);
			System.out.println(res);
		}
		in.close();
	}
}

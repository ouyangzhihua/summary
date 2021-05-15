package depth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class L77NumberCombine {
	/*
	 * 77. 组合
	 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
	 * 
	 * 1,回溯法
	 * 
	 * */
	public List<List<Integer>> combine(int n, int k)
	{
		LinkedList<Integer> path = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(k < 1 || n < 1 || n < k)
		{
			return res;
		}
		backtrack(1, n, k, path, res);
		return res;
	}
	
	private void backtrack(int start, int n, int k, LinkedList<Integer> path, List<List<Integer>> res)
	{
		
		if(path.size() == k)
		{
			res.add(new LinkedList<Integer>(path));	//这里必须新建一个path一样得链表，若直接res.add(path),则path变化后res里面得内容也跟着变化
			return;
		}
		for(int i = start; i <= n; i++)
		{
			path.add(i);
			backtrack(i+1, n, k, path, res);
			path.removeLast();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		L77NumberCombine f = new L77NumberCombine();
		while(in.hasNext())
		{
			int n = in.nextInt();
			int k = in.nextInt();
			List<List<Integer>> res = f.combine(n, k);
			System.out.println(res);
		}
		in.close();
	}
}

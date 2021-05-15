package depth_first_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class L47N42NumberPermute2 {
	/*
	 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
	 * 
	 * 1,回溯法，
	 * */
	public List<List<Integer>> permuteUnique(int[] nums)
	{
		LinkedList<Integer> path = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		int k = nums.length;
		boolean[] vis = new boolean[k];
		Arrays.sort(nums);
		backtrack(k, nums, vis, path, res);
		return res;
	}
	private void backtrack(int k, int[] nums, boolean[] vis, LinkedList<Integer> path, List<List<Integer>> res)
	{
		if(path.size() == k)
		{
			res.add(new LinkedList<Integer>(path));
			return;
		}
		for(int i = 0; i < k; i++)
		{
			if(vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1]))
			{
				continue;
			}
			path.add(nums[i]);
			vis[i] = true;
			backtrack(k, nums, vis, path, res);
			vis[i] = false;
			path.removeLast();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		L47N42NumberPermute2 f = new L47N42NumberPermute2();
		while(in.hasNext())
		{
			int k = in.nextInt();
			int[] nums = new int[k];
			for(int i = 0; i < k; i++)
			{
				nums[i] = in.nextInt();
			}
			List<List<Integer>> res = f.permuteUnique(nums);
			System.out.println(res);
		}
		in.close();
	}
}

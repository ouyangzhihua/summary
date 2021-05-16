package depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L90Subsets2 {
	/*
	 * 90. 子集 II
	 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
	 * 
	 * 1,回溯法
	 * */
	public List<List<Integer>> subsetsWithDup(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		boolean[] vis = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack(0, nums, vis, path, res);
		return res;
	}
	
	private void backtrack(int start, int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> res)
	{		
		res.add(new ArrayList<Integer>(path));
		for(int i = start; i < nums.length; i++)
		{
			if(i > 0 && nums[i] == nums[i-1] && !vis[i-1])
			{
				continue;
			}
			path.add(nums[i]);
			vis[i] = true;
			backtrack(i+1, nums, vis, path, res);
			vis[i] = false;
			path.remove(path.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		L90Subsets2 f = new L90Subsets2();
		while(in.hasNext())
		{
			int n = in.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++)
			{
				nums[i] = in.nextInt();
			}
			List<List<Integer>> res = f.subsetsWithDup(nums);
			System.out.println(res);
		}
		in.close();

	}

}

package depth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class L46NumberPermute {
	/*
	 * 46. 全排列
	 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
	 * 
	 * 1,回溯法
	 * 
	 * */
	public List<List<Integer>> permute(int[] nums)
	{
		LinkedList<Integer> path = new LinkedList<>();
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		int k = nums.length;
		backtrack(k, nums, path, res);
		return res;
	}
	
	private void backtrack(int k, int[] nums, LinkedList<Integer> path, List<List<Integer>> res)
	{
		  if(path.size() == k)
		  {
			  res.add(new LinkedList<Integer>(path));
			  return;
		  }
		  for(int i = 0; i < k; i++)
		  {
			  if(path.contains(nums[i]))
			  {
				  continue;
			  }
			  path.add(nums[i]);
			  backtrack(k, nums, path, res);
			  path.removeLast();
		  }
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		L46NumberPermute f = new L46NumberPermute();
		List<Integer> list = new LinkedList<>();
		int k = 4;
		while(in.hasNext())
		{	
			list.add(in.nextInt());
			int[] nums = new int[k];
			for(int i = 0; i < k; i++)
			{
				nums[i] = list.get(i);
			}
			List<List<Integer>> res = f.permute(nums);
			System.out.println(res);				
		}		
		in.close();
	}
}

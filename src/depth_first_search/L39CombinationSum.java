package depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class L39CombinationSum {
	/*
	 * 39. 组合总和
	 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	 * candidates 中的数字可以无限制重复被选取。说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合。
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> combine = new ArrayList<Integer>();
		backtrack(candidates, target, combine, res, 0);
		return res;
	}
	
	private void backtrack(int[] candidates, int target, List<Integer> combine, List<List<Integer>> res, int index)
	{
		if(index == candidates.length)
		{
			return;
		}
		if(target == 0)
		{
			res.add(new ArrayList<Integer>(combine));
			return;
		}
		backtrack(candidates, target, combine, res, index+1);
		if(target - candidates[index] >= 0)
		{
			combine.add(candidates[index]);
			backtrack(candidates, target-candidates[index], combine, res, index);
			combine.remove(combine.size()-1);
		}
		
	}
}

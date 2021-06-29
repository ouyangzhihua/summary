package hash;

import java.util.HashMap;
import java.util.Map;

public class LH1SumOfTwoNumber {
	/*
	 * 1. 两数之和
	 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
	 */
	
	public int[] twoSum(int[] nums, int target)
	{
		//暴力
		/*
		int[] res = new int[2];
		int len = nums.length;
		int temp;
		for(int i = 0; i < len; i++)
		{
			temp = target - nums[i];
			for(int j = i+1; j < len; j++)
			{
				if(nums[j] == temp)
				{
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
		*/
		
		//哈希表
		int[] res = new int[2];
		int len = nums.length;
		Map<Integer, Integer> dic = new HashMap<>();
		for(int i = 0; i < len; i++)
		{
			if(dic.containsKey(target - nums[i]))
			{
				res[0] = i;
				res[1] = dic.get(target - nums[i]);
				return res;
			}
			dic.put(nums[i], i);
		}
		return res;
	}
}

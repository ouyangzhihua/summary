package double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15ThreeSum {
	/*
	 * 15. 三数之和
	 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
	 */
	
	public List<List<Integer>> threeSum(int[] nums)
	{
		//三重循环
		/*
		int len = nums.length;
		List<Integer> t = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(len < 3)
		{
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < len; i++)
		{
			if(i == 0 || nums[i] != nums[i-1])
			{
				for(int j = i+1; j < len; j++)
				{
					if(j == i+1 || nums[j] != nums[j-1])
					{
						for(int k = j+1; k < len; k++)
						{
							if(k == j+1 || nums[k] != nums[k-1])
							{
								if(nums[i]+nums[j]+nums[k] == 0)
								{
									t.add(nums[i]);
									t.add(nums[j]);
									t.add(nums[k]);
									res.add(new ArrayList<Integer>(t));							
									t.clear();
								}
							}							
						}
					}
					
				}
			}
			
		}
		return res;
		*/
		
		//双指针
		int len = nums.length;
		List<Integer> t = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(len < 3)
		{
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < len; i++)
		{
			if(i > 0 && nums[i] == nums[i-1])
			{
				continue;
			}
			int k = len-1;
			int target = -nums[i];
			for(int j = i+1; j < len; j++)
			{
				if(j > i+1 && nums[j] == nums[j-1])
				{
					continue;
				}
				while(j < k && nums[j] + nums[k] > target)
				{
					k--;
				}
				if(j == k)
				{
					break;
				}
				if(nums[j] + nums[k] == target)
				{
					t.add(nums[i]);
					t.add(nums[j]);
					t.add(nums[k]);
					res.add(new ArrayList<Integer>(t));							
					t.clear();
				}
			}
		}
		return res;
	}
}

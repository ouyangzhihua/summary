package binary_search;

public class L34SearchRange {
	/*
	 * 34. 在排序数组中查找元素的第一个和最后一个位置
	 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。如果数组中不存在目标值 target，返回 [-1, -1]。
	 * 进阶：你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
	 */
	public int[] searchRange(int[] nums, int target)
	{
		if(nums.length == 0)
		{
			return new int[]{-1,-1};
		}
		int l = 0, r = nums.length-1;
		while(l <= r)
		{
			int pivot = l + (r-l)/2;
			if(nums[pivot] == target)
			{
				int first = pivot, second = pivot;
				while(first > 0 && nums[first-1] == target)
				{					
					first--;			
				}
				while(second < nums.length-1 && nums[second+1] == target)
				{					
					second++;			
				}	
				return new int[] {first, second};
			}
			else if(nums[pivot] < target)
			{
				l = pivot + 1;
			}
			else
			{
				r = pivot - 1;
			}
		}
		return new int[]{-1,-1};
	}
}

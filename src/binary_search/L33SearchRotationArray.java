package binary_search;

public class L33SearchRotationArray {
	/*
	 * 33. 搜索旋转排序数组
	 */
	public int search(int[] nums, int target)
	{
		if(nums == null || nums.length == 0)
		{
			return -1;
		}
		if(nums.length == 1)
		{
			return target == nums[0] ? 0 : -1;
		}
		int l = 0, r = nums.length-1;
		while(l <= r)
		{
			int pivot = l + (r-l)/2;
			if(target == nums[pivot])
			{
				return pivot;
			}
			if(nums[pivot] >= nums[0])
			{
				if(target >= nums[0] && target < nums[pivot])
				{
					r = pivot - 1;
				}
				else
				{
					l = pivot + 1;
				}
			}
			else 
			{
				if(target < nums[0] && target > nums[pivot])
				{
					l = pivot + 1;
				}
				else
				{
					r = pivot - 1;
				}
			}
		}
		return -1;
	}
}

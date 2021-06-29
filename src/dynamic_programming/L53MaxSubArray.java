package dynamic_programming;

public class L53MaxSubArray {
	/*
	 * 53. 最大子序和
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 */
	public int maxSubArray(int[] nums)
	{
		if(nums.length == 1)
		{
			return nums[0];
		}
		int dp = nums[0];
		for(int i = 1; i < nums.length; i++)
		{
			nums[i] += Math.max(nums[i-1], 0);
			dp = Math.max(dp, nums[i]);
		}
		return dp;
	}
}

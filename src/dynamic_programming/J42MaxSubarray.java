package dynamic_programming;

public class J42MaxSubarray {
	public int maxSubArray(int[] nums)
	{
		/*
		 * 剑指 Offer 42. 连续子数组的最大和
		 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
		 * 
		 * 思路：
		 * 方法1：动态规划
		 * dp[i]记为以num[i]为结尾的和最大的子数组。
		 * dp[i]=dp[i-1]+num[i], 若dp[i-1]<=0,则说明dp[i-1]对dp[i]没有增大的贡献，此时dp[i]=num[i]
		 * 若dp[i-1]>0, 此时dp[i]=dp[i-1]+max(num[i],0)。
		 * 步骤：
		 * 特例处理：nums=null
		 * 
		 * 1,暴力穷举
		 * 要求最值，首先考虑动态规划。动态规划其实就是穷举加剪枝或备忘录.
		 * 2，动态规划
		 * 明确状态：子数组最后一个元素
		 * 定义dp数组：dp[i]表示以第i个元素结尾子数组和的最大值。
		 * 确定选择：增加第i+1个元素
		 * base case: 
		 * 状态转移：若dp[i-1]<=0,dp[i]=nums[i];
		 * 			若dp[i-1]>0,dp[i]=dp[i-1]+max(nums[i],0)
		 * */
		//第一步：暴力穷举
		//时间复杂度：O(N^2)，空间复杂度：O(1)
		/*
		if(nums == null || nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++)
		{
			int temp = 0;
			for(int j = i; j >= 0; j--)
			{
				temp += nums[j];
				if(temp > max)
					max = temp;
			}
		}
		return max;
		*/
		//第二步：动态规划
		if(nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 0; i < nums.length; i++)
		{
			
		}
		
	}
}

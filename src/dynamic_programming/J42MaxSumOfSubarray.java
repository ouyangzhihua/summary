package dynamic_programming;

import java.util.Scanner;


public class J42MaxSumOfSubarray {
	/*
	 * 剑指 Offer 42. 连续子数组的最大和
	 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
	 * 
	 * 思路：
	 * 方法1：动态规划
	 * 定义dp数组：dp[i]记为以num[i]为结尾的和最大的子数组。
	 * dp[i]=dp[i-1]+num[i], 若dp[i-1]<=0,则说明dp[i-1]对dp[i]没有增大的贡献，此时dp[i]=num[i]
	 * 若dp[i-1]>0, 此时dp[i]=dp[i-1]+max(num[i],0)。
	 *
	 * 步骤：
	 * 特例处理：nums=null
	 * */
	
	public int maxSubArray(int[] nums)
	{
		if(nums == null || nums.length == 0)
		{
			return 0;
		}
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = nums[0];
		for(int i = 1; i < len; i++)
		{
			nums[i] += Math.max(nums[i-1],0);
			dp[i] = Math.max(dp[i-1], nums[i]);
		}
		return dp[len-1];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		J42MaxSumOfSubarray f = new J42MaxSumOfSubarray();
		
		while(in.hasNext())
		{
			
			System.out.println(1);
		}
		in.close();
	}
}

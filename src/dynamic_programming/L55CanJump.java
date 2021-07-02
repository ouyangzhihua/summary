package dynamic_programming;

public class L55CanJump {
	/*
	 * 55. 跳跃游戏
	 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。
	 */
	public boolean canJump(int[] nums)
	{
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		int max = 0;
		if(nums[0] == 0 && nums.length == 1 )
		{
			return true;
		}
		
		for(int i = 0; i < nums.length; i++)
		{
			max = Math.max(nums[i], max);
			if(i > 0 && nums[i] <= max-i)
			{
				continue;
			}
			if(dp[i] == true)
			{
				for(int j = i; j <= i + nums[i]; j++)
				{
					if(j == nums.length)
	                {
	                    break;
	                }
					dp[j] = true;
				}
			}
			
		}
		return dp[nums.length-1];
	}
}

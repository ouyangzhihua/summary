package dynamic_programming;

public class L300LengthOfLIS {
	/*
	 * 300. 最长递增子序列
	 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
	 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
	 */
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 2)
        {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxlen = 1;
        for(int i = 1; i < nums.length; i++)
        {
            dp[i] = 1;
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }
}

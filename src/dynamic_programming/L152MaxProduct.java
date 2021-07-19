package dynamic_programming;

public class L152MaxProduct {
	/*
	 * 152. 乘积最大子数组
	 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
	 */
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        int dp = nums[0];
        int imax = 1, imin = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
            {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            dp = Math.max(dp, imax);
        }
        return dp;
    }
}

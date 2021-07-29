package depth_first_search;

public class L416CanPartition {
	/*
	 * 416. 分割等和子集
	 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
	 */
	
	//回溯
	/*
	boolean res = false;
    public boolean canPartition(int[] nums) {
       
        if(nums == null || nums.length == 0)
        {
            return true;
        }
        int sum = 0;
        for(int num : nums)
        {
            sum += num;
        }
        if(sum%2 == 1)
        {
            return false;
        }
        backtrack(nums, 0, sum/2);
        return res;
    }

    private void backtrack(int[] nums, int i, int target)
    {
        if(i == nums.length || target < 0)
        {
            return;
        }
        if(target == 0)
        {
            res = true;
            return;
        }
        target -= nums[i];
        backtrack(nums, i+1, target);
        target += nums[i];
        backtrack(nums, i+1, target);
    }
    */
	
	//记忆化搜索
	/*
	 boolean res = false;
	    public boolean canPartition(int[] nums) {
	       
	        if(nums == null || nums.length == 0)
	        {
	            return true;
	        }
	        int sum = 0;
	        for(int num : nums)
	        {
	            sum += num;
	        }
	        if(sum%2 == 1)
	        {
	            return false;
	        }
	        Boolean[][] memo = new Boolean[nums.length][sum/2+1];
	        res = backtrack(nums, 0, sum/2, memo);
	        return res;
	    }

	    private boolean backtrack(int[] nums, int i, int target, Boolean[][] memo)
	    {
	        if(i == nums.length || target < 0)
	        {
	            return false;
	        }       
	        if(target == 0)
	        {
	            return true;
	        }
	        if(memo[i][target] != null)
	        {
	            return memo[i][target];
	        }
	        return memo[i][target] = backtrack(nums, i+1, target-nums[i], memo) || backtrack(nums, i+1, target, memo);
	    }
	    */
	
	//动态规划
	 public boolean canPartition(int[] nums) {      
	        if(nums == null || nums.length == 0)
	        {
	            return true;
	        }
	        int sum = 0;
	        int max = 0;
	        for(int num : nums)
	        {
	            sum += num;
	            max = Math.max(max, num);
	        }
	        if(sum%2 == 1 || max > sum/2)
	        {
	            return false;
	        }
	        int target = sum/2;
	        int n = nums.length;
	        boolean[][] dp = new boolean[n][target+1];
	        for(int i = 0; i < n; i++)
	        {
	            dp[i][0] = true;
	        }
	        dp[0][nums[0]] = true;
	       for(int i = 1; i < n; i++)
	       {
	           for(int j = 1; j <= target; j++)
	           {
	               if(j >= nums[i])
	               {
	                   dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
	               }
	               else
	               {
	                   dp[i][j] = dp[i-1][j];
	               }
	           }
	       }
	        return dp[n-1][target];
	    }
}

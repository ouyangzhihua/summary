package depth_first_search;

public class L494FindTargetSumWays {
	/*
	 * 494. 目标和
	 * 给你一个整数数组 nums 和一个整数 target 。向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：例如，nums = [2, 1] ，
	 * 可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
	 */
	int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        backtrack(nums, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int i, int rest)
    {
        if(i == nums.length)
        {
            if(rest == 0)
            {
                res++;
            }
            return;
        }
        rest -= nums[i];
        backtrack(nums, i+1, rest);
        rest += nums[i];
        rest += nums[i];
        backtrack(nums, i+1, rest);
        rest -= nums[i];
    }
}

package double_pointer;

public class L287FindDuplicate {
	/*
	 * 287. 寻找重复数
	 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
	 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
	 */
	 public int findDuplicate(int[] nums) {
	        if(nums == null || nums.length == 0)
	        {
	            return -1;
	        }
	        int slow = 0, fast = 0;
	        do
	        {
	            fast = nums[fast];
	            fast = nums[fast];
	            slow = nums[slow];
	        }while(fast != slow);
	        fast = 0;
	        while(fast != slow)
	        {
	            fast = nums[fast];
	            slow = nums[slow];
	        }
	        return fast;
	    }
}

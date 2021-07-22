package array;

public class L238ProductExceptSelf {
	/*
	 * 238. 除自身以外数组的乘积
	 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
	 * 
	 * 思路：上三角，下三角
	 */
	public int[] productExceptSelf(int[] nums) {
        int p = 1, q = 1;
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++)
        {
            res[i] = p;
            p *= nums[i];
        }
        for(int i = len-1; i >= 0; i--)
        {
            res[i] *= q;
            q *= nums[i];
        }
        return res;
    }
}

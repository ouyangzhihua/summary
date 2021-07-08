package array;

public class L136SingleNumber {
	/*
	 * 136. 只出现一次的数字
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗
	 * 
	 * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a
	 * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0
	 * 异或运算满足交换律和结合律，a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
	 */
	public int singleNumber(int[] nums)
	{
		int res = 0;
		for(int i = 0; i < nums.length; i++)
		{
			res ^= nums[i];
		}
		return res;
	}
}

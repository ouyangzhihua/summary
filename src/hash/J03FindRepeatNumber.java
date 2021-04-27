package hash;
import java.util.Set;
import java.util.HashSet;

public class J03FindRepeatNumber {
	/*
	 * 剑指offer03：找出数组中重复的数字。
	 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
	 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
	 * 
	 * 思路：
	 * 方法1：暴力遍历
	 * 只要找到最新重复2次的数
	 * 步骤：遍历数组，每次都将数与前面的数比较是否相等
	 * 复杂度分析：空间复杂度O(1)，时间复杂度O(n^2)
	 * ----------------------------
	 * 
	 * 方法2：哈希集合
	 * 哈希法（散列）：通过特定数学函数或其他方法，将本身的键值转换成对应的数据存储地址
	 * 思路：遍历数组，将数据存入哈希集合，若不能存入则说明集合中已经存入该数，即找到重复的数
	 * 空间复杂度O(n)，时间复杂度O(n)
	 * -----------------------------
	 * 
	 * 方法3：原地置换
	 * 思路：数组长度为n,值在0～n-1 的范围内，若没有重复的数，则每个数都和自己的索引值相等。
	 * 将数组排序之后，值与索引值不等的就是重复数
	 * 步骤：遍历数组，若值nums[i]与索引值i不等，就当前值nums[i]置换到索引值为nums[i]的位置
	 * 复杂度分析：空间复杂度O(1)，时间复杂度O(n)
	 * 
	 * 
	 * 1，要在数组种找一个数首先考虑穷举，使用for循环暴力遍历
	 * 2,哈希集合优化
	 * 注意到暴力遍历时，每一个元素都需要一个for循环去查找前面是否有相同的数。用哈希集合可以进行时间复杂度O(1)的查找
	 * 3,考虑题目特殊条件，原地置换
	 * */

	public int findRepeatNumber(int[] nums)
	{
		//第一步：暴力遍历
		//时间复杂度O(N^2),空间复杂度O(1)
		/*
		if(nums == null || nums.length == 0)	//特例处理
			return -1;
		for(int i = 0; i < nums.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(nums[i] == nums[j])
					return nums[i];
			}
		}
		return -1;
		*/
		//第二步：哈希集合优化
		//时间复杂度O(N),空间复杂度O(N)
		if(nums == null || nums.length == 0)	//特例处理
			return -1;
		Set<Integer> dic = new HashSet<>();
		for(int i = 0; i < nums.length; i++)
		{
			if(dic.contains(nums[i]))
				return nums[i];
			dic.add(nums[i]);
		}
		return -1;
		
		
		
		/*
		 * 方法1：暴力遍历
		 * 
		int repeat = -1;
		OUT:
		while(nums !=null)
		{
			for(int i = 0; i < nums.length; i++)
			{
				for(int j = 0; j < i; j++)
				{
					if(nums[i] == nums[j])
					{
						repeat = nums[i];
						break OUT;
					}
				}
			}
			break;
		}
		return repeat;
		*/
		
		/*
		//方法2：哈希集合
		int repeat = -1;
		Set<Integer> set = new HashSet<Integer>();
		for(int num:nums)
		{
			if(!set.add(num))
			{
				repeat = num;
				break;
			}	
		}
		return repeat;
		*/
		
		//方法3：原地置换
		/*
		int repeat = -1;
		int temp;
		for(int i = 0; i < nums.length; i++)
		{
			while(nums[i] != i)
			{
				if(nums[i] == nums[nums[i]])
				{
					repeat = nums[i];
					break;
				}
				else
				{
					temp = nums[i];
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}
				
		}
		return repeat;
		*/
	}
}

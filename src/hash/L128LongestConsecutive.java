package hash;

import java.util.HashSet;
import java.util.Set;

public class L128LongestConsecutive {
	/*
	 * 128. 最长连续序列
	 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度
	 */
	public int longestConsecutive(int[] nums)
	{
		Set<Integer> dic = new HashSet<>();
		for(int num : nums)
		{
			dic.add(num);
		}
		int res = 0;
		for(int num : dic)
		{
			if(!dic.contains(num-1))
			{
				int fnum = num;
				int count = 1;
				while(dic.contains(fnum+1))
				{
					fnum += 1;
					count += 1;
				}
				res = Math.max(res, count);
			}			
		}
		return res;
	}
}

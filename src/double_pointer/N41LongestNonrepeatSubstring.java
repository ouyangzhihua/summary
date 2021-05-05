package double_pointer;

import java.util.Set;
import java.util.HashSet;

public class N41LongestNonrepeatSubstring {
	public int maxLength (int[] arr)
	{
		/*
		 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
		 * 
		 * 1,暴力遍历
		 * 遍历以arr[i]结尾的数字不重复的字串
		 * 2,前后指针
		 * */
		
		//第一步：暴力遍历
		//时间复杂度：O(N^2), 空间复杂度：O(N)
		/*
		if(arr == null || arr.length == 0)
			return 0;
		int res = 0;
		for(int i = 0; i < arr.length; i++)
		{
			Set<Integer> dic = new HashSet<>();
			int j = i;
			int count = 0;
			while(j >= 0 && dic.add(arr[j]))
			{
				count++;
				j--;
			}
			res = Math.max(res, count);
		}
		return res;
		*/
		//第二步：前后指针
		//时间复杂度：O(2N), 空间复杂度：O(N)
		if(arr == null || arr.length == 0)
			return 0;
		int res = 0;
		Set<Integer> dic = new HashSet<>();
		int former = 0, latter = 0;
		while(latter < arr.length)
		{
			if(dic.contains(arr[latter]))
			{
				while(arr[former] != arr[latter])
				{
					dic.remove(arr[former]);
					former++;
				}
				dic.remove(++former);
			}
			dic.add(arr[latter++]);
			res = Math.max(dic.size(), res);
		}
		return res;		
	}
}

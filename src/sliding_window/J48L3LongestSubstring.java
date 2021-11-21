package sliding_window;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class J48L3LongestSubstring {
	/*
	 * 1,滑动窗口
	 * 框架：
	 * void slidingwindow(String s, Sstring t)
	 * {
	 * 		Map<Character,Integer> need = new HashMap<>();
	 * 		Map<Character,Integer> window = new HashMap<>();
	 * 		for(char c:t)
	 * 			need[i++] = c;
	 * 		int left = 0, right = 0;
	 * 		int valid = 0;
	 * 		while(right < s.size())
	 * 		{
	 * 			//c是移入窗口的字符
	 * 			char c = s[right];
	 * 			//右移窗口
	 * 			right++;
	 * 			//进行窗口内一系列数据的更新
	 * 			...
	 * 
	 * 			//debug输出位置
	 * 			System.out.println("window:[d%,d%)\n",left,right);
	 * 			//
	 * 			//判断左侧窗口是否要收缩
	 * 			while(window needs shrink)
	 * 			{
	 * 				//d是将移除窗口的字符
	 * 				char d = s[left];
	 * 				//左移窗口
	 * 				left++;
	 * 				//进行窗口内数据的一系列更新
	 * 				...
	 * 			}
	 * 		}
	 * }	
	 * */
	
	public int lengthOfLongestSubstring(String s)
	{
		/*
		 * 剑指 Offer 48. 最长不含重复字符的子字符串
		 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
		 * 
		 * 方法1：动态规划+哈希表
		 * 状态定义：dp(j)记为以s[j]结尾的最长不重复字符串的长度
		 * 状态转移：固定右边界j，字符s[j]左边最近的相同字符为s[i]，s[i]=s[j]
		 * 1，当i<0，即s[j]左边没有与其相同的字符
		 * 2，当dp(j-1)<j-i，说明s[i]在子字符串dp(j-1)的区间之外，dp(j)=dp(j-1)+1
		 * 3，当dp(j-1)>=j-i，说明s[i]在子字符串dp(j-1)的区间之中，dp(j)=j-i
		 * 返回值：max(dp)
		 * 
		 * 用哈希表统计个字符最后一次出现的位置。
		 * 
		 * 步骤：
		 * 
		 * 方法2：动态规划+线性遍历
		 * 从j-1位置倒序查找s[j]左边最近的相同字符
		 * 
		 * 方法3：双指针+哈希表
		 * */
		/*
		if(s == null || s.length() <= 0)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		int dp = 0, res = 0;
		for(int j = 0; j < s.length(); j++)
		{
			char ch = s.charAt(j);
			int i = map.getOrDefault(ch, -1);	//获取索引
			map.put(ch, j);
			if(dp < j - i)
			{
				dp = dp + 1;
			}
			else
			{
				dp = j - i;
			}
			res = Math.max(dp, res);
		}
		return res;
		*/
		//方法2：动态规划+线性遍历
		/*
		if(s == null || s.length() <= 0)
			return 0;
		int dp = 0, res = 0;
		for(int j = 0; j < s.length(); j++)
		{
			char ch = s.charAt(j);
			int i = j - 1;
			while(i >= 0 && s.charAt(i) != ch)
			{
				i--;
			}
			if(dp < j - i)
			{
				dp = dp + 1;
			}
			else
			{
				dp = j - i;
			}
			res = Math.max(dp, res);
		}
		return res;
		*/
		//方法3：双指针+哈希表
		/*
		if(s == null || s.length() <= 0)
			return 0;
		int i = -1, res = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int j = 0; j < s.length(); j++)
		{
			char ch = s.charAt(j);
			if(map.containsKey(ch))
			{
				i = Math.max(i, map.get(ch));
			}
			map.put(ch, j);
			res = Math.max(res, j-i);
		}
		return res;
		*/
		//滑动窗口
		if(s == null || s.length() <= 0)
			return 0;
		int left = 0, right = 0;
		Map<Character, Integer> dic = new HashMap<>();
		int res = 0;
		while(right < s.length())
		{
			char c = s.charAt(right);
			dic.put(c, right);
			right++;
			
			while(right < s.length() && dic.containsKey(s.charAt(right)))
			{
				res = Math.max(res, right-left);
				System.out.println(res);
				
				char d = s.charAt(left);
				dic.remove(d);
				left++;
			}			
		}
		res = Math.max(res, right-left);
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		J48L3LongestSubstring f = new J48L3LongestSubstring();
		while(in.hasNext())
		{
			String s = in.next();
			int res = f.lengthOfLongestSubstring(s);
			System.out.println(res);
		}
		in.close();
	}
}

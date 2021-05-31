package dynamic_programming;

import java.util.Scanner;

public class L91NumberDecoding {
	/*
	 * 91. 解码方法
	 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 
	 * 'A' -> 1
	 * 'B' -> 2
	 * ...
	 * 'Z' -> 26
	 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
	 * "AAJF" ，将消息分组为 (1 1 10 6)
	 * "KJF" ，将消息分组为 (11 10 6)
	 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
	 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
	 * 题目数据保证答案肯定是一个 32 位 的整数。
	 * 
	 * 1,动态规划
	 * 明确状态：子字符串最后一个字符
	 * 定义dp数组：dp[i]表示以第i个字符结尾的字串有的翻译方法
	 * 明确选择：可以选择单个字符翻译 或者两个字符连着翻译
	 * 状态转移方程:dp[i] = dp[i-1]+dp[i-2]
	 * base case：dp[0] = 1; dp[1] = 2;
	 * 特例 “0”特殊处理
	 * */	
	public int numDecodings(String s)
	{
		/*
		if(s == null || s.charAt(0) == '0')
		{
			return 0;
		}
		int len = s.length();
		if(len == 1)
		{
			return 1;
		}
		int[] dp = new int[len];
		dp[0] = 1;
		dp[1] = 1;
		if(s.substring(0, 2).compareTo("10") >= 0 && s.substring(0, 2).compareTo("27") < 0)
		{
			if(s.charAt(1) == '0')
			{
				dp[1] = 1;
			}
			else
			{
				dp[1] = 2;
			}
		}
		else
		{
			if(s.charAt(1) == '0')
			{
				return 0;
			}
		}
		
		for(int i = 2; i < len; i++)
		{
			if(s.substring(i-1, i+1).compareTo("10") >= 0 && s.substring(i-1, i+1).compareTo("26") <= 0)
			{
				if(s.charAt(i) == '0')
				{
					dp[i] = dp[i-2];
				}
				else
				{
					dp[i] = dp[i-2] + dp[i-1];
				}
			}
			else if(s.substring(i-1, i+1).compareTo("26") > 0)
			{
				if(s.charAt(i) == '0')
				{
					return 0;
				}
				dp[i] = dp[i-1];
			}
			else
			{
				if(s.charAt(i) == '0')
				{
					return 0;
				}
				dp[i] = dp[i-1];
			}
		}
		return dp[len-1];
		*/
		
		//优化
		if(s == null || s.charAt(0) == '0')
		{
			return 0;
		}
		int dp1 = 1, dp2 = 1, dp = 0;
		for(int i = 1; i < s.length(); i++)
		{
			if(s.charAt(i) == '0')
			{
				if(s.charAt(i-1) == '0' || s.charAt(i-1)-'0' > 2)
				{
					return 0;
				}
				dp = dp2;
				dp2 = dp1;
				dp1 = dp;
			}
			else
			{
				if(s.charAt(i-1) == '0')
				{
					dp = dp1;
					dp2 = dp1;
					dp1 = dp;
				}
				else
				{
					if(s.substring(i-1, i+1).compareTo("26") <= 0)
					{
						dp = dp1 + dp2;
						dp2 = dp1;
						dp1 = dp;
					}
					else if(s.substring(i-1, i+1).compareTo("26") > 0)
					{
						dp = dp1;
						dp2 = dp1;
						dp1 = dp;
					}
				}				
			}
		}
		return dp;
	}
	
	public static void main(String[] ars)
	{
		Scanner in = new Scanner(System.in);
		L91NumberDecoding f = new L91NumberDecoding();
		while(in.hasNext())
		{
			String s = in.next();
			int res = f.numDecodings(s);
			System.out.println(res);
		}		
		in.close();
	}
}

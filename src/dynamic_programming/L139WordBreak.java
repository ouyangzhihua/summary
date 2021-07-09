package dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139WordBreak {
	/*
	 * 139. 单词拆分
	 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
	 */
	public boolean wordBreak(String s, List<String> wordDict)
	{
		Set<String> dic = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i = 1; i <= s.length(); i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(dp[j] && dic.contains(s.substring(j, i)))
				{
					dp[i] = true;
				}
			}
		}
		return dp[s.length()];
	}
	
}

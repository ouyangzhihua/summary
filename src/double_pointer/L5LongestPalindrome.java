package double_pointer;

public class L5LongestPalindrome {

	/*
	 * 5. 最长回文子串
	 * 给你一个字符串 s，找到 s 中最长的回文子串。
	 */
	public String longestPalindrome(String s)
	{
		String res = "";
		for(int i = 0; i < s.length(); i++)
		{
			// 找到以 s[i] 为中心的回文串
			String s1 = palindrome(s, i, i);
			// 找到以 s[i]和s[i+1] 为中心的回文串
			String s2 = palindrome(s, i, i+1);
			//res=longest(res,s1,s2)
			res = res.length()>s1.length() ? res : s1;
			res = res.length()>s2.length() ? res : s2;
		}
		return res;
	}
	
	private String palindrome(String s, int left, int right)
	{
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
		{
			//向两边展开
			left--;
			right++;
		}
		return s.substring(left+1, right);
	}
}

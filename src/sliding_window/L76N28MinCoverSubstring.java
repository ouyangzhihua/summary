package sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L76N28MinCoverSubstring {
	/*
	 * 76. 最小覆盖子串
	 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
	 * 
	 * 1,滑动窗口
	 * */
	public String minWindow(String s, String t)
	{
		if(s.length() < t.length())
		{
			return "";
		}
		Map<Character, Integer> need = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();
		for(int i = 0; i < t.length(); i++)
		{
			char temp = t.charAt(i);
			need.put(temp, need.getOrDefault(temp, 0)+1);
		}
		
		int left = 0, right = 0;
		int valid = 0;
		int start = 0, len = Integer.MAX_VALUE;
		char c, d;
		while(right < s.length())
		{
			c = s.charAt(right);
			right++;
			if(need.containsKey(c))
			{
				window.put(c, window.getOrDefault(c, 0)+1);
				if(window.get(c).equals(need.get(c)))
				{
					valid++;
					System.out.println(valid);
				}
			}
			
			//System.out.println(left+" "+ right);
			
			while(valid == need.size())
			{
				if(right - left < len)
				{
					start = left;
					len = right - left;
				}
				d = s.charAt(left);
				left++;
				if(need.containsKey(d))
				{
					if(window.get(d).equals(need.get(d)))
					{
						valid--;
					}
					window.put(d, window.getOrDefault(d, 0)-1);
				}
			}
		}
		return len == Integer.MAX_VALUE? "" : s.substring(start, start+len);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		L76N28MinCoverSubstring f = new L76N28MinCoverSubstring();
		while(in.hasNext())
		{
			String s = in.next();
			String t = in.next();
			String res = f.minWindow(s, t);
			System.out.println(res);
		}
		in.close();
	}
}

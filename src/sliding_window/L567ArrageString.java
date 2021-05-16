package sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L567ArrageString {
	/*
	 * 567. 字符串的排列
	 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
	 * 
	 * 
	 * */
	public boolean checkInclusion(String s1, String s2)
	{
		Map<Character, Integer> need = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();
		for(char i : s1.toCharArray())
		{
			need.put(i, need.getOrDefault(i, 0)+1);
		}
		
		int left = 0, right = 0;
		int valid = 0;
		char c, d;
		while(right < s2.length())
		{
			c = s2.charAt(right);
			right++;
			if(need.containsKey(c))
			{
				window.put(c, window.getOrDefault(c, 0)+1);
				if(window.get(c).equals(need.get(c)))
				{
					valid++;
				}
			}
			
			while(right - left >= s1.length())
			{
				if(valid == need.size())
				{
					return true;
				}
				d = s2.charAt(left);
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
		return false;
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		L567ArrageString f = new L567ArrageString();
		while(in.hasNext())
		{
			String s = in.next();
			String t = in.next();
			boolean res = f.checkInclusion(s, t);
			System.out.println(res);
		}
		in.close();
	}

}

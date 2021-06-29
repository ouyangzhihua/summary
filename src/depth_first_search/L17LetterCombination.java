package depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17LetterCombination {
	/*
	 * 17. 电话号码的字母组合
	 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
	 */
	
	public List<String> letterCombinations(String digits)
	{
		List<String> res = new ArrayList<>();
		if(digits.length() == 0)
		{
			return res;
		}
		Map<Character, String> dic = new HashMap<Character, String>() {{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}};
		backtrack(0, digits, new StringBuffer(),dic, res);
		return res;
	}
	
	private void backtrack(int index, String digits, StringBuffer s,Map<Character, String> dic, List<String> res)
	{
		if(index == digits.length())
		{
			res.add(s.toString());
		}
		else
		{
			char digit = digits.charAt(index);
			String letters = dic.get(digit);
			int lc = letters.length();
			for(int i = 0; i < lc; i++)
			{
				s.append(letters.charAt(i));
				backtrack(index+1, digits, s, dic, res);
				s.deleteCharAt(index);
			}
		}
	}
}

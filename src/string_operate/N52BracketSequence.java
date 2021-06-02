package string_operate;

import java.util.HashMap;
import java.util.Map;

public class N52BracketSequence {

	/*
	 * 括号序列
	 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列括号必须以正确的顺序关闭，
	 * "()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
	 */
	
	public boolean isValid (String s)
	{
		Map<Character, Integer> dic = new HashMap<>();
		char[] rb = {')', ']', '}'};
		char[] lb = {'(', '[', '{'};
		for(char c : s.toCharArray())
		{
			dic.put(c, dic.getOrDefault(c, 0)+1);
			if(rb.containsKey(c))
			{
				dic.get(c) % 2 == 1;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

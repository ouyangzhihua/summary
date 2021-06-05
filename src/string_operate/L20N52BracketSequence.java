package string_operate;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L20N52BracketSequence {

	/*
	 * 括号序列
	 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列括号必须以正确的顺序关闭，
	 * "()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
	 */
	
	public boolean isValid (String s)
	{
		Map<Character, Character> dic = new HashMap<>();
		dic.put('(', ')');
		dic.put('[', ']');
		dic.put('{', '}');
		dic.put('?', '?');
		Deque<Character> deq = new ArrayDeque<>();
		deq.add('?');
		if(s.length() > 0 && !dic.containsKey(s.charAt(0)))
		{
			return false;
		}
		for(char c : s.toCharArray())
		{
			if(dic.containsKey(c))
			{
				deq.add(c);
				System.out.println(deq);
			}
			else if(dic.get(deq.removeLast()) != c )
			{				
				return false;
			}
		}
		return deq.size() == 1;
			
	}	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		L20N52BracketSequence f = new L20N52BracketSequence();
		
		while(in.hasNext())
		{
			String s = in.next();
			boolean res = f.isValid(s);
			System.out.println(res);
		}
		in.close();
	}

}

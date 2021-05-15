package depth_first_search;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class L22N26GenerateParenthesis {
	/*
	 * 22. 括号生成
	 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
	 * 
	 * 1,回溯法
	 * 括号问题的两个性质：
	 * 一个「合法」括号组合的左括号数量一定等于右括号数量
	 * 对于一个「合法」的括号字符串组合p，必然对于任何0 <= i < len(p)都有：子串p[0..i]中左括号的数量都大于或等于右括号的数量。 
	 * 题意相当于有2n个位置，每个位置可以放“（”或“）”，所有组合中的合法组合
	 * */
	public List<String> generateParenthesis(int n)
	{
		StringBuilder str = new StringBuilder();	//路径
		List<String> res = new LinkedList<>();	//结果
		if(n <= 0)
			return null;
		backtrack(n, n, str, res);
		return res;
	}
	
	private void backtrack(int left, int right, StringBuilder str, List<String> res)
	{
		//终点判断、剪枝
		if(left > right)
			return;
		if(left < 0 || right < 0)
			return;
		if(left == 0 && right == 0)
		{
			String s = str.toString();
			res.add(s);
			return;
		}
		//做选择
		str.append('(');
		backtrack(left-1, right, str, res);	//递归
		//撤销选择
		str.deleteCharAt(str.length()-1);
		//做选择
		str.append(')');
		backtrack(left, right-1, str, res);	//递归
		//撤销选择
		str.deleteCharAt(str.length()-1);
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		L22N26GenerateParenthesis f = new L22N26GenerateParenthesis();
		while(in.hasNext())
		{
			int n = in.nextInt();
			List<String> res = f.generateParenthesis(n);
			System.out.println(res);
		}
		in.close();
	}
}

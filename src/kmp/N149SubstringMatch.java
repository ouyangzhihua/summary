package kmp;

import java.util.Scanner;


public class N149SubstringMatch {
	/*
	 * 给你一个非空模板串p，一个文本串T，问S在T中出现了多少次
	 */
	public int kmp (String p, String t)
	{
		int lenp = p.length();
		int lent = t.length();
		int count = 0;
		//dp[状态][字符] = 下个状态
		int[][] dp = new int[lenp][256];
		// base case
		dp[0][p.charAt(0)] = 1;
		// 影子状态 X 初始为 0
		int x = 0;
		// 构建状态转移图
		for(int i = 1; i < lenp; i++)
		{
			for(int j = 0; j < 256; j++)
			{
				if(p.charAt(i) == j)
				{
					dp[i][p.charAt(i)] = i+1;
				}
				else
				{
					dp[i][j] = dp[x][j];
				}				
			}
			// 更新影子状态
			x = dp[x][p.charAt(i)];			
		}
		
		
		// p 的初始态为 0
		int j = 0;
		for(int i = 0; i < lent; i++)
		{
			// 计算 p 的下一个状态
			System.out.println(j + " " + t.charAt(i));
			j = dp[j][t.charAt(i)];
			System.out.println(j);
			// 到达终止态，返回结果
			if(j == lenp)
			{
				count++;
				j = x;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N149SubstringMatch f = new N149SubstringMatch();
		
		while(in.hasNext())
		{
			String p = in.next();
			String t = in.next();
			
			int res = f.kmp(p, t);
			System.out.println(res);
		}
		in.close();
	}
}

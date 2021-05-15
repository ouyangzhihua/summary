package depth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class L93N20RestoreIpAddresses {
	/*
	 * 93. 复原 IP 地址
	 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
	 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
	 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
	 * 
	 * 1,回溯法
	 * 
	 * */
	public List<String> restoreIpAddresses(String s)
	{
		//int[] path = new int[4];
		LinkedList<String> path = new LinkedList<>();
		List<String> res = new LinkedList<>();
		if(s == null)
			return res;
		if(s.length() < 4 || s.length() > 12)
			return res;
		backtrack(4, 0, s, path, res);
		return res;
	}
	
	private void backtrack(int n, int start, String s, LinkedList<String> path, List<String> res)
	{
		if(n == 0)
		{
			if(start == s.length())
			{
				String str = path.get(0)+".";
                for(int i = 1; i < 4; i++)
                {
                    String temp = path.get(i);
                    str += temp;
                    if(i != 3)
                    {
                        str += ".";
                    }
                }
                res.add(str);
			}
			return;
		}
		
		if(start == s.length())
		{
			return;
		}
		for(int end = start; end < start+3; end++)
		{
			if (end >= s.length()) 
			{
                break;
            }

            if (n * 3 < s.length() - end) 
            {
                continue;
            }
            if(judgeIpSegment(s, start, end))
            {
            	String temp = s.substring(start, end+1);			
				path.add(temp);
				backtrack(n-1, end+1, s, path, res);
				path.removeLast();
            }						
		}
		
	}
	private boolean judgeIpSegment(String s, int start, int end) 
	{
        int len = end - start + 1;
        if (len > 1 && s.charAt(start) == '0') {
            return false;
        }

        int res = 0;
        while (start <= end) {
            res = res * 10 + s.charAt(start) - '0';
            start++;
        }

        return res >= 0 && res <= 255;
    }

	/*
	private void backtrack(int n, int start, String s, int[] path, List<String> res)
	{
		if(n == 4)
		{
			if(start == s.length())
			{
				StringBuilder str = new StringBuilder();
				for(int i = 0; i < 4; i++)
				{
					str.append(path[i]);
					if(i != 3)
					{
						str.append('.');
					}
				}
				res.add(str.toString());
			}
			return;
		}
		
		if(start == s.length())
		{
			return;
		}
		if(s.charAt(start) == '0')
		{
			path[n] = 0;
			backtrack(n+1, start+1, s, path, res);
		}
		for(int end = start; end < s.length(); end++)
		{
			int temp = Integer.valueOf(s.substring(start, end+1));
			if(temp >= 0 && temp <= 255)
			{
				path[n] = temp;
				backtrack(n+1, end+1, s, path, res);
			}
			else
			{
				break;
			}
		}
		
	}
	*/
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		L93N20RestoreIpAddresses f = new L93N20RestoreIpAddresses();
		while(in.hasNext())
		{
			String n = in.nextLine();
			List<String> res = f.restoreIpAddresses(n);
			System.out.println(res);
		}
		in.close();
	}
}

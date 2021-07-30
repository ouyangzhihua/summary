package dynamic_programming;

public class J46TranslateNum {
	public int translateNum(int num)
	{
		/*
		 * 剑指 Offer 46. 把数字翻译成字符串
		 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，
		 * 11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
		 * 
		 * 思路：
		 * 方法1：动态规划
		 * 翻译的方式有两种，1，单独数字翻译；2，两个数字连起来翻译
		 * 记第i个数字结尾的翻译方法有f(i),则f(i)=单独翻译f(i-1)+两个数字连起来翻译f(i-2)
		 * 
		 * 步骤：
		 * 特例处理：num<0;
		 * 将数转换为字符串
		 * */
		//方法1：动态规划
		/*
		if(num < 0)
        {
            return 0;
        } 
        String s = String.valueOf(num);
        if(s.length() == 1)
        {
            return 1;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        String pre = s.substring(0, 2);
        if(pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0)
        {
            dp[1] = 2;
        }
        else
        {
            dp[1] = 1;
        }
        for(int i = 2; i < n; i++)
        {
            pre = s.substring(i-1, i+1);
            if(pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0)
            {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else
            {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    	*/
		
		/*
		if(num < 0)
			return 0;
		String s = String.valueOf(num);
		int f1 = 0, f2 = 0, f = 1;
		for(int i = 0; i < s.length(); i++)
		{
			f2 = f1;
			f1 = f;
			f = 0;
			f += f1;
			if(i == 0)
				continue;
			String pre = s.substring(i-1, i+1);	//截取i-1~i
			if(pre.compareTo("25") <= 0 && pre.compareTo("10")>=0)
			{
				f += f2;
			}
		}
		return f;
		*/
		/*
		if(num < 0)
			return 0;
		String s = String.valueOf(num);
		int f1 = 1, f2 = 1, f = 1;
		for(int i = 1; i < s.length(); i++)
		{
			String pre = s.substring(i-1, i+1);
			if(pre.compareTo("25") <= 0 && pre.compareTo("10")>=0)
				f = f1 + f2;
			f2 = f1;
			f1 = f;
		}
		return f;
		*/
		//数字求余，使用字符串存储数字时仍会占用一定空间，利用取余将各数位求出来
		if(num < 0)
			return 0;
		int f1 = 1, f2 = 1, f = 1;
		int x = num % 10;
		int y;
		while(num != 0)
		{
			num /= 10;
			y = num % 10;
			int temp = y*10 + x;
			x = y;
			if(temp >=10 && temp <= 25)
				f = f1+f2;
			f2 = f1;
			f1 = f;
		}
		return f;
	}
}

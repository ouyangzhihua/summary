package string_operate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L06ZigzagTrans {
	/*
	 * 6. Z 字形变换
	 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
	 */
	public String convert(String s, int numRows)
	{
		/*
		if(s == null)
		{
			return null;
		}
		if(numRows == 1)
		{
			return s;
		}
		char[] sarr = s.toCharArray();
		int len = s.length();
		System.out.println(len);
		int g = len/(2*numRows-2);
		int yu = len%(2*numRows-2);
		int yuu = yu%numRows;
		char[][] dic = new char[numRows][g*(numRows-1)+1+yuu];
		StringBuilder res = new StringBuilder();
		int direct = 0;
		int i = 0;
		int row = 0, col = 0;
		while(i < len)
		{
			if(direct == 0)
			{
				dic[row][col] = sarr[i];
				row++;
				if(row == numRows)
				{
					direct = 1;
					row--;
					i++;
				}
			}
			if(direct == 1 && i < len)
			{
				dic[row-1][col+1] = sarr[i];
				row--;
				col++;
				if(row == 0)
				{
					direct = 0;
					row++;
				}
			}
			i++;
		}
		for(int m = 0; m < numRows; m++)
		{
			for(int n = 0; n < g*(numRows-1)+1+yuu; n++)
			{
				if(dic[m][n] != '\u0000')
				{
					res.append(dic[m][n]);
				}
			}
		}
		return res.toString();
		*/
		
		//优化
		if(numRows < 2)
		{
			return s;
		}
		List<StringBuilder> rows = new ArrayList<>();
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < numRows; i++)
		{
			rows.add(new StringBuilder());
		}
		int i = 0, flag = -1;
		for(char c : s.toCharArray())
		{
			rows.get(i).append(c);
			if(i == 0 || i == numRows-1)
			{
				flag = -flag;
			}
			i += flag;
		}
		for(StringBuilder strb : rows) 
		{
			res.append(strb);
		}
		return res.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		L06ZigzagTrans f = new L06ZigzagTrans();
		while(in.hasNext())
		{
			String s = in.next();
			int numRows = in.nextInt();
			String res = f.convert(s, numRows);
			System.out.println(res);

			
		}
		in.close();
	}

}

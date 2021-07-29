package bit_operate;

public class L338CountBits {
	/*
	 * 338. 比特位计数
	 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回
	 * 
	 * 思路：对于任意整数 x，令 x=x & (x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。因此，对 x 重复该操作，直到 x 变成 00，则操作次数即为 x 的「一比特数
	 */
	public int[] countBits(int n) {
        if(n < 0)
        {
            return new int[0];
        }
        int[] res = new int[n+1];
        for(int i = 0; i <= n; i++)
        {
            res[i] = countOnes(i);
        }
        return res;
    }

    private int countOnes(int i)
    {
        int count = 0;
        while(i != 0)
        {
            i = i & (i-1);
            count++;
        }
        return count;
    }
}

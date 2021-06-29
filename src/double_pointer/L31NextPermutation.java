package double_pointer;

import java.util.Scanner;

public class L31NextPermutation {
	/*
	 * 31. 下一个排列
	 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
	 * 必须 原地 修改，只允许使用额外常数空间。
	 */
	public void nextPermutation(int[] nums)
	{
		int l = nums.length - 2, r = nums.length - 1;
		while(l >= 0 && nums[l] >= nums[r])
		{
			l--;
			r--;
		}
		if(l >= 0)
		{
			r = nums.length - 1;
			while(nums[l] >= nums[r])
			{
				r--;
			}
			swap(l, r, nums);
		}		
		l = l+1;
		r = nums.length - 1;
		while(l < r)
		{			
			swap(l, r, nums);
			l++;
			r--;
		}
	}
	
	private void swap(int l, int r, int[] nums)
	{
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		L31NextPermutation f = new L31NextPermutation();
		while(in.hasNext())
		{
			int n = in.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++)
			{
				nums[i] = in.nextInt();
			}
			f.nextPermutation(nums);
			for(int i = 0; i < n; i++)
			{
				System.out.println(nums[i]);
			}
			
			
		}
	}
}

package sliding_window;

import java.util.Scanner;

public class L239MaxValueInWindow {
	/*
	 * 239. 滑动窗口最大值
	 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
	 * 
	 * 1,滑动窗口
	 * 2，优化
	 * */
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		//1,滑动窗口
		/*
		if(nums == null || nums.length == 0 || k < 1)
		{
			return new int[0];
		}
		int[] res = new int[nums.length-k+1];
		int left = 0, right = 0;
		int max = Integer.MIN_VALUE;
		int size = 0;
		int temp;
		while(right < nums.length)
		{
			temp = nums[right];
			right++;
			max = Math.max(temp, max);
			size++;
			
			while(size == k)
			{
				res[left] = max;
				
				temp = nums[left];
				left++;
				if(left < nums.length && temp == max)
				{
					max = nums[left];
					right = left;
					size = 0;
				}
				else
				{
					size--;
				}
			}
		}
		return res;
		*/
		if(nums == null || nums.length == 0 || k < 1)
		{
			return new int[0];
		}
		
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		L239MaxValueInWindow f = new L239MaxValueInWindow();
		while(in.hasNext())
		{
			int k = in.nextInt();
			int n = in.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++)
			{
				nums[i] = in.nextInt();
			}
			int[] res = f.maxSlidingWindow(nums, k);
			System.out.println(res);
		}
		in.close();

	}

}

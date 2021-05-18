package sliding_window;

import java.util.Comparator;
import java.util.PriorityQueue;
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
		int n = nums.length;
		//优先队列存放的是二元组(num,index) : 大顶堆（元素大小不同按元素大小排列，元素大小相同按下标进行排列）
        // num :   是为了比较元素大小
        // index : 是为了判断窗口的大小是否超出范围
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() 
	    {
	    	public int compare(int[] pair1, int[] pair2) 
	    	{
	    		return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
	        }
	     });
	     for(int i = 0; i < k; ++i) 
	     {
	         pq.offer(new int[]{nums[i], i});
	     }
	     int[] ans = new int[n - k + 1];
	     ans[0] = pq.peek()[0];
	     for(int i = k; i < n; ++i) 
	     {
	         pq.offer(new int[]{nums[i], i});
	         while(pq.peek()[1] <= i - k) 	// 将下标不在滑动窗口中的元素都干掉
	         {
	             pq.poll();					// 维护：堆的大小就是滑动窗口的大小
	         }
	         ans[i - k + 1] = pq.peek()[0];
	     }
	     return ans;
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

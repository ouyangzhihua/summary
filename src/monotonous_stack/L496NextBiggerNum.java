package monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class L496NextBiggerNum {
	/*
	 * 496. 下一个更大元素 I
	 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
	 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
	 * 
	 * 1,单调栈
	 * 
	 * */
	public int[] nextGreaterElement(int[] nums1, int[] nums2)
	{
		int len = nums1.length;
		int[] res = new int[len];
		Deque<Integer> stack = new ArrayDeque<>();
		//倒着往栈里放
		for(int i = nums1.length-1; i >= 0; i--)
		{
			while(!stack.isEmpty() && stack.peek() <= nums2[i])
			{
				stack.pop();
			}
			res[i] = stack.isEmpty()? -1 : stack.peek();
			stack.push(nums2[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

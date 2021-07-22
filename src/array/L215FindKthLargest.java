package array;

import java.util.Random;

public class L215FindKthLargest {
	/*
	 * 215. 数组中的第K个最大元素
	 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
	 */
	Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length)
        {
            return -1;
        }
        rqs(nums, 0, nums.length-1);
        return nums[k-1];
    }
    
    private void rqs(int[] nums, int l, int r)
    {
        if(l < r)
        {
            int pos = rp(nums, l, r);
            rqs(nums, l, pos-1);
            rqs(nums, pos+1, r);
        }
    }

    private int rp(int[] nums, int l, int r)
    {
        int i = rand.nextInt(r-l+1)+l;
        swap(nums, i, r);
        return part(nums, l, r);
    }

    private int part(int[] nums, int l, int r)
    {
        int pivot = nums[r];
        int i = l-1;
        for(int j = l; j < r; j++)
        {
            if(nums[j] >= pivot)
            {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

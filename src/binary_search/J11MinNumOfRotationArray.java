package binary_search;

public class J11MinNumOfRotationArray {
	/*
	 * 二分法查找：主要针对数据已经排好序。首先将数据分为两半，将目标值target与中间值nums[pivot]比较，pivot = low + (high-low)/2,
	 * 若比中间值小则在二分查找左边，否则查找右边。
	 * 
	 * 步骤：
	 * 1，判断输入矩阵是否空
	 * 2，初始化low=0, high=nums.length-1
	 * 3，循环：
	 * 条件：low <= high
	 * 执行：
	 * 中间值索引pivot = low + (high-low)/2
	 * 若target < nums[pivot], high = pivot - 1
	 * 若target > nums[pivot], low = pivot + 1
	 * 若target = nums[pivot],返回true
	 * 
	 * 
	 * */
	
	public int minArray(int[] nums) 
	{
		/*
		 * 剑指 Offer 11. 旋转数组的最小数字
		 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
		 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
		 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
		 * 
		 * 
		 * 1, 目标是找到数组中最小的数字，首先暴力遍历法。
		 * 2，二分查找优化
		 * for循环就是在连续的空间线性搜素，这就是二分查找可以发挥作用的标志。旋转数组也是一个有序数组，方便用二分查找
		 * 二分查找框架：
		 * int binarySearch(int[] nums, int tar)
		 * {
		 * 		int left = 0;
		 * 		int right = ...;
		 * 
		 * 		while(...)
		 * 		{
		 * 			int pivot = left + (right - left)/2;	用相减而不用相加是为了避免溢出
		 * 			if(nums[pivot] == tar) {return pivot;}
		 * 			else if(nums[pivot] > tar) {...}
		 * 			else if(nums[pivot] < tar) {...}
		 * 		}
		 * 		return -1;
		 */			
		//第一步：暴力搜索
		//时间复杂度O(N)，空间复杂度O(1)
		/*
		if(nums == null || nums.length == 0)	//特例处理
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] < min)
				min = nums[i];
		}
		return min;
		*/
		//第二步：二分查找优化
		//时间复杂度O(logN)，空间复杂度O(1)
		if(nums == null || nums.length == 0)	//特例处理
			return Integer.MAX_VALUE;
		int left = 0;
		int right = nums.length-1;
		while(left <= right)
		{
			int pivot = left + (right-left)/2;
			if(nums[pivot] > nums[right])
			{
				left = pivot+1;
			}
			else if(nums[pivot] < nums[right])
			{
				right = pivot;
			}
			else if(nums[pivot] == nums[right])
			{
				right--;
			}
		}
		return nums[left];
		
		
		/*
		if(nums == null || nums.length == 0)
			return 0;
		int low = 0;
		int high = nums.length - 1;
		while(low < high)
		{
			int pivot = low + (high - low)/2;	//防止出现溢出不用pivot = l(high + low)/2
			if(nums[pivot] < nums[high])
				high = pivot;
			else if(nums[pivot] > nums[high])
				low = pivot + 1;
			else
				high--;
		}
		return nums[low];
		*/
	}
}

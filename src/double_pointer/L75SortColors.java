package double_pointer;

public class L75SortColors {
	/*
	 * 75. 颜色分类
	 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
	 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
	 */
	public void sortColors(int[] nums)
	{
		int p0 = 0, p1 = 0;
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] == 1)
			{
				swap(i, p1, nums);
				p1++;
			}
			if(nums[i] == 0)
			{
				swap(i, p0, nums);
				if(p0 < p1)
				{
					swap(i, p1, nums);
				}
				p0++;
				p1++;
			}
		}
	}
	
	private void swap(int l, int r, int[] nums)
	{
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}

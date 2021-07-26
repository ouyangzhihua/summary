package array_sort;

public class MergeSort {
	/*
	 * 归并排序：
	 * 利用分治思想，对一个长为 n 的待排序的序列，我们将其分解成两个长度为n/2的子序列。每次先递归调用函数使两个子序列有序，然后我们再线性合并两个有序的子序列使整个序列有序。
	 */
	public int[] arraySort(int[] nums)
	{
		int[] temp = new int[nums.length];
        if(nums.length < 2)
        {
            return nums;
        }
        mergeSort(nums, 0, nums.length-1, temp);
        return nums;
	}
	
	private void mergeSort(int[] nums, int l, int r, int[] temp)
    {
        if(l >= r)
        {
            return;
        }
        int mid = l + (r-l)/2;
        mergeSort(nums, l, mid, temp);
        mergeSort(nums, mid+1, r, temp);
        int i = l, j = mid+1;
        int c = 0;
        while(i <= mid && j <= r)
        {
            if(nums[i] <= nums[j])
            {
                temp[c] = nums[i];
                c++;
                i++;
            }
            else
            {
                temp[c] = nums[j];
                c++;
                j++;
            }
        }
        while(i <= mid)
        {
            temp[c] = nums[i];
            c++;
            i++;
        }
        while(j <= r)
        {
            temp[c] = nums[j];
            c++;
            j++;
        }
        for(int k = 0; k < r-l+1; k++)
        {
            nums[k+l] = temp[k];
        }
    }
}

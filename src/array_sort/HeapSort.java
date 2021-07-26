package array_sort;

public class HeapSort {
	/*
	 * 堆排序：
	 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
	 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
	 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
	 */
	public int[] sortArray(int[] nums) {
        if(nums.length < 2)
        {
            return nums;
        }
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums)
    {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for(int i = len; i >= 1; i--)
        {
            swap(nums, i, 0);
            len--;
            maxHeapify(nums, 0, len);
        }
    }

    private void buildMaxHeap(int[] nums, int len)
    {
        for(int i = len/2; i >= 0; i--)
        {
            maxHeapify(nums, i, len);
        }
    }

    private void maxHeapify(int[] nums, int i, int len)
    {
        for(; i*2+1 <= len; )
        {
            int l = i*2+1;
            int r = i*2+2;
            int large;
            if(l <= len && nums[l] > nums[i])
            {
                large = l;
            }
            else
            {
                large = i;
            }
            if(r <= len && nums[r] > nums[large])
            {
                large = r;
            }
            if(large != i)
            {
                swap(nums, i, large);
                i = large;
            }
            else
            {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package double_pointer;

public class L283MoveZeroes {
	/*
	 * 283. 移动零
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
	 * 
	 * 思路：前后指针
	 */
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2)
        {
            return;
        }
        int formmer = 0, latter = 0;
        while(formmer < nums.length)
        {
            if(nums[formmer] != 0)
            {
                int temp = nums[latter];
                nums[latter] = nums[formmer];
                nums[formmer] = temp;
                latter++;
            }
            formmer++;
        }
    }
}

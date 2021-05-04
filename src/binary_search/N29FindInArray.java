package binary_search;

public class N29FindInArray {
	/*
	 * 请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：每一行的数字都从左到右排序,
	 * 每一行的第一个数字都比上一行最后一个数字大
	 * 
	 * 1,暴力遍历
	 * 在数组中查找目标值，一定可行却不高效的方法是暴力遍历。题目要求高效算法，并且数组算是有序
	 * 2，二分查找
	 * 观察到数组的特点，按每一行拼接起来就是一个一维的递增数组。故可以按一维数组二分法操作，只要在比较的时候把一维的索引转换到二维
	 * 即可
	 * */
	public boolean searchMatrix (int[][] matrix, int target)
	{
		//第一步：暴力遍历
		//时间复杂度：O(MN), 空间复杂度：O(1)
		/*
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				if(matrix[i][j] == target)
					return true;
			}
		}
		return false;
		*/
		//二分查找
		//时间复杂度：O(logMN), 空间复杂度：O(1)
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int n = rows * cols - 1;
		int left = 0;
		int right = n;
		while(left <= right)
		{
			int pivot = left + (right-left)/2;
			int row = pivot/cols;
			int col = pivot%cols;
			if(matrix[row][col] == target)
			{
				return true;
			}
			else if(target < matrix[row][col])
			{
				right = pivot - 1;
			}
			else if(target > matrix[row][col])
			{
				left = pivot + 1;
			}
		}
		return false;
	}
	
}

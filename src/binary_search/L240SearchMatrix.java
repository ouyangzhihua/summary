package binary_search;

public class L240SearchMatrix {
	/*
	 * 240. 搜索二维矩阵 II
	 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：每行的元素从左到右升序排列。每列的元素从上到下升序排列。
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while(i < rows && j >= 0)
        {
            if(matrix[i][j] == target)
            {
                return true;
            }
            else if(target < matrix[i][j])
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return false;
    }
}

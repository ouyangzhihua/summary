package array;

public class L48Rotate {
	/*
	 * 48. 旋转图像
	 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
	 * 请不要 使用另一个矩阵来旋转图像。
	 */
	public void rotate(int[][] matrix)
	{
		//使用了辅助数组
		/*
		int n = matrix.length;
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				arr[j][n-i-1] = matrix[i][j];
			}
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				matrix[i][j] = arr[i][j];
			}
		}
		*/
		
		//
		int n = matrix.length;	
		for(int i = 0; i < n/2; i++)
		{
			for(int j = 0; j < (n+1)/2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}
}

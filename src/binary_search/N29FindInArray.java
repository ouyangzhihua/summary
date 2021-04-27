package binary_search;

public class N29FindInArray {
	/*
	 * ��д��һ����Ч����m*n�������ж�Ŀ��ֵ�Ƿ���ڵ��㷨�������������������ÿһ�е����ֶ�����������,
	 * ÿһ�еĵ�һ�����ֶ�����һ�����һ�����ִ�
	 * 
	 * 1,��������
	 * �������в���Ŀ��ֵ��һ������ȴ����Ч�ķ����Ǳ�����������ĿҪ���Ч�㷨������������������
	 * 2�����ֲ���
	 * �۲쵽������ص㣬��ÿһ��ƴ����������һ��һά�ĵ������顣�ʿ��԰�һά������ַ�������ֻҪ�ڱȽϵ�ʱ���һά������ת������ά
	 * ����
	 * */
	public boolean searchMatrix (int[][] matrix, int target)
	{
		//��һ������������
		//ʱ�临�Ӷȣ�O(MN), �ռ临�Ӷȣ�O(1)
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
		//���ֲ���
		//ʱ�临�Ӷȣ�O(logMN), �ռ临�Ӷȣ�O(1)
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

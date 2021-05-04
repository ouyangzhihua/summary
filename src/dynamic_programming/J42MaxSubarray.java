package dynamic_programming;

public class J42MaxSubarray {
	public int maxSubArray(int[] nums)
	{
		/*
		 * ��ָ Offer 42. ���������������
		 * ����һ���������飬�����е�һ������������������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
		 * 
		 * ˼·��
		 * ����1����̬�滮
		 * dp[i]��Ϊ��num[i]Ϊ��β�ĺ����������顣
		 * dp[i]=dp[i-1]+num[i], ��dp[i-1]<=0,��˵��dp[i-1]��dp[i]û������Ĺ��ף���ʱdp[i]=num[i]
		 * ��dp[i-1]>0, ��ʱdp[i]=dp[i-1]+max(num[i],0)��
		 * ���裺
		 * ��������nums=null
		 * 
		 * 1,�������
		 * Ҫ����ֵ�����ȿ��Ƕ�̬�滮����̬�滮��ʵ������ټӼ�֦����¼.
		 * 2����̬�滮
		 * ��ȷ״̬�����������һ��Ԫ��
		 * ����dp���飺dp[i]��ʾ�Ե�i��Ԫ�ؽ�β������͵����ֵ��
		 * ȷ��ѡ�����ӵ�i+1��Ԫ��
		 * base case: 
		 * ״̬ת�ƣ���dp[i-1]<=0,dp[i]=nums[i];
		 * 			��dp[i-1]>0,dp[i]=dp[i-1]+max(nums[i],0)
		 * */
		//��һ�����������
		//ʱ�临�Ӷȣ�O(N^2)���ռ临�Ӷȣ�O(1)
		/*
		if(nums == null || nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++)
		{
			int temp = 0;
			for(int j = i; j >= 0; j--)
			{
				temp += nums[j];
				if(temp > max)
					max = temp;
			}
		}
		return max;
		*/
		//�ڶ�������̬�滮
		if(nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 0; i < nums.length; i++)
		{
			
		}
		
	}
}

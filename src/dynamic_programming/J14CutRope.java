package dynamic_programming;

public class J14CutRope {
	public int cuttingRope(int n)
	{
		/*
		 * ��ָ Offer 14- I. ������
		 * ����һ������Ϊ n �����ӣ�������Ӽ����������ȵ� m �Σ�m��n����������n>1����m>1����
		 * ÿ�����ӵĳ��ȼ�Ϊ k[0],k[1]...k[m-1] ������ k[0]*k[1]*...*k[m-1] ���ܵ����˻��Ƕ��٣�
		 * ���磬�����ӵĳ�����8ʱ�����ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ������˻���18��
		 * 
		 * ˼·��
		 * ����1����̬�滮
		 * ��f(n)Ϊ���ܵ����˻������Խ���ֽ�Ϊ������������
		 * ����������������Ž�������õ��������Ž⡣
		 * f(2)=1, f(3)=2, �ҿ�֤��2(n-2)>n, 3(n-3)>n, ��˽����Ӽ���ʣ��2��3���ɡ�
		 * ���裺
		 * ���Ӷȷ�����
		 * 
		 * ����2��̰���㷨
		 * ��n>=5ʱ����֤��2(n-2)>n, 3(n-3)>n���������ÿһ��ֻ�辡���������Ϊ3��2��
		 * 
		 * ----------------------------------------------------
		 * ��ȷ״̬�����ӵĳ��ȣ��������ٳ���
		 * ����dp���飺dp[i]��ʾ����Ϊi�����ӿɼ��ɵ����˻�
		 * ��ȷѡ�񣺳���Ϊi���Լ���1~i/2����
		 * base case: dp[2]=2;dp[3]=3; n<0,return -1; n=1,dp[1]=1;
		 * ״̬ת�ƣ�dp[i]=max(1*dp[i-1],2*dp[i-2],...)
		 * */
		//������١��ݹ�
		if(n <= 1)
			return -1;	//������
		if(n <= 3)
			return n-1;
		return cut(n);
		
		//����1����̬�滮
		/*
		if(n <= 1)
			return -1;	//������
		else if(n <= 3)	//f(2)=1, f(3)=2
			return n-1;
		int[] products = new int[n+1];	//
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		int max = 0;
		for(int i = 4; i <= n; i++)
		{
			max = 0;
			for(int j = 1; j <= i/2; j++)
			{
				int product = products[j] * products[i-j];
				if(product > max)
					max = product;	
			}
			products[i] = max;	//������Ϊiʱ�����ֵ�浽products[i]
		}
		return max;
		*/
		
		//����2��̰���㷨
		/*
		if(n <= 1)
			return -1;	//������
		else if(n <= 3)	//f(2)=1, f(3)=2
			return n-1;	
		else if(n == 4)	//�߽�ֵ�ж�
			return 4;
		long max;
		long times = n/3;
		if(n%3 == 1)
			max = (int) (Math.pow(3, times-1) * 4);
		else if(n%3 == 0)
			max = (int) (Math.pow(3, times));
		else
			max = (int) (Math.pow(3, times) * (n - 3 * times));
		return (int) max;
		*/
		
		
		//���Ǵ����������⣬��������
		/*
		if(n <= 1)
			return -1;	//������
		else if(n <= 3)	//f(2)=1, f(3)=2
			return n-1;	
		else if(n == 4)	//�߽�ֵ�ж�
			return 4;
		int max;
		long times = n/3;
		long x = 3;
		long rem =1;
		int p = 1000000007;
		for(long a = times-1; a > 0; a/=2)
		{
			if(a%2 == 1)
				rem = (rem * x) % p;
			x = (x * x) % p;
		}
		if(n%3 == 1)
			max = (int) (rem * 4 % p);
		else if(n%3 == 0)
			max = (int) (rem * 3 % p);
		else
			max = (int) (rem * 3 * 2 % p);
		return max;
		*/
	}
	private int cut(int n)
	{
		if(n <= 4)
			return n;
		int res = 1;
		for(int i = 4; i <= n; i++)
		{
			for(int j = 1; j <= i/2; j++)
			{
				res = Math.max(res, j*cut(i-j));
			}
		}
		return res;
	}
}

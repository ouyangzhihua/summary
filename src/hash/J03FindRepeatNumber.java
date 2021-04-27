package hash;
import java.util.Set;
import java.util.HashSet;

public class J03FindRepeatNumber {
	/*
	 * ��ָoffer03���ҳ��������ظ������֡�
	 * ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�
	 * ������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
	 * 
	 * ˼·��
	 * ����1����������
	 * ֻҪ�ҵ������ظ�2�ε���
	 * ���裺�������飬ÿ�ζ�������ǰ������Ƚ��Ƿ����
	 * ���Ӷȷ������ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(n^2)
	 * ----------------------------
	 * 
	 * ����2����ϣ����
	 * ��ϣ����ɢ�У���ͨ���ض���ѧ����������������������ļ�ֵת���ɶ�Ӧ�����ݴ洢��ַ
	 * ˼·���������飬�����ݴ����ϣ���ϣ������ܴ�����˵���������Ѿ�������������ҵ��ظ�����
	 * �ռ临�Ӷ�O(n)��ʱ�临�Ӷ�O(n)
	 * -----------------------------
	 * 
	 * ����3��ԭ���û�
	 * ˼·�����鳤��Ϊn,ֵ��0��n-1 �ķ�Χ�ڣ���û���ظ���������ÿ���������Լ�������ֵ��ȡ�
	 * ����������֮��ֵ������ֵ���ȵľ����ظ���
	 * ���裺�������飬��ֵnums[i]������ֵi���ȣ��͵�ǰֵnums[i]�û�������ֵΪnums[i]��λ��
	 * ���Ӷȷ������ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(n)
	 * 
	 * 
	 * 1��Ҫ����������һ�������ȿ�����٣�ʹ��forѭ����������
	 * 2,��ϣ�����Ż�
	 * ע�⵽��������ʱ��ÿһ��Ԫ�ض���Ҫһ��forѭ��ȥ����ǰ���Ƿ�����ͬ�������ù�ϣ���Ͽ��Խ���ʱ�临�Ӷ�O(1)�Ĳ���
	 * 3,������Ŀ����������ԭ���û�
	 * */

	public int findRepeatNumber(int[] nums)
	{
		//��һ������������
		//ʱ�临�Ӷ�O(N^2),�ռ临�Ӷ�O(1)
		/*
		if(nums == null || nums.length == 0)	//��������
			return -1;
		for(int i = 0; i < nums.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(nums[i] == nums[j])
					return nums[i];
			}
		}
		return -1;
		*/
		//�ڶ�������ϣ�����Ż�
		//ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(N)
		if(nums == null || nums.length == 0)	//��������
			return -1;
		Set<Integer> dic = new HashSet<>();
		for(int i = 0; i < nums.length; i++)
		{
			if(dic.contains(nums[i]))
				return nums[i];
			dic.add(nums[i]);
		}
		return -1;
		
		
		
		/*
		 * ����1����������
		 * 
		int repeat = -1;
		OUT:
		while(nums !=null)
		{
			for(int i = 0; i < nums.length; i++)
			{
				for(int j = 0; j < i; j++)
				{
					if(nums[i] == nums[j])
					{
						repeat = nums[i];
						break OUT;
					}
				}
			}
			break;
		}
		return repeat;
		*/
		
		/*
		//����2����ϣ����
		int repeat = -1;
		Set<Integer> set = new HashSet<Integer>();
		for(int num:nums)
		{
			if(!set.add(num))
			{
				repeat = num;
				break;
			}	
		}
		return repeat;
		*/
		
		//����3��ԭ���û�
		/*
		int repeat = -1;
		int temp;
		for(int i = 0; i < nums.length; i++)
		{
			while(nums[i] != i)
			{
				if(nums[i] == nums[nums[i]])
				{
					repeat = nums[i];
					break;
				}
				else
				{
					temp = nums[i];
					nums[i] = nums[temp];
					nums[temp] = temp;
				}
			}
				
		}
		return repeat;
		*/
	}
}

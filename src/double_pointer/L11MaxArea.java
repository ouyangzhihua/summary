package double_pointer;

public class L11MaxArea {

	/*
	 * 11. 盛最多水的容器
	 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
	 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 * 
	 */
	
	public int maxArea(int[] height)
	{
		/*
		if(height.length < 2)
		{
			return 0;
		}
		int left = 0, right = height.length-1;
		int area = Math.min(height[left], height[right]) * (right-left);
		int r = height.length-1, l = 0;
		while(left < right)
		{
			if(height[left] < height[right])	
			{
				left++;
				int temp = Math.min(height[left], height[right]) * (right-left);
				if(temp > area)
				{
					l = left;
					area = temp;
				}
			}
			if(height[left] >= height[right])	
			{
				right--;
				int temp = Math.min(height[left], height[right]) * (right-left);
				if(temp > area)
				{
					r = right;
					area = temp;
				}
			}
			
		}
		return area;
		*/
		//优化
		int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ? 
                Math.max(res, (j - i) * height[i++]): 
                Math.max(res, (j - i) * height[j--]); 
        }
        return res;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

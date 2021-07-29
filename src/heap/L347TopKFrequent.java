package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class L347TopKFrequent {
	/*
	 * 347. 前 K 个高频元素
	 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案
	 * 
	 * 思路：堆
	 */
	public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0)
        {
            return new int[0];
        }
        Map<Integer, Integer> dic = new HashMap<>();
        int[] res = new int[k];
        for(int i = 0; i < nums.length; i++)
        {
            dic.put(nums[i], dic.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>()
        {
            public int compare(int[] m, int[] n)
            {
                return m[1] - n [1];
            }
        });
        for(Map.Entry<Integer, Integer> entry : dic.entrySet())
        {
            int num = entry.getKey();
            int count = entry.getValue();
            if(que.size() == k)
            {
                if(que.peek()[1] < count)
                {
                    que.poll();
                    que.offer(new int[]{num, count});
                }
            }
            else
            {
                que.offer(new int[]{num, count});
            }
        }
        for(int i = 0; i < k; i++)
        {
            res[i] = que.poll()[0];
        }
        return res;
    }
}

package depth_first_search;

public class L698CanPartitionKSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		/*
        int n = nums.length;
        if(k > nums.length)
        {
            return false;
        }
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += nums[i];
        }
        if(sum%k == 1)
        {
            return false;
        }
        int target = sum/k;
        int[] bucket = new int[k];
        return dfs(nums, 0, bucket, target);
    }

    private boolean dfs(int[] nums, int index, int[] bucket, int target)
    {
        int n = nums.length;
        int k = bucket.length;
        if(index == n)
        {
            for(int i = 0; i < k; i++)
            {
                if(bucket[i] != target)
                {
                    return false;
                }
            }
            return true;
        }
        for(int i = 0; i < k; i++)
        {
            if(bucket[i] + nums[index] > target)
            {
                continue;
            }
            bucket[i] += nums[index];
            if(dfs(nums, index+1, bucket, target))
            {
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }
    */
		
		int n = nums.length;
        if(k > nums.length)
        {
            return false;
        }
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += nums[i];
        }
        if(sum%k == 1)
        {
            return false;
        }
        int target = sum/k;
        boolean[] used = new boolean[n];
        return dfs(k, 0, nums, 0, used, target);
    }

    private boolean dfs(int k, int bucket, int[] nums, int start, boolean[] used, int target)
    {
        int n = nums.length;
        if(k == 0)
        {
            return true;
        }
        if(bucket == target)
        {
            return dfs(k-1, 0, nums, 0, used, target);
        }
        for(int i = start; i < n; i++)
        {
            if(used[i])
            {
                continue;
            }
            if(bucket + nums[i] > target)
            {
                continue;
            }
            used[i] = true;
            bucket += nums[i];
            if(dfs(k, bucket, nums, i+1, used, target))
            {               
                return true;
            }
            used[i] = false;
            bucket -= nums[i];
            
        }
        return false;
    }
}

package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JII079Subsets {
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, 0, path);
        return res;
    }

    private void dfs(int[] nums, int start, LinkedList<Integer> path)
    {
        res.add(new LinkedList<Integer>(path));
        int n = nums.length;
        for(int i = start; i < n; i++)
        {
            path.add(nums[i]);
            dfs(nums, i+1, path);
            path.removeLast();
        }
    }
}

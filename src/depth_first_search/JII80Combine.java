package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JII80Combine {
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path);
        return res;
    }

    private void dfs(int n, int k, int start, LinkedList<Integer> path)
    {
        if(path.size() == k)
        {
            res.add(new LinkedList<Integer>(path));
            return;
        }
        for(int i = start; i <= n; i++)
        {
            path.add(i);
            dfs(n, k, i+1, path);
            path.removeLast();
        }
    }
}

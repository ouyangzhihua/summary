package depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class L207CanFinish {
	/*
	 * 207. 课程表
	 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。在选修某些课程之前需要一些先修课程。 
	 * 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
	 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
	 * 
	 *  思路：有向无环图， 邻接表
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {       
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] flag = new int[numCourses];
        for(int[] cour : prerequisites)
        {
            adj.get(cour[1]).add(cour[0]);
        } 
        for(int i = 0; i < numCourses; i++)
        {
            if(!dfs(adj, flag, i))
            {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] flag, int i)
    {
        if(flag[i] == 1)
        {
            return false;
        }
        if(flag[i] == -1)
        {
            return true;
        }
        flag[i] = 1;
        for(Integer j : adj.get(i))
        {
            if(!dfs(adj, flag, j))
            {
                return false;
            }
        }
        flag[i] = -1;
        return true;
    }
}

package breath_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class L111MinDepth {
	class TreeNode 
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 1;

        while(!que.isEmpty())
        {
            int sz = que.size();
            for(int i = 0; i < sz; i++)
            {
                TreeNode cur = que.poll();
                if(cur.left == null && cur.right == null)
                {
                    return depth;
                }
                if(cur.left != null)
                {
                    que.offer(cur.left);
                }
                if(cur.right != null)
                {
                    que.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}

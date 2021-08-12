package breath_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L752OpenLock {
	public int openLock(String[] deadends, String target) {
        Queue<String> que = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for(String s : deadends)
        {
            dead.add(s);
        }
        que.add("0000");
        vis.add("0000");
        int step = 0;
        while(!que.isEmpty())
        {
            int sz = que.size();
            for(int i = 0; i < sz; i++)
            {
                String cur = que.poll();
                if(cur.equals(target))
                {
                    return step;
                }
                if(dead.contains(cur))
                {
                    continue;
                }
                
                for(int j = 0; j < 4; j++)
                {
                    String up = plusone(cur, j);
                    if(!vis.contains(up))
                    {
                        que.add(up);
                        vis.add(up);
                    }
                    String dowm = minone(cur, j);
                    if(!vis.contains(dowm))
                    {
                        que.add(dowm);
                        vis.add(dowm);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusone(String s, int j)
    {
        char[] ch = s.toCharArray();
        if(ch[j] == '9')
        {
            ch[j] = '0';
        }
        else
        {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minone(String s, int j)
    {
        char[] ch = s.toCharArray();
        if(ch[j] == '0')
        {
            ch[j] = '9';
        }
        else
        {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}

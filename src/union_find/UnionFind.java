package union_find;

public class UnionFind {
	/*
	 * 并查集算法，主要解决图论中动态连通性问题
	 * 
	 * */
	//连通分量个数
	private int count;
	//存储一棵树
	private int[] parent;
	//记录树的重量
	private int[] size;
	public UnionFind(int n)
	{
		this.count = n;
		parent = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++)
		{
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	public void union(int p, int q)
	{
		int rootp = find(p);
		int rootq = find(q);
		if(rootp == rootq)
		{
			return;
		}
		
		if(size[rootp] > size[rootq])
		{
			parent[rootq] = rootp;
			size[rootp] += size[rootq];
		}
		else
		{
			parent[rootp] = rootq;
			size[rootq] += size[rootp];
		}
		count--;
	}
	
	public boolean connnected(int p, int q)
	{
		int rootp = find(p);
		int rootq = find(q);
		return rootp == rootq;
	}
	
	private int find(int x)
	{
		while(parent[x] != x)
		{
			//进行路径压缩
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
}

package recursion;

import java.util.Map;
import java.util.HashMap;

public class J07RebuildTree {
	/*
	 * ��ָ Offer 07. �ؽ�������
	 * ��������ĳ��������ǰ���������������Ľ�����ؽ��ö����������������ǰ���������������Ľ���ж������ظ������֡� 
	 * 
	 * ����1���ݹ�
	 * ˼·�������κ�һ������ǰ���������ʽ����[���ڵ� | ������ | ������]��
	 * 					�����������ʽ����[������ | ���ڵ� | ������]
	 * ����ǰ������ĵ�һ��Ԫ�صõ����ڵ㣬���ڲ����ظ������֣�������������ҵ����ڵ㣬����Եõ�����������������
	 * �ֱ�������������������һ��ȫ�µ������ظ��������裬ֱ���ҵ����нڵ㡣
	 * 
	 * 1,��ȷ��ǰroot�ڵ�Ӧ����ʲô��������������
	 * 2�����ݺ�������ݹ�����ӽڵ㣬����ͬ��
	 * �ݹ飺
	 * 1���ݹ麯���Ķ��壨����������Ǹ���ģ������ݵ�ǰroot�ڵ��ؽ���������
	 * 2���ݹ麯�������ı�����ǰ�������������洢�ڵ���������������������洢����
	 * 3���õ������ĵݹ�����Ҫ�����£����������ӽڵ�
	 * 4��base caseҲ�ǵݹ����������left>right
	 * 
	 * �Ż�������ÿ���ڵݹ�ʱҪ��������������ж�Ҫ��һ��forѭ��Ѱ�Ҹ��ڵ㡣��˿�����HashMap�����ϣӳ�����Ը��ڵ���ж�λ��
	 * */
	class TreeNode 
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//�ݹ�
	/*
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		//�������봦��
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
			return null;
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	private TreeNode build(int[] pre, int[] in, int pl, int pr, int il, int ir)
	{
		//ǰ�����λ��
		//�ݹ���ֹ����
		if(pl > pr)
		{
			return null;
		}
		int rootValue = pre[pl];
		TreeNode root = new TreeNode(rootValue);	//�������ڵ�
		int rootIndex = 0;
		for(int i = 0; i < in.length; i++)		//�ҵ���������и��ڵ�λ��
		{
			if(rootValue == in[i])
			{
				rootIndex = i;
				break;
			}
		}
		int sizeLeft = rootIndex - il;		//���ָ��ڵ㡢��������������
		
		root.left = build(pre, in, pl+1, pl+sizeLeft, il, rootIndex-1);		//�������ݹ�
		root.right = build(pre, in, pl+sizeLeft+1, pr, rootIndex+1, ir);	//�������ݹ�
		return root;
	}
	*/
	//��ϣӳ���Ż�
	Map<Integer, Integer> indexMap;
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		//�������봦��
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
			return null;
		indexMap = new HashMap<>();
		for(int i = 0; i < inorder.length; i++)
		{
			indexMap.put(inorder[i], i);
		}
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
	}
	private TreeNode build(int[] pre, int[] in, int pl, int pr, int il, int ir)
	{
		if(pl > pr)
		{
			return null;
		}
		int rootValue = pre[pl];
		TreeNode root = new TreeNode(rootValue);
		int rootIndex = indexMap.get(rootValue);
		int sizeLeft = rootIndex - il;
		root.left = build(pre, in, pl+1, pl+sizeLeft, il, rootIndex-1);
		root.right = build(pre, in, pl+sizeLeft+1, pr, rootIndex+1, ir);
		return root;
	}
}

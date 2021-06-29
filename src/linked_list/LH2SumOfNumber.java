package linked_list;

import java.util.Scanner;

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LH2SumOfNumber {
	/*
	 * 2. 两数相加
	 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
	 * 请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 */
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		//先加在取余，存在大数问题
		/*
		ListNode res = null;
		ListNode l = res;
		ListNode node1 = l1;
		ListNode node2 = l2;
		long temp1 = 0, temp2=0;
		long w1 = 1, w2=1;
		while(node1 != null)
		{
			temp1 += node1.val * w1;
			node1 = node1.next;
			w1 *= 10;
		}
		while(node2 != null)
		{
			temp2 += node2.val * w2;
			node2 = node2.next;
			w2 *= 10;
		}
		long sum = temp1 + temp2;
		System.out.println(sum + " " + temp1 + " " + temp2);
		if(sum == 0)
		{
			l = new ListNode(0);
			res = l;
		}
		while(sum != 0)
		{
			long temp = sum%10;
			sum = sum/10;
			System.out.println(temp);
			if(res == null)
			{
				l = new ListNode((int)temp);
				res = l;
			}
			else
			{
				l.next = new ListNode((int)temp);
				l = l.next;
			}
						
		}
		return res;
		*/
		
		//模拟
		ListNode head = null;
		ListNode l = head;
		ListNode node1 = l1;
		ListNode node2 = l2;
		int carry = 0;
		while(node1 != null || node2 != null)
		{
			int temp1 = node1 != null? node1.val : 0;
			int temp2 = node2 != null? node2.val : 0;
			int sum = temp1 + temp2 + carry;
			if(head == null)
			{
				l = new ListNode(sum%10);
				head = l;
			}
			else
			{
				l.next = new ListNode(sum%10);
				l = l.next;
			}
			carry = sum/10;
			if(node1 != null)
			{
				node1 = node1.next;
			}
			if(node2 != null)
			{
				node2 = node2.next;
			}			
		}
		if(carry > 0)
		{
			l.next = new ListNode(carry);
		}
		return head;
	}
	
	public static void main(String[] ars)
	{
		Scanner sc = new Scanner(System.in);
		LH2SumOfNumber f = new LH2SumOfNumber();
		int n, m;
		while(sc.hasNext())
		{
			n = sc.nextInt();
			m = sc.nextInt();
			ListNode l1 = null, l2 =null, node = l1 ;
			for(int i = 0; i < n; i++)
			{
				if(l1 == null)
				{
					node = new ListNode(sc.nextInt());
					l1 = node;
				}
				else
				{
					node.next = new ListNode(sc.nextInt());
					node = node.next;
				}				
			}
			node = l2;
			for(int i = 0; i < m; i++)
			{
				if(l2 == null)
				{
					node = new ListNode(sc.nextInt());
					l2 = node;
				}
				else
				{
					node.next = new ListNode(sc.nextInt());
					node = node.next;
				}				
			}
			ListNode res = f.addTwoNumbers(l1, l2);
			while(res != null)
			{
				System.out.println(res.val);
				res = res.next;
			}
			
		}		
		sc.close();
	}
	
}

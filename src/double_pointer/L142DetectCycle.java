package double_pointer;

import double_pointer.L141HasCycle.ListNode;

public class L142DetectCycle {
	/*
	 * 142. 环形链表 II
	 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
	 */
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head)
	{
		ListNode fast = head, slow = head;
		while(fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
			{
				slow = head;
				break;
			}
		}
		if(fast == null || fast.next == null)
		{
			return null;
		}
		while(fast != slow)
		{
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}

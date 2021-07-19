package double_pointer;

public class L160GetIntersectionNode {
	/*
	 * 160. 相交链表
	 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
	 */
	class ListNode 
	{
		int val;
		ListNode next;
		ListNode(int x) 
		{
			val = x;
			next = null;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
	{
		ListNode ha = headA, hb = headB;
		if(headA == null || headB == null)
		{
		    return null;
		}
		while(ha != hb)
		{
		    if(ha == null)
		    {
		        ha = headB;
		    }
		    else
		    {
		        ha = ha.next;
		    }
		    if(hb == null)
		    {
		        hb = headA;
		    }
		    else
		    {
		        hb = hb.next;
		    }           
		}
		return ha;
    }
}

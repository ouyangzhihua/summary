package divide_and_conquer;

public class L148SortList {
	/*
	 * 148. 排序链表
	 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
	 * 
	 * 方法：归并排序
	 */
	class ListNode 
	{
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode sortList(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		ListNode fast = head.next, slow = head;
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode node = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(node);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left != null && right != null)
        {
            if(left.val < right.val)
            {
                h.next = left;
                left = left.next;
            }
            else
            {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        if(left != null)
        {
            h.next = left;
        }
        else{
            h.next = right;
        }
        return res.next;
	}
}

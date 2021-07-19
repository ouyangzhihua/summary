package linked_list;

public class L206ReverseList {
	/*
	 * 206. 反转链表
	 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
	 */
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode pre = null, cur = head;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}

package double_pointer;


public class L19RemoveNthNodeFromEnd {
	/*
	 * 19. 删除链表的倒数第 N 个结点
	 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。进阶：你能尝试使用一趟扫描实现吗？
	 */
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		ListNode formmer = head, latter = head;
		while(n > 0)
		{
			latter = latter.next;
			n--;
		}
		if(latter == null)
		{
			return head.next;
		}
		while(latter.next != null)
		{
			formmer = formmer.next;
			latter = latter.next;
		}
		formmer.next = formmer.next .next;
		return head;
	}
}
